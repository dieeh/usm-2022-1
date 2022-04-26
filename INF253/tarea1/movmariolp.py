import re

#E.R de los números que acompañan las direcciones.
numero = '[0-9]{1,}'
#E.R de las direcciones que sirve para moverse por la matriz
direccion = r'[UD<>]' + numero 
#E.R del tipo que acompaña a 'L' o a 'S'.
tipo = '[ce]'
#E.R de las operaciones que se puede aplicar al lugar en donde estamos en la matriz.
operacion = r'[ABRZ]|[XY]' + direccion + '|[LS]' + tipo
#E.R de la pregunta para realizar una operación.
condicional = r'\?' + direccion + '[' + operacion + ']'
#E.R de todas las E.R's anteriores juntas.
instruccion = direccion + '|' + operacion + '|' + condicional

'''
deteccion_errores
———————–
linea : str
......
————————
Separa las instrucciones una por una gracias a la E.R y luego, las une en un string,
que posteriormente sirve para compararlo con la linea original y si son identicas, no posee error,
de lo contrario, escribe la linea en "errores.txt y retorna un booleano (si este es verdadero,
en la función principal "avisa" que hay un error y pasa a la siguiente linea).'''
def deteccion_errores(linea):
    instrucciones = re.findall(instruccion, linea)
    comparacion = ""
    for i in instrucciones:
        comparacion += i
    if (comparacion+"\n") != linea and (comparacion) != linea:
        errores.write(str(num_linea) + " " + linea)
        return True
    else:
        return False

'''
ASCII
———————–
numero : str
......
————————
Recibe un string de un numero, lo transforma a entero y gracias a la funcion chr()
lo convierte y retorna en el caracter correspondiente a la tabla "ASCII."'''
def ASCII(numero):
    num = int(numero)
    valor = chr(num)
    return valor

'''
Abre el "codigo.txt" y saca el primer valor correspondiente a la matriz, se crea el
de errores y tambien la matriz. Posteriormente se lee linea por linea el codigo y revisa
si no posee errores, de ser así, pasa a realizar las instrucciones.
Si es que no hay errores, escribe en errores "No hay errores!. Si es que todas las lineas
son errores, escribe "No hay lineas correctas :c y se cierran los archivos abiertos."'''
arch = open("codigo.txt", "r")
errores = open("errores.txt", "w")
tamaño = int(arch.readline())
matriz = [[0]* tamaño for i in range(tamaño)]
x = y = num_linea = num_errores = 0
salida = ""

for linea in arch:
    num_linea += 1
    flag = deteccion_errores(linea)
    instrucciones = re.findall(instruccion, linea)
    if flag == True:
        num_errores += 1
        continue
    for instruc in instrucciones:
        flag2 = False
        match = re.search('\?', instruc)
        if match != None:
            sub_match = re.search(direccion, instruc)
            Flag2 = True
            if sub_match!= None:
                extraccion = sub_match.group()
                sub_sub_match = re.search(numero, extraccion)
                if sub_sub_match != None:
                    sub_extraccion = sub_sub_match.group()
                    if extraccion == ('U' + sub_extraccion):
                        aux = ((y - int(sub_extraccion))%tamaño)
                        if matriz[x][aux] <= 0:
                            continue
                    if extraccion == ('D' + sub_extraccion):
                        aux = ((y + int(sub_extraccion))%tamaño)
                        if matriz[x][aux] <= 0:
                            continue
                    if extraccion == ('<' + sub_extraccion):
                        aux = ((x - int(sub_extraccion))%tamaño)
                        if matriz[aux][y] <= 0:
                            continue
                    if extraccion == ('>' + sub_extraccion):
                        aux = ((x + int(sub_extraccion))%tamaño)
                        if matriz[aux][y] <= 0:
                            continue

        if flag2 == False:
            match2 = re.search(numero,instruc)
            if match2 != None:
                extraccion2 = match2.group()
                if instruc == ('U'+ extraccion2): 
                    y -= ((int(extraccion2))%tamaño)
                    continue
                if instruc == ('D'+ extraccion2):
                    y += ((int(extraccion2))%tamaño)
                    continue
                if instruc == ('<'+ extraccion2):
                    x -= ((int(extraccion2))%tamaño)
                    continue
                if instruc == ('>'+ extraccion2):
                    x += ((int(extraccion2))%tamaño)
                    continue

        match3 = re.search(operacion, instruc)
        if match3 != None:
            extraccion3 = match3.group()
            if extraccion3 == ('A'):
                matriz[x][y] += 1
                continue
            if extraccion3 == ('B'):
                matriz[x][y] -= 1
                continue
            if extraccion3 == ('R'):
                matriz[x][y] = 0
                continue
            if extraccion3 == ('Z'):
                for fila in matriz:
                    for elemento in fila:
                        elemento = 0
                continue

            sub_match3 = re.search(numero, extraccion3)
            if sub_match3 != None:
                sub_extraccion3 = sub_match3.group()
                if extraccion3 == ('XU' + sub_extraccion3):
                    aux = ((y - int(sub_extraccion3))%tamaño)
                    matriz[x][y] *= matriz[x][aux]
                    continue
                if extraccion3 == ('XD' + sub_extraccion3):
                    aux = ((y + int(sub_extraccion3))%tamaño)
                    matriz[x][y] *= matriz[x][aux]
                    continue
                if extraccion3 == ('X<' + sub_extraccion3):
                    aux = ((x - int(sub_extraccion3))%tamaño)
                    matriz[x][y] *= matriz[aux][y]
                    continue
                if extraccion3 == ('X>' + sub_extraccion3):
                    aux = ((x + int(sub_extraccion3))%tamaño)
                    matriz[x][y] *= matriz[aux][y]
                    continue
                if extraccion3 == ('YU' + sub_extraccion3):
                    aux = ((y - int(sub_extraccion3))%tamaño)
                    if matriz[x][aux] == 0:
                        continue
                    matriz[x][y] /= matriz[x][aux]
                    continue
                if extraccion3 == ('YD' + sub_extraccion3):
                    aux = ((y + int(sub_extraccion3))%tamaño)
                    if matriz[x][aux] == 0:
                        continue                    
                    matriz[x][y] /= matriz[x][aux]
                    continue
                if extraccion3 == ('Y<' + sub_extraccion3):
                    aux = ((x - int(sub_extraccion3))%tamaño)
                    if matriz[aux][y] == 0:
                        continue
                    matriz[x][y] /= matriz[aux][y]
                    continue
                if extraccion3 == ('Y>' + sub_extraccion3):
                    aux = ((x + int(sub_extraccion3))%tamaño)
                    if matriz[aux][y] == 0:
                        continue
                    matriz[x][y] /= matriz[aux][y]
                    continue

            sub_match32 = re.search(tipo, extraccion3)
            if sub_match32 != None:
                sub_extraccion32 = sub_match32.group()
                if extraccion3 == ('L' + sub_extraccion32):
                    if sub_extraccion32 == 'e':
                        if matriz[x][y] >= 0:
                            salida += str(matriz[x][y])
                        continue
                    else:
                        num = matriz[x][y]
                        if num >= 32 and num <= 126:
                            salida += ASCII(num)
                            continue

                if extraccion3 == ('S' + sub_extraccion32):
                    if sub_extraccion32 == 'e':
                        for fila in matriz:
                            for elemento in fila:
                                if elemento >= 0:
                                    salida += str(elemento)
                        continue
                    else:
                        for fila in matriz:
                            for elemento in fila:
                                num = elemento
                                if num >= 32 and num <= 127:
                                    salida += ASCII(num)
                        continue

if num_errores == 0:
    errores.write("No hay errores!")
if num_errores == num_linea:
    errores.write("\nNo hay lineas correctas :c")
errores.close()
arch.close()
print(salida)

'''
Nombre: Nicolás Ignacio Cancino Henríquez
Paralelo: 201
Rol: 202004680-8
'''