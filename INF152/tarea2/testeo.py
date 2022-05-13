def getLeast(line, givenNumber):
    x = 0
    y = 0
    list = []
    largo = len(line)
    for item in line:
        
        if item == ' ' and y > 0:
            list.append(int(line[x:y]))
            x = y+1
        if y == largo - 1:
            list.append(int(line[x:y+1]))
        y = y+1

    maxValue = 0
    for element1 in list:
        if element1 > maxValue:
            maxValue = element1

    if maxValue <= givenNumber:
        return -1
    
    for element2 in list:
        if element2 > givenNumber and element2 < maxValue:
            maxValue = element2
    
    return maxValue


string = "568 769 436 432 457 563 567 311 34 3 2 9"
string2 = "45 253 645 400 676 567"
string3 = "1 2 3 4 5" 
string4 = "120 450 780"

numero = 460
numero2 = 400
numero3 = 2
numero4 = 1000
numero5 = 1

testeo = getLeast(string3, numero3)
testeo2 = getLeast(string4, numero4)
testeo3 = getLeast(string2, numero5)
testeo4 = getLeast(string2, numero2)
testeo5 =getLeast(string, numero)

print(testeo)
print(testeo2)
print(testeo3)
print(testeo4)
print(testeo5)
