import turtle
import math

print(math.pi)
pen = turtle.Turtle()
# You can not do pen = Turtle() as it is not in the standard library
"""pen.forward(100)
pen.left(90)
pen.forward(100)
pen.left(90)
pen.forward(100)
pen.left(90)
pen.forward(100)
pen.left(90) """

side = 100
pen.color("red")
pen.forward(side)
pen.left(90)
pen.forward(side)
pen.left(90)
pen.forward(side)
pen.left(90)
pen.forward(side)
pen.left(90)

t_size = 80
blueT = turtle.Turtle()
blueT.color('blue')
blueT.width(10)

for i in range(3):
    blueT.forward(t_size)
    blueT.right(120)

    # Right is clockwise , left is counter clockwise

blueT.forward(t_size)
blueT.color("orange")
blueT.circle(50)

blueT.width(5)
blueT.color("green")
blueT.forward(t_size)
blueT.up()
blueT.forward(t_size)
blueT.down()
blueT.forward(t_size)
blueT.hideturtle()

"""                           lect 4                      """
line1 = 'Hello Python developer...'
line2 = 'Welcome to the world of Python!'
print(line1)
print(line2)

print(0)
print(0.0)
print('zero')
print([0, 1, 'two'])

first = input('Your first name: ')
last = input('Your last name: ')
print(first + ' ' + last)

age = input('Enter your age: ')
print(age)

name = input('Enter your name: ')
age1 = int(input('Enter your age: '))
print( name + ", you will be " + age + " next year!")

if age1 >= 18:
    print("You can vote!")
else:
    print("Sucks that you can't vote.")









