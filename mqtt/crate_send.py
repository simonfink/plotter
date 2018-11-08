#!/usr/bin/env python
from crate import client

connection = client.connect("http://localhost:4200", username="crate")
cursor = connection.cursor()

cursor.execute("""INSERT INTO smartvalve (nodeid, tstamp, temp, humi) VALUES(0,4,42.45234,23.4425)""")

cursor.execute("SELECT * FROM smartvalve")

result = cursor.fetchall()

print(result)
