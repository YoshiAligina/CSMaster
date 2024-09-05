"""
Yoshita Aligina
CS 100 Section 011
HW 08, October 28th, 2023
"""
#p1
def twoWords(length, firstLetter):
    while True:
        first_word = input("Enter the first word with {} characters: ".format(length))
        second_word = input("Enter the second word starting with '{}': ".format(firstLetter))

        if len(first_word) == length and (second_word[0].lower() == firstLetter.lower()):
            return [first_word, second_word]
        else:
            print("Invalid input. Please try again.")

length = int(input("Enter the length of the first word: "))
firstLetter = input("Enter the first letter of the second word: ")
result = twoWords(length, firstLetter)
print("The two words you entered are:", result)
#p 2
def twoWordsV2(length, firstLetter):
    valid_input = False
    while not valid_input:
        first_word = input("Enter the first word with {} characters: ".format(length))
        second_word = input("Enter the second word starting with '{}': ".format(firstLetter))

        if len(first_word) == length and (second_word[0].lower() == firstLetter.lower()):
            valid_input = True
        else:
            print("Invalid input. Please try again.")

    return [first_word, second_word]

length = int(input("Enter the length of the first word: "))
firstLetter = input("Enter the first letter of the second word: ")
result = twoWordsV2(length, firstLetter)
print("The two words you entered are:", result)
