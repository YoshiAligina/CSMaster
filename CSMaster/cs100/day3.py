"""2's complement
111 = 7
110 = 6
101 = 5
100 = 4
011 = 3
010= 2
001 = 1
000 = 0
111 = -1
110 = -2
101 = -3
100 = -4
011 = -5
"""
"""
- A list is a list that is a comma separated sequence within square brackets.

- Lists can be modified; they are said to be mutable
- Strings can’t be modified; they are said to be immutable
- You can not sum five strings. It is an unsupported operand type.
- len() and sum() are examples of functions that can be called with a list input
argument; they can also be called on other types of input
- There are also functions that are called on a list;
such functions are called list methods
- For a max in a string series, you will typically get the furthest in the dictionary.
- Mutable = Changable
"""

pets = ['ant', 'bat', 'cod', 'dog', 'elk']
lst = [0, 1, 'two', 'three', [4, 'five']] # A nested list IS Legal
nums = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

print('ant' in pets) # Asking if ant is an element in pets.
print(pets + nums) # + Is an addition feature if pets is numbers, BUT is concatination if it is anything else.
print(pets)

newList = pets + nums
print(newList) # This is making it a new list.

print(pets*3) # Prints the array thrice.
print(pets[1]) # Prints the second element in the list pets.
print(pets[-1]) # Prints the last item in the list no matter the length
print(len(pets)) # Prints the length of the list pets starting with one

# pets = "hello" # Will replace the entire list with hello
# pets[2] = "hello" # Will replace array poisition two with hello
pet = "cod"
pet = "my" + pet + "s"
print(pet)
# You can not replace a letter in cod  here because strings are mutable.


print('ant'<'zebra')

pets.append("rhino") # Adds rhino to the list pets
print (pets)
print(pets.count("rhino")) # Counts how often rhino appears in list pets.

lst = [1,2,3]
lst.append(7)
lst.append(3)

result = lst.sort()
print(lst) # This prints in non-descending order.







