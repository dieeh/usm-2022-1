import re



telefono = r'\+[1-9][0-9]{5}'  #vv
id = r'\#[A-Z]{2}[0-9]{2}'   #vv
calles = r'[A-Z][a-zA-Z-\s]+[0-9]+' #vv
names = r'[A-Z][a-z\s-]+' #vv
names2 = r'[A-Z][a-z-\s]+,[A-Z][a-z-\s]+'
rut = r'[1-9][0-9]+\-[0-9k]'  #vv
persona = '('+names+'|'+names2+')' + '_' + '('+names+'|'+names2+')' + '_' + telefono + '_' + rut
calle = calles + r'\.' + id + r'\.' + persona
camino1 = r'\('+'('+calle+'|'+id+')'+':'+'('+calle+'|'+id+')'+r'\)'
camino2 = r'\('+'('+calle+'|'+id+'|'+camino1+')'+':'+'('+calle+'|'+id+'|'+camino1+')'+ r'\)'

file_txt = open("input.txt", "r")
errores_txt = open("errores.txt", "w")
num_lin = num_err = 0
lista_dirr = []
tuplas_caminos = []


def printcalle(id):
    for item in lista_dirr:
        if item[0] == id:
            print("CALLE:")
            print(str(item[1]))  #nombre calle
            print(str(item[0]))  #id calle
            print(str(item[2]))  #nombre persona
            print(str(item[3]))  #apellido persona  
            print(str(item[4]))  #telefono
            print(str(item[5]))  #rut

def printall():
    for item in lista_dirr:
        i=0
        while i < 6:
            printcalle(item[i])
            i +=1
        
def print_caminos(id):
    flag = False
    flag2 = True
    for i in lista_dirr:
        if i[0] == id:
            flag = True
#  
#      if flag == False:
#          print("No existe esa calle")
#          return
#  
#      tuplas_validas = []
#      cadenaTuplas = str(id) + "->"
#      
#      for item in tuplas_caminos:
#          if item[0] == id:
#              tuplas_validas.append(item)
#      for tupla in tuplas_validas:
#          id_actual = tupla[1]
#          lista_actual = list()
#          lista_actual.append(id_actual)
#          while 

def compro_rut(rut):
    verificador = rut[-1]
    
    rut_sv = rut[:-2]

    backwrds = rut_sv[::-1]
    sum = 0
    i = 2
    for j in range(len(backwrds)):
        if i == 8:
            i = 2
        
        sum += int(backwrds[j])*i
        i+=1
    
    veri = 11 - (sum%11)
    
    if veri != verificador:
        return False
    else:
        return True



def print_nombre(nombre):
    lista_n = []
    for elemento in lista_dirr:
        if elemento[2] == nombre:
            lista_n.append(elemento)
    if lista_n:
        print("CALLES CON PERSONAS DE NOMBRE "+nombre+":")
        for item in lista_n:
            print_calle(item)
    else:
        print("No existen calles con personas de ese nombre")

def print_apell(apellido):
    lista_n = []
    for elemento in lista_dirr:
        if elemento[3] == apellido:
            lista_n.append(elemento)
    if lista_n:
        print("CALLES CON PERSONAS DE APELLIDO "+apellido+":")
        for item in lista_n:
            print_calle(item)
    else:
        print("No existen calles con personas de ese apellido")

def print_rut(rut):
    lista_n = []
    for elemento in lista_dirr:
        if elemento[5] == rut:
            lista_n.append(elemento)
    if lista_n:
        print("CALLES CON PERSONAS DE RUT "+rut+":")
        for item in lista_n:
            print_calle(item)
    else:
        print("No existen calles con personas con ese rut")

def print_fono(telefono):
    lista_n = []
    for elemento in lista_dirr:
        if elemento[5] == telefono:
            lista_n.append(elemento)
    if lista_n:
        print("CALLES CON PERSONAS DE TELEFONO "+telefono+":")
        for item in lista_n:
            print_calle(item)
    else:
        print("No existen calles con personas con ese telefono")

def print_calle(id):
    print("CALLE:")
    for i in lista_dirr:
        if i[0] == id:
            for obj in i:
                print(str(obj))


def caminitos(caminos1, caminos2):
    ids = re.findall(id, caminos1)
    ids2 = re.findall(id, caminos2)

    tuplas_caminos.append((ids[0],ids2[0]))

    if re.findall(calle, caminos1) != None:
        
        calle_new,id_nueva,datos = caminos1.split('.')
        nombre_new, apell_new, fono_new, rut_new = datos.split('_')
        if compro_rut(rut_new) == False:
            errores_txt.write(rut_new)
            
        else:
            pass
        lista_dirr.append((id_nueva,calle_new,nombre_new,apell_new,fono_new,rut_new))

        calle_new,id_nueva,datos = caminos2.split('.')
        nombre_new, apell_new, fono_new, rut_new = datos.split('_')
        if compro_rut(rut_new) == False:
            errores_txt.write(rut_new)

        else:
            pass
        lista_dirr.append((id_nueva,calle_new,nombre_new,apell_new,fono_new,rut_new))
    
    else:
        lista_dirr.append((ids))
        lista_dirr.append((ids2))



 

for linea in file_txt:
    strings = linea.split(";")
    for comando in strings:
        if re.match(r'print_caminos', comando) != None:
            lista1 = re.findall(id, comando)
            if lista1:
                print_caminos(lista1[0])
        elif re.match(r'print_by_nombre', comando) != None:
            lista2 = re.findall(names, comando)
            if lista2:
                print_nombre(lista2[0])
        elif re.match(r'print_by_apellido', comando) != None:
            lista3 = re.findall(names, comando)
            if lista3:
                print_apell(lista3[0])
        elif re.match(r'print_by_rut', comando) != None:
            lista4 = re.findall(rut, comando)
            if lista4:
                print_rut(lista4[0])

        elif re.match(r'print_by_telefono', comando) != None:
            lista5 = re.findall(telefono, comando)
            if lista5:
                print_fono(lista5[0])
        elif re.match(r'print_all', comando) != None:
            printall()
        elif re.match(r'print', comando) != None:
            lista6 = re.findall(id, comando)
            if lista6:
                printcalle(lista6[0])

        elif re.match(r'update', comando) != None:
            _,id_actual,calle_nueva = comando.split(' ')
            calle_new,id_nueva,datos = calle_nueva.split('.')
            nombre_new, apell_new, fono_new, rut_new = datos.split('_')

            for item in lista_dirr:
                if item[0] == id_actual:
                    item = (id_nueva,calle_new,nombre_new,apell_new,fono_new,)

        elif re.match(r'valid_caminos', comando) != None:
            ids = re.findall(id, comando)


        else:
            if re.match(calle, comando) != None:
                calle_new,id_nueva,datos = comando.split('.')
                nombre_new, apell_new, fono_new, rut_new = datos.split('_')
                if compro_rut(rut_new) == False:
                    errores_txt.write(rut_new+"\n")
                    num_err +=1
                else:
                    pass
                lista_dirr.append((id_nueva,calle_new,nombre_new,apell_new,fono_new,rut_new))
            elif re.match(camino2, comando) != None:
                lista_new2 = re.findall(camino2, comando)
                if lista_new2:
                    
                    caminitos(lista_new2[0][0], lista_new2[0][9])
                    
                    
                


file_txt.close()
errores_txt.close()