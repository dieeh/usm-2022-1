import re


numeros = '[1-9][0-9]{5}'
telefono = r'\+' + numeros
id = r'\#[A-Z]{2}[0-9]{2}'
calles = r'[A-Z][a-z0-9\s-]+'
names = r'[A-Z][a-z\s-]+'
names2 = r'[A-Z][a-z\s-]+\,[A-Z][a-z\s-]+'
rut = r'[1-9][0-9]{7}\-[0-9k]'
persona = '('+names+'|'+names2+')' + '_' + '('+names+'|'+names2+')' + '_' + telefono + '_' + rut
calle = calles + r'\.' + id + r'\.' + persona
camino1 = r'\('+'('+calle+'|'+id+')' + ':' +'('+calle+'|'+id+')'+ r'\)'
camino2 = r'\('+'('+calle+'|'+id+'|'+camino1+')' + ':' +'('+calle+'|'+id+'|'+camino1+')'+ r'\)'

def errores(line):
    instru = re.findall(camino2, line)
    comp = ""
    for i in instru:
        comp += i
    if (((comp+'\n') != line) and (comp != line)):
        errores.write(str(num_lin) + " "+line)
        return True
    else:
        return False


def printall():
    for item in lista_dirr:
        i=0
        while i < 6:
            print(item[i])
            i +=1
        
def print_caminos(id):
    flag = False
    flag2 = True
    for i in lista_dirr:
        if i[0] == id:
            flag = True

    if flag == False:
        print("No existe esa calle")
        return

    tuplas_validas = []
    cadenaTuplas = str(id) + "->"
    
    for item in tuplas_caminos:
        if item[0] == id:
            tuplas_validas.append(item)
    for tupla in tuplas_validas:
        id_actual = tupla[1]
        lista_actual = list()
        lista_actual.append(id_actual)
        while 



def print_nombre(nombre):
    print("CALLES CON PERSONAS DE NOMBRE "+nombre+":")
    return

def print_apell(apellido):
    print("CALLES CON PERSONAS DE APELLIDO "+apellido+":")
    return

def print_rut(rut):
    print("CALLES CON PERSONAS DE RUT "+rut+":")
    return

def print_calle(id):
    print("CALLE:")
    for i in lista_dirr:
        if i[0] == id:
            for obj in i:
                print(str(obj))



file_txt = open("input.txt", "r")
errores_txt = open("errores.txt", "w")
num_lin = num_err = 0
lista_dirr = []
tuplas_caminos = []



for linea in file_txt:
    strings = linea.split(";")
    for comando in strings:
        if comando == "print_all":
            printall()
        elif comando[0:12] == "print_caminos":
            print_caminos(comando[13:])
        re.findall(calle, comando)
        re.findall(camino2, comando)



