"""
Yoshita Aligina
CS 100 Section 011
HW 10, Nov 8th, 2023
"""
# P1
def initialLetterCount(wordList):
    letter_count = {}
    for word in wordList:
        initial_letter = word[0]
        if initial_letter in letter_count:
            letter_count[initial_letter] += 1
        else:
            letter_count[initial_letter] = 1
    return letter_count
# Test Cases
tc1 = ['I', 'say', 'what', 'I', 'mean', 'and', 'I', 'mean', 'what', 'I', 'say']
print(initialLetterCount(tc1))
# Output: {'I': 4, 's': 2, 'w': 2, 'm': 2, 'a': 1}
tc2 = ['apple', 'orange', 'banana']
print(initialLetterCount(tc2))
# Output: {'a': 2, 'o': 1, 'b': 1}
tc3 = ['Python', 'Java', 'C++', 'JavaScript']
print(initialLetterCount(tc3))
# Output: {'P': 1, 'J': 1, 'C': 1}

#P2
def initialLetters(wordList):
    letter_words = {}
    for word in wordList:
        initial_letter = word[0]
        if initial_letter in letter_words:
            if word not in letter_words[initial_letter]:
                letter_words[initial_letter].append(word)
        else:
            letter_words[initial_letter] = [word]
    return letter_words
# Test Cases
tc4 = ['I', 'say', 'what', 'I', 'mean', 'and', 'I', 'mean', 'what', 'I', 'say']
print(initialLetters(tc4))
# Output: {'I': ['I'], 's': ['say'], 'w': ['what'], 'm': ['mean'], 'a': ['and']}
tc5 = ['apple', 'orange', 'banana']
print(initialLetters(tc5))
# Output: {'a': ['apple'], 'o': ['orange'], 'b': ['banana']}
tc6 = ['Python', 'Java', 'C++', 'JavaScript']
print(initialLetters(tc6))
# Output: {'P': ['Python'], 'J': ['Java', 'JavaScript'], 'C': ['C++']}



