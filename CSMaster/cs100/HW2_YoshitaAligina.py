"""
Yoshita Aligina
CS 100 Section 011
HW 02, September 20th, 2023
"""

#1
grades = ["A","A","F","D","D","C","B","B","F","B"]
print(grades)

frequency=[grades.count('A'), grades.count('B'), grades.count('C'),grades.count('D'),grades.count('F')]
print(frequency)

#2
dog_breeds=['Collie', 'SheepDog', 'Chow', 'Chihuahua']
print(dog_breeds)

herding_dogs=[dog_breeds[0:2]] # I think the first is inclusive but the second isnt?? ,, i forget\
#but it works??
print(herding_dogs)

tiny_dogs = [dog_breeds[3]]
print(tiny_dogs)

print('Persian' in dog_breeds)
# print('Chow' in dog_breeds)
