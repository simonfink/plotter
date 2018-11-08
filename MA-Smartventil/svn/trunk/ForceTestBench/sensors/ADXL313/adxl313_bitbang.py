import time
import sys
import RPi.GPIO as GPIO

class ADXL313(object):
	
	def __init__(self, csPin = 8, misoPin = 9, mosiPin = 10, clkPin = 11):		
		self.csPin = csPin
		self.misoPin = misoPin
		self.mosiPin = mosiPin
		self.clkPin = clkPin
		self.setupGPIO()
		
	def setupGPIO(self):
		GPIO.setwarnings(False)
		GPIO.setmode(GPIO.BCM)
		#~ GPIO.setmode(GPIO.BOARD)
		GPIO.setup(self.csPin, GPIO.OUT)
		GPIO.setup(self.misoPin, GPIO.IN)
		GPIO.setup(self.mosiPin, GPIO.OUT)
		GPIO.setup(self.clkPin, GPIO.OUT)

		GPIO.output(self.csPin, GPIO.HIGH)
		#~ GPIO.output(self.clkPin, GPIO.LOW)
		GPIO.output(self.mosiPin, GPIO.LOW)	
		GPIO.output(self.clkPin, GPIO.HIGH)

	def writeRegister(self, regNum, dataByte):
		GPIO.output(self.clkPin, GPIO.HIGH)
		#~ time.sleep(0.0001)
		GPIO.output(self.csPin, GPIO.LOW)
		#~ time.sleep(0.0001)
		# 0x8x to specify 'write register value'
		addressByte = 0x00 | regNum;
		# first byte is address byte
		self.sendByte(addressByte)
		#~ time.sleep(0.0001)
		# the rest are data bytes
		self.sendByte(dataByte)
		#~ time.sleep(0.0001)
		GPIO.output(self.clkPin, GPIO.HIGH)
		#~ time.sleep(0.0001)
		GPIO.output(self.csPin, GPIO.HIGH)
		
	def readRegisters(self, regNumStart, numRegisters):
		out = []
		GPIO.output(self.clkPin, GPIO.HIGH)
		#~ time.sleep(0.0001)
		GPIO.output(self.csPin, GPIO.LOW)
		# 0x to specify 'read register value'
		#~ time.sleep(0.0001)
		self.sendByte(regNumStart)
		for byte in range(numRegisters):
			#~ time.sleep(0.0001)	
			data = self.recvByte()
			out.append(data)
		#~ time.sleep(0.0001)
		GPIO.output(self.clkPin, GPIO.HIGH)
		#~ time.sleep(0.0001)
		GPIO.output(self.csPin, GPIO.HIGH)
		return out

	def sendByte(self,byte):
		for bit in range(8):
			GPIO.output(self.clkPin, GPIO.LOW)
			time.sleep(0.000001)
			if (byte & 0x80):
				GPIO.output(self.mosiPin, GPIO.HIGH)
			else:
				GPIO.output(self.mosiPin, GPIO.LOW)
			byte <<= 1
			time.sleep(0.000001)
			GPIO.output(self.clkPin, GPIO.HIGH)
			time.sleep(0.000001)

	def recvByte(self):
		byte = 0x00
		for bit in range(8):
			GPIO.output(self.clkPin, GPIO.LOW)
			time.sleep(0.000001)
			byte <<= 1
			if GPIO.input(self.misoPin):
				byte |= 0x1
			time.sleep(0.000001)
			GPIO.output(self.clkPin, GPIO.HIGH)
			time.sleep(0.000001)
		return byte
	
	
	def initialize(self):
		# POWER CONTROL: normal measuring mode
		# write 0
		
		
		x = self.writeRegister(0b00101101, 0b00000000)
		# read 1
		x = self.readRegisters(0b10101101, 1)
		assert(x[0] == 0)
		# write 0
		x = self.writeRegister(0b00101101, 0b01001000)
		# read 1
		x = self.readRegisters(0b10101101, 1)
		assert(x[0] == 0b01001000)


		# OFFSETS: all zero
		# write 0
		x = self.writeRegister(0b00011110, 0b00000000)
		# read 1
		x = self.readRegisters(0b10011110, 1)
		assert(x[0] == 0b00000000)
		# write 0
		x = self.writeRegister(0b00011111, 0b00000000)
		# read 1
		x = self.readRegisters(0b10011111, 1)
		assert(x[0] == 0b00000000)
		# write 0
		x = self.writeRegister(0b00100000, 0b00000000)
		# read 1
		x = self.readRegisters(0b10100000, 1)
		assert(x[0] == 0b00000000)


		# INTERRUPTS: disable all
		# write 0
		x = self.writeRegister(0b00101110, 0b00000000)
		# read 1
		x = self.readRegisters(0b10101110, 1)
		assert(x[0] == 0b00000000)
		# write 0
		x = self.writeRegister(0b00101111, 0b00000000)
		# read 1
		x = self.readRegisters(0b10101111, 1)
		assert(x[0] == 0b00000000)


		# DATA FORMAT: full resolution 1024 bit / g, range +-4g,
		# write 0
		x = self.writeRegister(0b00110001, 0b00001011)
		# read 1
		x = self.readRegisters(0b10110001, 1)
		assert(x[0] == 0b00001011)


		# DATA RATE 800 hz (3200 hz has more noise)
		# write 0
		x = self.writeRegister(0b00101100, 0b00001101)
		# read 1
		x = self.readRegisters(0b10101100, 1)
		assert(x[0] == 0b00001101)


		# FIFO CONTROL: overwrite old samples
		# write 0
		x = self.writeRegister(0b00111000, 0b10011111)
		# read 1
		x = self.readRegisters(0b10111000, 1)
		assert(x[0] == 0b10011111)

	def get_axes_measurement(self):
		o = self.readRegisters(0b11110010, 6)
		X_axis = (o[1]<<8)+o[0]
		Y_axis = (o[3]<<8)+o[2]
		Z_axis = (o[5]<<8)+o[4]
		
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
	csPin   = 19
	misoPin =  6
	mosiPin = 13
	clkPin  =  5
	adxl313 = ADXL313(csPin,misoPin,mosiPin,clkPin)
	print "initialized"
	#~ adxl313.writeRegister(0, 0xB2)
	
	
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
			#~ time.sleep(0.0007)
			end = time.time()
			delta_time = end - start;
			start = time.time()
			sensors_sps = 1.0/delta_time
			print("samples per second: ", sensors_sps)
			sys.stdout.write("\033[F \033[F")
	except KeyboardInterrupt: # Ctrl+C pressed
		GPIO.cleanup()
	
	GPIO.cleanup()
	
