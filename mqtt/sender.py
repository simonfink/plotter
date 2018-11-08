#!/usr/bin/env python
import pika
from sense_hat import SenseHat
import sys
import time

sense = SenseHat()

credentials = pika.PlainCredentials('raspberrypi','pi')
connection = pika.BlockingConnection(pika.ConnectionParameters('172.16.51.196', 5672, '/', credentials))
channel = connection.channel()

channel.exchange_declare(exchange='smartValve1',
	exchange_type='topic')

for x in range(0,100):
	routing_key = 'rpiNode1.sensors'
	message = str(time.time())+' '
	message += str(sense.get_temperature())+' '
	message += str(sense.get_humidity())
	channel.basic_publish(exchange='smartValve1', routing_key=routing_key, body=message)

print(" [x] Sent %r:%r" % (routing_key, message))

connection.close()
