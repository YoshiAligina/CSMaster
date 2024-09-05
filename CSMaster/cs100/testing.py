lst = ['M','a','r','c','h']
vowels = 'aeiouAEIOU'
c = ()

for letter in lst:
    if letter not in vowels:
        c += letter

print(c)
