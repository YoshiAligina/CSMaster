"""
Yoshita Aligina
CS 100 Section 011
HW 01, September 9th, 2023
"""

daysInAWeek = 7
hoursInADay = 24
secondsInAMinute = 60

print (daysInAWeek)
print (hoursInADay)
print (secondsInAMinute)

pi = 3.1415
eggCookerTime = 11.3
aQuarter = 60

print (pi)
print (eggCookerTime)
print (aQuarter)

myName = "Yoshita Aligina"
favouriteBook = "Love, Theoretically"
favouriteDrink = "Baja Blast"

print (myName +" "+favouriteBook+" "+favouriteDrink)

#  textbook exercises: 1.1, 1.2, 2.1, and 2.2

print ("     ")

"""1.1 -
1. It will leave us with an error. SyntaxError: unexpected EOF while parsing.
2. If we leave it without one or both of the quotation marks we are unable to run the program as it will have trouble with the string literal.
3. We would not be able to do so, it would add the two numbers together in that case.
4. Python does not support leading zeros in numbers. If we tried to do 011, it would cause a syntax errorr.
5. I have noiticed that the two values with no operator between them becomes a single value.
"""
"""1.2-"""
#1
sec = 60
min = 42
remainingSeconds = 42
#2
print ((sec * min)+ remainingSeconds)

miles = 10
kilometer = 1.61
kilometersInAMile = miles / kilometer

print (kilometersInAMile)
#3

hours = min/60
kilometersInTheRace = 10
milesRan = kilometersInTheRace / kilometersInAMile

pace = min / miles
mph = miles / hours

print (pace)
print(mph)



"""2.1 -
1. We can not assign a variable to a contstant.
2. It is legal, and works.
3. The line I try it on does not seem to print, it appears that it does not function with a semi colon at the end.
4. Putting a period at the end however causes the entire program to not work.
5. Xy is not defined as a variable, the  way to multiply would be to use x*y, because xy would be considered separate.
"""
"""2.2-
"""

#1
radius = 5
volume = ((4.0/3.0)*pi*(radius)**3)
print("       ")
print(volume)

#2
price = 24.95
discount_price = price - (price * .4)
shipping = 3 + (0.75 * (60 - 1))
wholesale = discount_price * 60 + shipping
print(wholesale)

#3
start_hour = 6
start_min = 52

easy_pace_min = 8
easy_pace_seconds = 15

tempo_pace_min = 7
tempo_pace_seconds = 12

total_min = (1 * easy_pace_min) + (3 * tempo_pace_min) + (1 * easy_pace_min)
total_seconds = (1 * easy_pace_seconds) + (3 * tempo_pace_seconds) + (1 * easy_pace_seconds)

if total_seconds >= 60:
    total_min += total_seconds // 60
    total_seconds %= 60

arrival_hour = start_hour
arrival_min = start_min + total_min

if arrival_min >= 60:
    arrival_hour += arrival_min // 60
    arrival_min %= 60

print(f"The runner will be home for breakfast at about {arrival_hour}:{arrival_min:02d} am")



