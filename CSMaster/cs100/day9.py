i = 7
while i <= 37:
    i+=7
print(i)

"""def getNegativeNumber():
    num = 0
    while num >= 0:
        num = (int(input("Give me a negative: "))
    return num
print (getNegativeNumber())
"""
def hello():
    while True:
        name = input("What is your name? ")
        print("Hello {}".format(name))

hello()

def cities():
    lst = []

    while True:
        city = input("Enter City:")
        if city == "":
            return lst
        lst.append(city)
print(cities())

