"""
Yoshita Aligina
CS 100 Section 011
HW 12, Nov 29th, 2023
"""
#p 1

def safeOpen(filename):
    try:
        file = open(filename, 'r')
        return file
    except FileNotFoundError:
        print(f"File not found: {filename}")
        return None

# inputFile = safeOpen('ghost.txt')
#print(inputFile)

#p 2
def safeFloat(x):
    try:
        result = float(x)
        return result
    except ValueError:
        print(f"Could not convert to float: {x}")
        return 0.0

#f = safeFloat('abc')
#print(f)

#p3
def averageSpeed():
    attempts = 0
    while attempts < 2:
        filename = input("Enter file name: ")
        inputFile = safeOpen(filename)

        if inputFile:
            content = inputFile.read()
            inputFile.close()

            speeds = [safeFloat(speed) for speed in content.split()]
            valid_speeds = [speed for speed in speeds if speed > 2]

            if valid_speeds:
                avg_speed = sum(valid_speeds) / len(valid_speeds)
                print(f"Average speed is {avg_speed:.2f} miles per hour.")
                return
            else:
                print("No valid speeds found.")
                attempts += 1
        else:
            attempts += 1

    print("Quitting program. Goodbye.")

#averageSpeed()
