#!/usr/bin/env python
import pika
import sys

credentials = pika.PlainCredentials('raspberrypi','pi')
connection = pika.BlockingConnection(pika.ConnectionParameters('172.16.51.196', 5672, '/', credentials))
channel = connection.channel()

channel.exchange_declare(exchange='smartValve1',
	exchange_type='topic')

result = channel.queue_declare(exclusive=True)
queue_name = result.method.queue

binding_keys = 'rpiNode1.*.*'

channel.queue_bind(exchange='smartValve1', queue=queue_name, routing_key=binding_keys)

print(' [*] Waiting for logs. To exit press CTRL+C')

def callback(ch, method, properties, body):
    print(" [x] %r:%r" % (method.routing_key, body))

channel.basic_consume(callback,
                      queue=queue_name,
                      no_ack=True)

channel.start_consuming()
