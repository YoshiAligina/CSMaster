import dog
"""
Yoshita Aligina
CS 100 Section 011
HW 11, Nov 25th, 2023
"""

class Dog:
    """A class representing a dog."""
    species = 'Canis familiaris'

    def __init__(self, name, breed):
        """Initialize a Dog with a name and breed."""
        self.name = name
        self.breed = breed
        self.tricks = []

# Problem 1

if __name__ == "__main__":
    sugar = Dog('Sugar', 'border collie')
    print(sugar.name)
    print(sugar.breed)

# Problem 2

print(sugar.tricks)

# Problem 3

def teach(self, trick):
    """Teach a trick to the dog."""
    self.tricks.append(trick)
    print(f"{self.name} knows {trick}")

Dog.teach = teach
sugar.teach('frisbee')

# Problem 4

def knows(self, trick):
    """Check if the dog knows a trick."""
    if trick in self.tricks:
        print(f"Yes, {self.name} knows {trick}")
        return True
    else:
        print(f"No, {self.name} doesn't know {trick}")
        return False

Dog.knows = knows

print(sugar.knows('frisbee'))
print(sugar.knows('arithmetic'))

# Problem 5

print(Dog.species)
print(sugar.species)
