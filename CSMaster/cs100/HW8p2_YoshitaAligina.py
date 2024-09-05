
import random

"""
Yoshita Aligina
CS 100 Section 011
HW 08, October 28th, 2023
"""
#p3
def enterNewPassword():
    while True:
        password = input("Enter a password (8-15 characters, including at least one digit): ")
        if len(password) >= 8 and len(password) <= 15 and any(char.isdigit() for char in password):
            print("Password successfully set!")
            break
        else:
            print("Invalid password. Please make sure your password has 8-15 characters and includes at least one digit.")


enterNewPassword()

# P4

def guessNumber():
    mystery_number = random.randint(0, 50)
    attempts = 0

    while attempts < 5:
        guess = int(input("Guess the number (between 0 and 50): "))

        if guess == mystery_number:
            print("Congratulations! You guessed the number {} correctly! You win!".format(mystery_number))
            break
        elif guess < mystery_number:
            print("Too low! Try again.")
        else:
            print("Too high! Try again.")

        attempts += 1

    if attempts == 5:
        print("Sorry, you've used all 5 attempts. The correct number was {}.".format(mystery_number))


guessNumber()
