#!/usr/bin/env python
import pika
import sys

credentials = pika.PlainCredentials('fsi', 'fsi')
parameters = pika.ConnectionParameters('172.18.252.25', 5672, '/', credentials)

connection = pika.BlockingConnection(parameters)

channel = connection.channel()

#channel.exchange_declare(exchange='topic_logs',
#                         exchange_type='topic')

#routing_key = sys.argv[1] if len(sys.argv) > 2 else 'anonymous.info'
#message = ' '.join(sys.argv[2:]) or 'Hello World!'
#channel.basic_publish(exchange='topic_logs',
#                      routing_key=routing_key,
#                      body=message)
#print(" [x] Sent %r:%r" % (routing_key, message))
connection.close()
