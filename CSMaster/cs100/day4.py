"""
- Python also has a general sequence type that is similar to a list, but is
immutable. A tuple is a comma-separated sequence of items enclosed in
parentheses.

"""

pets = ('ant', 'bat', 'cod', 'dog', 'elk')
tple = (0, 1, 'two', 'three', [4, 'five'])
nums = (0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

#pets.append("cat") A tuple is NOT mutable, it can NOT be changed.
print(pets)

noParens = 'a', 'b'
print(type(noParens))
print(noParens)

print(0 in pets)

newTup =pets +nums
print(newTup)

pets =  pets * 3
print(pets)

lst = [1,3,5,7]

print(lst[1:4]) # Inclusive start, exclusive end

print(lst[0])

p1 = ["do","it","better"]
p2 =["make","us","stronger"]
print (p1[1:3]) #     print (p1[1:3]+ " "+p2[1] + " "+p2[2:]) TypeError: can only concatenate list (not "str") to list

a = 3
b = 3.0
c = "three"

d = [1,2,3]

print(type(a))

#ints in python have no upper bound but floats do

nu = -3 # you should do (int)-3 but most do not
print(nu)

import math

print(math.sqrt(4))

print(math.pi)




