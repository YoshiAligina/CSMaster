"""
Yoshita Aligina
CS 100 Section 011
HW 09, Nov 5th, 2023
"""
import string
#p1
def file_copy(in_file, out_file):
    with open(in_file, 'r') as infile:
        content = infile.read()
    with open(out_file, 'w') as outfile:
        outfile.write(content)
file_copy('created_equal.txt', 'copy.txt')
copy_f = open('copy.txt')
print(copy_f.read())

#p2
def file_copy(in_file, out_file):
    with open(in_file, 'r') as infile:
        content = infile.read()
    with open(out_file, 'w') as outfile:
        outfile.write(content)
file_copy('created_equal.txt', 'copy.txt')
copy_f = open('copy.txt')
print(copy_f.read())

#p3
def repeat_words(in_file, out_file):
    with open(in_file, 'r') as infile:
        lines = infile.readlines()
    with open(out_file, 'w') as outfile:
        for line in lines:
            words = line.lower().strip(string.punctuation).split()
            seen = set()
            repeated_words = set()
            for word in words:
                if word in seen and word not in repeated_words:
                    repeated_words.add(word)
                seen.add(word)
            outfile.write(' '.join(repeated_words) + '\n')
inF = 'catInTheHat.txt'
outF = 'catRepWords.txt'
repeat_words(inF, outF)

