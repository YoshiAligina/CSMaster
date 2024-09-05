"""
Yoshita Aligina
CS 100 Section 011
HW 03, September 23rd, 2023
"""
import turtle
import math

t = turtle.Turtle()

# 1
for i in range(3):
    t.forward(100)
    t.left(120)
t.penup()
t.forward(150)
t.pendown()
for i in range(4):
    t.forward(100)
    t.left(90)
t.penup()
t.forward(150)
t.pendown()
for i in range(5):
    t.forward(100)
    t.left(72)

#2
t.penup()
t.backward(450)
t.pendown()
t.circle(50)
t.circle(100)
t.circle(150)
t.circle(200)

# 3

a = math.factorial(100)

b = math.log2(1000000)

c= math.gcd(63,49)

print(a)
print(b)
print(c)
