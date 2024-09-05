# A for loop takes the form of a header and a body.

greeting = "hello"

for letter in greeting:
    print(letter)

word = "apple"

for letter in word:
    print(letter)

#pythontutor.com

days = ('Mon','Tue','Wed','Thu','Fri','Sat','Sun')
for day in days:
    print(day)

oneTwoThree = [1, 2, 3]
newList = []

for num in oneTwoThree:
    newList.append(num)

for i in oneTwoThree:
    newList.append(i + 3)
    print('i = ',i)
    print('oneTwoThree = ', oneTwoThree)
    print('newList = ', newList)

    #The start is inclusive, but the end is not.
for i in range(2,15):
    print (i)
    #1 skip till 3, skip 4 5 6
for i in range(1,6,3):
    print (i)

for i in range(0,11):
    print (i)
for i in range(0,10):
    print (i)
for i in range(0,9,2):
    print (i)
for i in range(1,10,2):
    print (i)
for i in range(20,61,10):
    print (i)

start = 0
stop = 11
step = 1
for i in range(start,stop,step):
    print (i,end=" , ")

for i in range(0,11,1):
    if i!=10:
        print(str(i)+", ",end = " ")
    else:
        print(i)
for i in range(start,stop,step):
    if i!=stop-step:
        print(str(i)+", ",end = " ")
    else:
        print(i)
# The stop minus the step.




