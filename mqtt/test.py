#!/usr/bin/env python
import pika

connection = pika.BlockingConnection("172.16.75.125")
channel = connection.channel()


