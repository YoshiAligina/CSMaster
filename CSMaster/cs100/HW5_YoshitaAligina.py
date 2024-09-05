"""
Yoshita Aligina
CS 100 Section 011
HW 05, October 2nd, 2023
"""

#Task 1
months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
for month in months:
    if month.startswith('J'):
        print(month)

# Task 2
for number in range(100):
    if number % 2 == 0 and number % 5 == 0:
        print(number)

#Task 3
horton = "A person's a person, no matter how small."
vowels = "aeiouAEIOU"
for char in horton:
    if char in vowels:
        print(char)
