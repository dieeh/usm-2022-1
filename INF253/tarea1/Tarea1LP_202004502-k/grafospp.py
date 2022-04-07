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

'''
printcalle
----------------
id: String
----------------
Esta funcion imprime por pantalla la 
informacion vinculada al id de la calle
'''
def printcalle(id):
    for item in lista_dirr:
        if (item[0] == id) and (len(item)>1):
            print("CALLE:")
            print(str(item[1]))  #nombre calle
            print(str(item[0]))  #id calle
            print(str(item[2]))  #nombre persona
            print(str(item[3]))  #apellido persona  
            print(str(item[4]))  #telefono
            print(str(item[5]))  #rut


'''
printall
----------------
Esta funcion imprime por pantalla la
informacion vinculada a todas las ids registradas
'''
def printall():
    for item in lista_dirr:
        i=0
        while i < 6:
            printcalle(item[i])
            i +=1
        

'''
print_caminos
----------------
id: String
----------------
Esta funcion imprime por pantalla los caminos
que inician en la calle del id
'''
def print_caminos(id):
    print("CAMINOS DESDE "+str(id)+":")
    tuplas_iniciales = []
    cadena = ""
    for element in tuplas_caminos:
        if element[0] == id:
            tuplas_iniciales.append(element)
    tupla_ant = (0,0)
    for tupla in tuplas_iniciales:
        cadena = tupla[0]+"->"+tupla[1]
        for camino in tuplas_caminos:
            if camino[0] == tupla[1]:
                cadena.__add__("->"+camino[0])
            if camino[1] == tupla_ant[0]:
                cadena.append("->"+tupla_ant)
            tupla_ant = camino
        print(cadena) 


'''
compro_rut
----------------
rut: String
----------------
Esta funcion comprueba que el digito
verificador del rut sea correcto
'''
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


'''
caminos_validos
----------------
id1: String
id2: String
----------------
Esta funcion imprime por pantalla si existe un camino
entre las 2 id's que se entregan, ademas retorna valores
True o False dependiendo de si existe o no un camino
'''
def caminos_validos(id1, id2):
    flag =False
    for combi in tuplas_caminos:
        if (combi[0] == id1) or (combi[1] == id1) or (combi[0] == id2) or (combi[1] == id2):
            flag = True
    if flag == False:
        print("No existe con "+id1+" o "+id2)
        return False
    elif (id1,id2)  in tuplas_caminos:
        print("Si se puede")
        return True
    else:
        print("No se puede")
        return False


'''
print_nombre
----------------
nombre: String
----------------
Esta funcion imprime por consola las calles donde
se encuentra una persona con el nombre indicado
'''
def print_nombre(nombre):
    lista_n = []
    for elemento in lista_dirr:
        if len(elemento) > 1:
            if re.match(nombre,elemento[2]):
                lista_n.append(elemento)
    if lista_n:
        print("CALLES CON PERSONAS DE NOMBRE "+nombre+":")
        for elements in lista_n:
            print(elements[1])
    else:
        print("No existen calles con personas de ese nombre")


'''
print_apell
----------------
apellido: String
----------------
Esta funcion imprime por consola las calles donde
se encuentra una persona con el apellido indicado
'''
def print_apell(apellido):
    lista_n = []
    for elemento in lista_dirr:
        if len(elemento) > 1:
            if re.match(apellido,elemento[3]):
                lista_n.append(elemento)
    if lista_n:
        print("CALLES CON PERSONAS DE APELLIDO "+apellido+":")
        for elements in lista_n:
            print(elements[1])
    else:
        print("No existen calles con personas de ese apellido")


'''
print_rut
----------------
rut: String
----------------
Esta funcion imprime por consola las calles donde
se encuentra una persona con el rut indicado
'''
def print_rut(rut):
    lista_n = []
    for elemento in lista_dirr:
        if len(elemento) > 1:
            if elemento[5] == rut:
                lista_n.append(elemento)
    if lista_n:
        print("CALLES CON PERSONAS DE RUT "+rut+":")
        for elements in lista_n:
            print(elements[1])
    else:
        print("No existen calles con personas con ese rut")


'''
print_fono
----------------
telefono: String
----------------
Esta funcion imprime por consola las calles donde
se encuentra una persona con el telefono indicado'''
def print_fono(telefono):
    lista_n = []
    for elemento in lista_dirr:
        if len(elemento) > 1:
            if elemento[4] == telefono:
                lista_n.append(elemento)
    if lista_n:
        print("CALLES CON PERSONAS DE TELEFONO "+telefono+":")
        for elements in lista_n:
            print(elements[1])
    else:
        print("No existen calles con personas con ese telefono")

#def print_calle(id):
#    print("CALLE:")
#    for i in lista_dirr:
#        if i[0] == id:
#            for obj in i:
#                print(str(obj))


'''
caminitos
----------------
caminos1: String
caminos2: String
----------------
Esta funcion agrega a los datos los caminos nuevos que se entregan
por el input'''
def caminitos(caminos1, caminos2):
    ids = re.findall(id, caminos1)
    ids2 = re.findall(id, caminos2)
    tuplas_caminos.append((ids[0],ids2[0]))
    if len(caminos1) > 5:
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
        flag4=  flag5 = False
        for elemen in lista_dirr:
            if tuple(ids)[0] == elemen[0]:
                flag4 = True
            if tuple(ids2)[0] == elemen[0]:
                flag5 = True
        if flag4 == False:
            lista_dirr.append(tuple(ids))
        if flag5 == False:
            lista_dirr.append(tuple(ids2))



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
            else:
                errores_txt.write(comando[15:]+"\n")
        elif re.match(r'print_by_apellido', comando) != None:
            lista3 = re.findall(names, comando)
            if lista3:
                print_apell(lista3[0])
            else:
                errores_txt.write(comando[17:]+"\n")
        elif re.match(r'print_by_rut', comando) != None:
            lista4 = re.findall(rut, comando)
            if lista4:
                print_rut(lista4[0])
            else:
                errores_txt.write(comando[12:]+"\n")
        elif re.match(r'print_by_telefono', comando) != None:
            lista5 = re.findall(telefono, comando)
            if lista5:
                print_fono(lista5[0])
            else:
                errores_txt.write(comando[17:]+"\n")
        elif re.match(r'print_all', comando) != None:
            printall()
        elif re.match(r'print', comando) != None:
            lista6 = re.findall(id, comando)
            if lista6:
                printcalle(lista6[0])
            else:
                errores_txt.write(comando[5:]+"\n")
        elif re.match(r'update', comando) != None:
            _,id_actual,calle_nueva = comando.split(' ')
            calle_new,id_nueva,datos = calle_nueva.split('.')
            nombre_new, apell_new, fono_new, rut_new = datos.split('_')
            for item in lista_dirr:
                if item[0] == id_actual:
                    lista_dirr.remove(item)
                    lista_dirr.append((id_nueva,calle_new,nombre_new,apell_new,fono_new,rut_new))
            for tupla in tuplas_caminos:
                primer_id = tupla[0]
                segundo_id = tupla[1]
                if tupla[0] == id_actual:
                    tuplas_caminos.remove(tupla)
                    tuplas_caminos.insert(0,(id_nueva,segundo_id))
                elif tupla[1] == id_actual:
                    tuplas_caminos.remove(tupla)
                    tuplas_caminos.insert(0,(primer_id, id_nueva))
        elif re.match(r'valid_camino', comando) != None:
            ids = re.findall(id, comando)
            id1 = ids[0]
            id2 = ids[1]
            caminos_validos(id1, id2)
        else:
            if re.match(calle, comando) != None:
                calle_new,id_nueva,datos = comando.split('.')
                nombre_new, apell_new, fono_new, rut_new = datos.split('_')
                if compro_rut(rut_new) == False:
                    errores_txt.write(rut_new+"\n")
                else:
                    pass
                lista_dirr.append((id_nueva,calle_new,nombre_new,apell_new,fono_new,rut_new))
            elif re.match(camino2, comando) != None:
                lista_new2 = re.findall(camino2, comando)
                if lista_new2:  
                    caminitos(lista_new2[0][0], lista_new2[0][9])
file_txt.close()
errores_txt.close()