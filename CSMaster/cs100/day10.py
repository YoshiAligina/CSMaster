#inFile = open('C:\Users\yoshi\Desktop\cs100thisLandIsYourLand.txt','rt')

"""
r = reading
w = writing
a = append
r+= reading and writing
t = text
b = binary

contents.inFile.read()
print(contents)

inFile.close()
"""

hdList = ['Humpty Dumpty sat on a wall.', 'Humpty Dumpty had a great fall.', "All the king's horses and all the king's men",
"Couldn't put Humpty together again!"]
humptyFile = open('humpty.txt','w')
for line in hdList:
    num = humptyFile.write(line+ "\n")
    print(num)

humptyFile = open('humpty.txt', 'r')
for line in humptyFile:
    if 'Humpty' in line:
        print(line, end = '')

humptyFile.close()
