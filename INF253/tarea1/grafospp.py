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




file = open("input.txt", "r")
errores = open("errores.txt", "w")
num_lin = 0


for linea in file:
    num_lin +=1
    W = errores(linea)
    caminito = re.findall(camino2, linea)