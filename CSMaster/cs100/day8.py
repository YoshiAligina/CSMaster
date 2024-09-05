def iSquaredPlus10(x):
    result = x**2 + 10
    return result

print(iSquaredPlus10(1))
print(iSquaredPlus10(5))
print(iSquaredPlus10(8))

squarePlusTen = iSquaredPlus10(5)
print(squarePlusTen)

def iSquaredPlus10(x):
    result = x**2 + 10
    print(result)  #Different than return.

def myAbs(num):
    if num < 0:
        return -num
    else:
        return num
inNum = -9
r  = myAbs(inNum)
print(r)

#Num will be -9 regardless since the two scopes are different.

def myMax(lst):
    largestSoFar = lst[0]
    for num in lst:
        if num > largestSoFar:
            largestSoFar = num
    return largestSoFar

nums = [-9,5,14,2,7]
r = myMax(nums)
print(r)

def myLen(lst):
    counter  = 0;
    for el in lst:
        counter += 1
    return counter
    # print(counter) will set the values to NONE

nums1 = [17,12,55,2,8,3,2,67,3]
nums2 = [-9,5,14,2,7]
r = myLen(nums1)
s = myLen(nums2)
print(r)
print(s)

def areaOfRectangle(a,b):
    return a*b

l = 5
w = 4
r = areaOfRectangle(l,w)
print(r)

def hello(name):
    return 'Welcome, ' + name + ', to the world of Python.'
    """"
    line = 'Welcome, ' + name + ', to the world of Python.'
    print(line)
name = input()
soup = hello(name)

print(soup) """

print(hello("Yoshi"))

def oddCount(aNumList):
    result = 0
    for i in aNumList:
        if i%2 == 1:
            result += 1
    return result

numList = [4, 0, 1, -2,7,3,2,5,6,7,84,2,5,7,63,4,7,8,4]
print(oddCount(numList))

def evenCount(aNumList):
    result = 0
    for i in aNumList:
        if i%2 != 1:
            result += 1
    return result

numList = [4, 0, 1, -2,7,3,2,5,6,7,84,2,5,7,63,4,7,8,4]
print(evenCount(numList))

def countVowels(string):
    counter = 0
    vowels = "aeiouAEIOU"
    for whatever in string:
        if whatever in vowels:
            counter+=1
    return counter
def countChars(string, chars):
    count = 0
    for letter in string:
        if letter in chars:
            count+=1
    return count

s = "Hello, how are you?"
v = "abcdef"
print(countVowels(s))
print(countChars(s,v))

def countChars2(lst, chars):
    count = 0
    for s in lst:
        for letter in s:
            if letter in chars:
                count+=1
    return count
print(countChars2(s,v))


def countVowels2(lst):
    vowels = "AEIOUaeiou"
    myLst = []
    for word in lst:
        count = 0
        for letter in word:
            if letter in vowels:
                count+=1
        myLst.append(count)
    return myLst
s =["Hello","How","Are","You?"]
print(countVowels2(s))

s = "When in the course of human events..."

print(s.capitalize())

if "zeb" in s:
    print(s.index("zeb"))
else:
    print("'zeb' not in string")

for letter in s:
    if letter.isalpha():
        print("LETTER")
    elif letter.isdigit():
        print("DIGIT")
    elif letter.isspace(): # " " is only space
        print("SPACE!")
    elif letter  == ".": # elif letter in string.punctuation: does all punctuation
        print("PUNCTUATION!")

t = "Captain, there is a tranmission incoming."
print(t.split(","))

u = "(hello!)"
print(u.strip("()!"))
