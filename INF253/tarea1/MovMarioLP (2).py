import re


'''
direc
----------------
matches : string
----------------
Esta funcion lo que hace es procesar los comandos de direcciones,
es decir, cambia la posicion de la matriz
'''
def direc(matches):
    global x
    global y
    global n
    global aaaa
    if matches not in re.findall(aaaa, linea):
        return
    direcc = matches[0][0]
    a = ['A', 'B', 'R', 'Z', 'Sc', 'Se', 'Le', 'Lc', '']
    if matches in a:
        return
    if matches[0] in ['X', 'Y']:
        mult_div(matches)
        return
    m = n-1
    k = 0
    p = int(matches[1:])
    direcc = matches[0][:1]
    if direcc == "U":
        while k < p:
            if y == 0:
                y = m
            y -= 1
            k += 1
    elif direcc == "D":
        while k < p:
            if y == m:
                y = 0
            y += 1
            k += 1
    elif direcc == "<":
        while k < p:
            if x == 0:
                x = m
            x -= 1
            k += 1
    elif direcc == ">":
        while k < p:
            if x == m:
                x = 0
            x += 1
            k += 1
    return


'''
mult_div
----------------
match : string
----------------
Esta funcion procesa los comandos X e Y, junto con sus direcciones
es una sub funcion de direc, es decir, solo se ejecuta dentro de esta.
La funcion guarda el valor actual en la matriz y busca el valor que indican
las direcciones, luego multiplica o divide el valor actual por ese valor buscado.
'''
def mult_div(match):
    global aaaa
    global x
    global y
    global n
    global matriz
    if match not in re.findall(aaaa, linea):
        return
    actual = matriz[y][x]
    dir = match[1:]
    p = int(match[2:])
    k = 0
    x1 = x
    y1 = y
    if match[0] == "X":
        if dir[0] == "U":
            while k < p:
                if y1 == 0:
                    y1 = n-1
                y1 -= 1
                k += 1
        elif dir[0] == "D":
            while k < p:
                if y1 == n-1:
                    y1 = 0
                y1 += 1
                k += 1
        elif dir[0] == "<":
            while k < p:
                if x1 == 0:
                    x1 = n-1
                x1 -= 1
                k += 1
        elif dir[0] == ">":
            while k < p:
                if x1 == n-1:
                    x1 = 0
                x1 += 1
                k += 1
        matriz[y][x] = actual * matriz[y1][x1]
    elif match[0] =="Y":
        if dir[0] == "U":
            while k < p:
                if y1 == 0:
                    y1 = n-1
                y1 -= 1
                k += 1
        elif dir[0] == "D":
            while k < p:
                if y1 == n-1:
                    y1 = 0
                y1 += 1
                k += 1
        elif dir[0] == "<":
            while k < p:
                if x1 == 0:
                    x1 = n-1
                x1 -= 1
                k += 1
        elif dir[0] == ">":
            while k < p:
                if x1 == n-1:
                    x1 = 0
                x1 += 1
                k += 1
        if matriz[y1][x1] != 0:
            matriz[y][x] = actual / matriz[y1][x1]
    return


'''
operaciones
----------------
matr : string
----------------
Esta funcion procesa las operaciones, a excepcion de las funciones X e Y.
La funcion actualiza los valores de la matriz y retorna los valores por consola
en caso de que la operacion lo requiera
'''
def operaciones(matr):
    global x
    global y
    global n
    global matriz
    global aaaa
    if matr not in re.findall(aaaa, linea):
        return
    i = 0
    j = 0
    if matr == "A":
        matriz[y][x] +=1
    elif matr == "B":
        matriz[y][x] -=1
    elif matr == "R":
        matriz[y][x] = 0
    elif matr == "Z":
        while j < n:
            while i < n:
                matriz[j][i] = 0
                i += 1
        j += 1
    elif matr == "Lc":
        if 32 <= int(matriz[y][x]) <= 127:
            print(chr(int(matriz[y][x])))
    elif matr == "Le":
        print(int(matriz[y][x]))
    elif matr == "Sc":
        out = ""
        while j < n:
            while i < n:
                if 32 <= int(matriz[j][i]) <= 127:
                    out += chr(int(matriz[j][i]))
                i += 1
            j += 1
        print(out)
    elif matr == "Se":
        out = ""
        while j < n:
            while i < n:
                out += str(int(matriz[j][i]))
                i += 1
            j += 1
        print(out)
    return

condicional = "'?'U\d{1,2}|'?'D\d{1,2}|'?'<\d{1,2}|'?'>\d{1,2}"
dir = "U\d{1,2}|D\d{1,2}|<\d{1,2}|>\d{1,2}"
multis = "XU\d{1,2}|XD\d{1,2}|X<\d{1,2}|X>\d{1,2}"
divs = "YU\d{1,2}|YD\d{1,2}|Y<\d{1,2}|Y>\d{1,2}"
operacion = "A|B|R|Z|Sc|Se|Le|Lc"

aaaa = operacion + "|" + dir + "|" + multis + "|" + divs


file = open("codigo.txt", "r")
n = int(file.readline())

linea = []
matriz = []
errores = []
i = 0
j = 0
cantidad = 2
x = 0
y = 0
while j < n:
    while i < n:
        linea.append(0)
        i += 1
    matriz.append(linea)
    linea = list()
    i = 0
    j += 1
 
for linea in file: 
    '''print(str(cantidad) + "..-")'''
    '''parentesis = linea[linea.find('(')+1:linea.find(')')]
    if parentesis != "":
        result = parentesis[parentesis.find('(')+1:parentesis.find(')')]
        if result == "":
            match = re.findall(aaaa, parentesis)
            for elemento in match:
                direc(elemento)
                operaciones(elemento)
        else:
            match = re.findall(aaaa, result)
            for elemento in match:
                direc(elemento)
                operaciones(elemento)'''
    match = re.findall(aaaa, linea)
    '''for err in re.findall('((?!' + aaaa + ').)*', linea):
        if err != '':
            errores.append(err)'''
    for elemento in match:
        direc(elemento)
        operaciones(elemento)
    '''print(match)'''
    cantidad += 1
    '''print("\n")'''

file2 = open("errores.txt", "a")
if errores:
    for elemento in errores:
        file2.write(elemento + "\n")
else:
    file2.write("No hay errores! \n")


print(*matriz)
file.close()
file2.close()