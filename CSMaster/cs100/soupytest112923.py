import dog

# Test Problem 1
sugar = dog.Dog('Sugar', 'border collie')
print(sugar.name)  # Should print 'Sugar'
print(sugar.breed)  # Should print 'border collie'

# Test Problem 2
print(sugar.tricks)  # Should print []

# Test Problem 3
sugar.teach('frisbee')  # Should print "Sugar knows frisbee"

# Test Problem 4
print(sugar.knows('frisbee'))  # Should print "Yes, Sugar knows frisbee" and True
print(sugar.knows('arithmetic'))  # Should print "No, Sugar doesn't know arithmetic" and False

# Test Problem 5
print(dog.Dog.species)  # Should print 'Canis familiaris'
print(sugar.species)  # Should print 'Canis familiaris'
