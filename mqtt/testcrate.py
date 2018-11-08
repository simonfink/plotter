#!/usr/bin/env python
from crate import client

connection = client.connect("localhost:4200", username="rpi")
print(connection)
cursor = connection.cursor()
print(cursor)
cursor.execute("SELECT * FROM smartvalve;")
result = cursor.fetchone()
print(result)
