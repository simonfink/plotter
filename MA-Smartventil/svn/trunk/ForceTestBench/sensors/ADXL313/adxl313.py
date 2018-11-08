import spidev
import time
import sys


class ADXL313(object):
	
	def __init__(self, bus, device):
		self.bus = bus
		self.device = device
		self.spi = spidev.SpiDev()
		self.spi.open(bus, device)
		#~ self.spi.max_speed_hz = 3000000
		self.spi.max_speed_hz = 1900000
		self.spi.mode = 0b11 #clock polarity and phase [CPOL|CPHA], min: 0b00 = 0, max: 0b11 = 3


	def spi_close(self):
		self.spi.close()

	def initialize(self):
		# POWER CONTROL: normal measuring mode
		# write 0
		x = self.spi.xfer2([0b00101101, 0b00000000])
		# read 1
		x = self.spi.xfer2([0b10101101, 0b00000000])
		#~ assert(x[1] == 0)
		# write 0
		x = self.spi.xfer2([0b00101101, 0b01001000])
		# read 1
		x = self.spi.xfer2([0b10101101, 0b00000000])
		assert(x[1] == 0b01001000)


		# OFFSETS: all zero
		# write 0
		x = self.spi.xfer2([0b00011110, 0b00000000])
		# read 1
		x = self.spi.xfer2([0b10011110, 0b00000000])
		assert(x[1] == 0b00000000)
		# write 0
		x = self.spi.xfer2([0b00011111, 0b00000000])
		# read 1
		x = self.spi.xfer2([0b10011111, 0b00000000])
		assert(x[1] == 0b00000000)
		# write 0
		x = self.spi.xfer2([0b00100000, 0b00000000])
		# read 1
		x = self.spi.xfer2([0b10100000, 0b00000000])
		assert(x[1] == 0b00000000)


		# INTERRUPTS: disable all
		# write 0
		x = self.spi.xfer2([0b00101110, 0b00000000])
		# read 1
		x = self.spi.xfer2([0b10101110, 0b00000000])
		assert(x[1] == 0b00000000)
		# write 0
		x = self.spi.xfer2([0b00101111, 0b00000000])
		# read 1
		x = self.spi.xfer2([0b10101111, 0b00000000])
		assert(x[1] == 0b00000000)


		# DATA FORMAT: full resolution 1024 bit / g, range +-4g,
		# write 0
		x = self.spi.xfer2([0b00110001, 0b00001011])
		# read 1
		x = self.spi.xfer2([0b10110001, 0b00000000])
		assert(x[1] == 0b00001011)


		# DATA RATE 800 hz (3200 hz has more noise)
		# write 0
		x = self.spi.xfer2([0b00101100, 0b00001101])
		# read 1
		x = self.spi.xfer2([0b10101100, 0b00000000])
		assert(x[1] == 0b00001101)


		# FIFO CONTROL: overwrite old samples
		# write 0
		x = self.spi.xfer2([0b00111000, 0b10011111])
		# read 1
		x = self.spi.xfer2([0b10111000, 0b00000000])
		assert(x[1] == 0b10011111)

	def get_axes_measurement(self):
		o = self.spi.xfer2([0b11110010, 0b00000000, 0b00000000, 0b00000000, 0b00000000, 0b00000000, 0b00000000])
		X_axis = (o[2]<<8)+o[1]
		Y_axis = (o[4]<<8)+o[3]
		Z_axis = (o[6]<<8)+o[5]
		
		if X_axis> 0x7FFF:
			X_axis -= 0x10000
		if Y_axis> 0x7FFF:
			Y_axis -= 0x10000
		if Z_axis> 0x7FFF:
			Z_axis -= 0x10000
			
		g_x = float(X_axis) / 1024
		g_y = float(Y_axis) / 1024
		g_z = float(Z_axis) / 1024
		return {"x": g_x, "y": g_y, "z": g_z}


if __name__ == "__main__":
	adxl313 = ADXL313(bus=0,device=1)
	print "initialized"
	adxl313.initialize()
	start = time.time()
	try:
		while True:
			# check if it makes sense to validate measurements
			axes = adxl313.get_axes_measurement()
			#~ print "   x = %06.2f m/s^2" % (axes['x'])
			#~ print "   y = %06.2f m/s^2" % (axes['y'])
			#~ print "   z = %06.2f m/s^2" % (axes['z'])
			
			print "{:10.4f}".format(axes['x']), "{:10.4f}".format(axes['y']), "{:10.4f}".format(axes['z'])
			time.sleep(0.0007)
			end = time.time()
			delta_time = end - start;
			start = time.time()
			sensors_sps = 1.0/delta_time
			print("samples per second: ", sensors_sps)
			sys.stdout.write("\033[F \033[F")
	except KeyboardInterrupt: # Ctrl+C pressed
		spi.close()
