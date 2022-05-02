#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "Frec.h"

Frec* comprimir_en_frec(int n, int* grupo){
    int num_distint[n] = {-1};
    int flag = 0;
    int index = 0;
    int i, j, k;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (grupo[i] == num_distint[j]){
                flag = 1;
            }
        }
        if (flag == 0){
            num_distint[index++] = grupo[i];
        }
    }
    int numeros_dist[index];
    for (k = 0; k < index; k++){
        numeros_dist[k] = num_distint[k];
    }
    int iter[index];
    int cont;
    for (j = 0; j < index; j++){
        cont = 0;
        for (k = 0; k < n; k++){
            if (numero_dist[j] == grupo[k]){
                cont++;
            }
        }
        iter[j] = cont;
    }
    //numeros_dist = numeros distintos en el conjunto
    //iter = iteraciones de cada numero
    //el indice coincide
    int iter_copia[index];
    for (k = 0; k < index; k++){
        iter_copia[k] = iter[k];
    }
    int sum = 2*index -1;
    for (i = 0; i < index; i++){
        sum += numeros_dist[i];
        sum += i+1;
    }
    //sum = cantidad de espacios en la secuencia de representacion
    char repres[sum];
    int a = 1;//numero de representacion
    int l = 0;
    i = j = k = 0;
    while (l < sum){
        int index_max = 0, value_max = 0, j = 0;
        for (i = 0; i < index; i++){//busca el valor maximo de iteracion
            if (iter_copia[i] > value_max){
                value_max = iter[i];
                index_max = i;
            }
        }
        while (j < numeros_dist[index_max]){
            repres[l++] = '1';
            j++;
        }
        repres[l++] = '0';
        for (k = 0; k < a; k++){
            repres[l++] = '1';
        }
        a++;
        iter_copia[index_max] = -1;//elimina de la copia el valor maximo para volver a iterar
    }
    //repres = representacion = 3 -> 11101

    l = i = j = k = 0;
    while (){
        
    }
    
    
}


int* descomprimir_en_frec(void* frec);


int  donde_esta_frec(void* frec , int e, int i);


int  cuantos_mas_grande_frec(void* frec , int e);


int  bits_frec(void* frec);


void  mostrar_frec(void* frec);

