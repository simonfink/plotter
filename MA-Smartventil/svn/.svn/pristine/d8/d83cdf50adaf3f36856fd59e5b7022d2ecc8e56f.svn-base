#!/usr/bin/env python
"""
Prerequisites:
pip install npTDMS
sudo apt-get install ipython python-matplotlib python-scipy
sudo raspi-config (enable SPI)


This demo cycles the valve and store the measured sensors in the tdms folder.
You can set:
1) Number of cycles to be performed
2) Seconds of measurement per cycle
3) Delay between cycles
4) Starting position (open/close) for the measurement
"""

from nptdms import TdmsFile, TdmsWriter, ChannelObject
from IPython import embed
import pygame

import time, os, sys
import numpy as np
import matplotlib
import matplotlib.pyplot as plt
import RPi.GPIO as GPIO
import sensors.EXPANDER.ExpanderPi as ExpanderPi
import warnings
import ConfigParser


## disable warnings
warnings.filterwarnings("ignore",".*GUI is implemented.*")
GPIO.setwarnings(False)

## PARAMETERS
# read config file
try:
	config = ConfigParser.ConfigParser()
	config.read('ForceTestbench.conf')
except:
	print("configfile not found")

try:
	save_path       = config.get("File","save_path")
	save_each_cycle = config.getint("Measurement","save_each_cycle")     # saving is done only after that number of cycles (set to 1 for saving every cycle)

	pretrigger      = config.getfloat("Measurement","pretrigger")        # time from start measuring to setting output
	closing_time    = config.getfloat("Measurement","closing_time")      # time for closing motion
	opening_time    = config.getfloat("Measurement","opening_time")      # time for opening motion
	sps             = config.getint("Measurement","samples_per_second")
	n_cycles        = config.getint("Measurement","n_cycles")

	#sensor_names    = config.get("Hardware","sensor_names")
	controlPin      = config.getint("Hardware","solenoid_pin")

	save_mode       = config.getboolean("User","save_mode")
	#visual_mode     = config.getboolean("User","visual_mode")
		
except:
	print("parameter not found")
	
sensor_names = ["pressure_festo", "force_baumer", "force_vat"]			 # TODO: include into configfile
visual_mode = True

def create_figure_signals():
    """
    creates a figure containing 3 plots column
    the content of the plot depends on the variable sensor_names
    """
    plt.ion()
    fig, ax = plt.subplots(len(sensor_names), 1, sharex=True, figsize=(10,10))			
    #~ fig.tight_layout()
    fig.canvas.set_window_title('Force Testbench Signals')
    p = [[None for _ in range(1)] for _ in range(3)]
    i = 0
    p[i][0], = ax[i].plot([], [], 'b', marker='None', linestyle='-', label=sensor_names[0])
    ax[i].set_title(sensor_names[0])
    ax[i].legend(loc='upper right', shadow=True, fontsize='large')
    ax[i].set_ylabel('Bars')
    ax[i].grid()
    i = 1
    p[i][0], = ax[i].plot([], [], 'b', marker='None', linestyle='-', label=sensor_names[1])
    ax[i].set_title(sensor_names[1])
    ax[i].legend(loc='upper right', shadow=True, fontsize='large')
    ax[i].set_ylabel('Newton')
    ax[i].grid()
    i = 2
    p[i][0], = ax[i].plot([], [], 'b', marker='None', linestyle='-', label=sensor_names[2])
    ax[i].set_title(sensor_names[2])
    ax[i].legend(loc='upper right', shadow=True, fontsize='large')
    ax[i].set_ylabel('Newton')
    ax[i].grid()
    return fig, ax, p


def plot_signals(sensor_data, time_vector, fig, ax, p):
	"""
	the function fills the figure with sensor_data
	"""
	try:
		i = 0
		p[i][0].set_data(time_vector, sensor_data[i,:])
		ax[i].relim()
		ax[i].autoscale_view(True,True,True)
		i = 1
		p[i][0].set_data(time_vector, sensor_data[i,:])
		ax[i].relim()
		ax[i].autoscale_view(True,True,True)
		i = 2
		p[i][0].set_data(time_vector, sensor_data[i,:])
		ax[i].relim()
		ax[i].autoscale_view(True,True,True)
		plt.show()
		plt.pause(0.0001)
		
	except:
		print("plotting error")

    
def save_signals(sensor_data, data_sps, act_cycle):
    """
    the function saves sensordata into a tdms file.
    the file is stored into the variable save_path, filename is the actual cycle nr.
    """
    wf_increment    = 1.0/np.mean(data_sps)
    wf_start_offset = 0.0
    
    try:
        with TdmsWriter(save_path + "/" + str(act_cycle) + ".tdms") as tdms_writer:
            for i in range(0, len(sensor_names)):
                channel = ChannelObject('open',sensor_names[i], sensor_data[i,:], properties={"wf_increment": wf_increment,"wf_start_offset": wf_start_offset})
                
                tdms_writer.write_segment([channel])
                
        print("cycle saved")
    except:
        print("saving not sucessfull")

    return


def close_valve(controlPin):
	GPIO.output(controlPin, GPIO.HIGH)
	config.set('Hardware','solenoid_status',True)

	return "closed"


def open_valve(controlPin):
	GPIO.output(controlPin, GPIO.LOW)
	config.set('Hardware','solenoid_status',False)
	return "open"

def check_if_valid(ref_sum, sensor_data_sum):
	check_min = sensor_data_sum < ref_sum*0.9
	check_max = sensor_data_sum > ref_sum*1.1

	if not((check_min == np.array([0,0,0],dtype=bool)).all()) or not((check_max == np.array([0,0,0],dtype=bool)).all()):
		print("measurement sum out of range: ")
		print sensor_data_sum
		sys.exit()
		
	return
	
def measure_cycle(adc):
    
    samples_per_cycle = int((pretrigger+closing_time+opening_time)*sps)
    
    # getting num samples from time
    pre_samples     = np.floor(pretrigger * sps)
    closing_samples = np.floor(closing_time * sps)
    opening_samples = np.floor(opening_time * sps)
    
    # building arrays for sensor_data
    time_vector  = np.zeros(samples_per_cycle)							# calculated timevector
    data_sps     = np.zeros(samples_per_cycle)							# measured sampling frequency
    sensor_data  = np.zeros([len(sensor_names),samples_per_cycle])		# matrix with measurement data
    sensor_analog= np.zeros([len(sensor_names),1]) 						# store the ADC reading at time t

    sensor_data_sum = np.zeros(len(sensor_names))
    sensor_data_sum_old = np.zeros(len(sensor_names))
    
    start_time = time.time()
    
    for current_sample in range(0,samples_per_cycle):
        # setting the output for solenoid
        if current_sample == pre_samples:
            close_valve(controlPin)
        elif current_sample == pre_samples + closing_samples:
            open_valve(controlPin)
        
        # read sensor data
        sensor_analog[0] = adc.read_adc_voltage(3,0) # pressure (board adc1)
        sensor_analog[1] = adc.read_adc_voltage(4,0) / 0.62 # force baumer (board adc2) the output from the sensor is multiplied by 0.62 so we divide to get original volts
        sensor_analog[2] = adc.read_adc_voltage(7,0) # force vat (board adc amplifier)
        
        sensor_data[:,current_sample] = sensor_analog[:,0]
        
        # summation of every sensor_data over one cycle
        sensor_data_sum = sensor_data_sum_old + sensor_data[:,current_sample]
        sensor_data_sum_old = sensor_data_sum

        # waiting for defined sps
        time_waiting = 1.0
        sample_time = 1.0 / sps
        while(time_waiting > 0):
            delta_time = time.time() - start_time
            time_waiting = sample_time - delta_time
        
        # timing
        end_time   = time.time()
        data_sps[current_sample] = 1.0/(end_time-start_time)
        
        start_time = time.time()
        
    print ("sum pressure    sum refForce   sum vatForce")
    print(sensor_data_sum)

    # go back to default position
    open_valve(controlPin)
    
    # generate time_vector with the same amount of values as in sensor_data. Timestep is the mean of the measured samplingrate
    time_vector = np.linspace(0.0, samples_per_cycle * 1.0/np.mean(data_sps), num=samples_per_cycle)
    
    return sensor_data, time_vector, data_sps, sensor_data_sum

def main():
    global visual_mode
	
    # ADC - SPI (channel 0)
    adc = ExpanderPi.ADC(bus=0, device=0)  # create an instance of the ADC
    adc.set_adc_refvoltage(5.0)
	
    # actor
    GPIO.setmode(GPIO.BCM)
    GPIO.setup(controlPin, GPIO.OUT)

    print("Going back to default position and preparing for measurement")
    open_valve(controlPin)
    
    time.sleep(1)
    
    fig1, ax1, p1 = create_figure_signals()
    pygame.init()
    pygame.display.set_mode((300, 300))

    try:
        
        for cycle_nr in range(1,n_cycles+1):
            events = pygame.event.get()
            
            for event in events:
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_v:
                        print("visual mode toggled")
                        visual_mode = not visual_mode # toggle visual mode
                        #config.set('User','visual_mode', visual_mode)

            sensor_data, time_vector, data_sps, sensor_data_sum = measure_cycle(adc)

            act_cycle = 1 + config.getint("Measurement","act_cycle")

            print("Cycle: %i/%i, sps: %f, save signals: %r" % (act_cycle, act_cycle-cycle_nr+n_cycles, np.mean(data_sps), (save_mode and act_cycle % save_each_cycle == 0)))
            
            if save_mode and act_cycle % save_each_cycle == 0:
                save_signals(sensor_data, data_sps, act_cycle)

            if visual_mode:
                plot_signals(sensor_data, time_vector, fig1, ax1, p1)

            try:
                config.set("Measurement","act_cycle",act_cycle)
                config.write(open("ForceTestbench.conf","w"))
            
                config.read('ForceTestbench.conf')
            except:
                print("could not write actual cycle nr into config file")
                
                
            check_if_valid(np.array([800,1450,680]), sensor_data_sum)
            
    except KeyboardInterrupt:
        sys.exit()

    ## CLEAN UP
    a = raw_input("Press Enter to exit")
    print("Finishing and returning to open position") # opening is default because it happens when GPIO is disabled
    GPIO.cleanup()
    adc.spi_close()

if __name__ == "__main__":
    os.system('clear')
    main()
