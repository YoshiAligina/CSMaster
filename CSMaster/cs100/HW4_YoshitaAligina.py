"""
Yoshita Aligina
CS 100 Section 011
HW 04, September 26th, 2023
"""
import turtle

# Problem 1
a=3
b=4
c=5
if a < b:
    print("OK")
if c < b:
    print("OK")
if a + b == c:
    print("OK")
if a**2 + b**2 == c**2: #  I forgot if there was any other way to do squaring.
    print("OK")

print (" \n ") # This is for my own visual looking, not necessary in the problem

# Problem 2
a=3
b=4
c=5
if a < b:
    print("OK")
else:
    print("NOT OK")
if c < b:
    print("OK")
else:
    print("NOT OK")
if a + b == c:
    print("OK")
else:
    print("NOT OK")
if a**2 + b**2 == c**2:
    print("OK")
else:
    print("NOT OK")

#Problem 3

t= turtle.Turtle()
colours = input("What color? ")
width = int(input("What line width? "))
length = int(input("What line length? "))
shape = input("Line, triangle, or square? ")


def line(colour,wid,leng):
    turtle.pencolor(colour)
    turtle.pensize(wid)
    turtle.forward(leng)
def tri(colour,wid,leng):
    turtle.pencolor(colour)
    turtle.pensize(wid)
    for i in range(3):
        turtle.forward(leng)
        turtle.left(120)
def square(colour,wid,leng):
    turtle.pencolor(colour)
    turtle.pensize(wid)
    for i in range(4):
        turtle.forward(leng)
        turtle.left(90)

if shape == "line":
    line(colours,width,length)
elif shape == "triangle":
    tri(colours,width,length)
elif shape == "square":
    square(colours,width,length)
else:
    print("Invalid shape choice. Please choose 'line', 'triangle', or 'square'.")


