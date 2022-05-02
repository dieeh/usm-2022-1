#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "Frec.h"

Frec* comprimir_en_frec(int n, int* grupo){
    int* num_distint = (int*)malloc(sizeof(int * n));
    for (int o = 0; o < n; o++){
        num_distint[o] = -1;
    }
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
    int* numeros_dist = (int*)malloc(sizeof(int * index));
    for (k = 0; k < index; k++){
        numeros_dist[k] = num_distint[k];
    }
    int* iter = (int*)malloc(sizeof(int * index));
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
    int* iter_copia = (int*)malloc(sizeof(int * index));
    for (k = 0; k < index; k++){
        iter_copia[k] = iter[k];
    }
    int sum = 2*index -1;
    for (i = 0; i < index; i++){
        sum += numeros_dist[i];
        sum += i+1;
    }
    //sum = cantidad de espacios en la secuencia de representacion
    char* repres = (char*)malloc(sizeof(char * sum));
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
    int numero_rep;
    int sum2 = n-1; // 0's de los espacios entre numeros
    while (l < sum){
        if (repres[l++] == '1'){   //1111111101011
            i++;
        }else{
            numero_rep = i;
            j++; //numero de representacion
            for (k = 0; k < index; k++){
                if (numeros_dist[k] == numero_rep){
                    sum2 += j*iter[k]
                }
            }
            i = 0;
            l += j+2;
        }
    }
    int* bitcoins = (int*)malloc(sizeof(int * sum2));
    l = i = j = k = 0;
    while (l < n){
        for (i = 0; i < sum; i++){
            if (repres[i] == '1'){
                j++;
            }else{
                if (j == grupo[l]){
                    j = 0;
                    l++;
                    while ((repres[++i] != '0')&&(i<sum)){
                        bitcoins[k++] = '1';
                    }
                    if (k<sum2){
                        bitcoins[k++] = '0';
                    }
                }   
            }
        }
    }
    Frec* temp = (Frec*)malloc(sizeof(Frec));
    temp->representaciones = repres;
    temp->bits = bitcoins;
    free(num_distint);
    free(numeros_dist);
    free(iter);
    free(iter_copia);
    return temp;
}


int* descomprimir_en_frec(void* frec);


int  donde_esta_frec(void* frec, int e, int i);


int  cuantos_mas_grande_frec(void* frec, int e);


int  bits_frec(void* frec){
    Frec temp = *(Frec*)frec;
    int sum = 0;
    sum += sizeof(temp.bits)/sizeof(char*);
    sum += sizeof(temp.representaciones)/sizeof(char*);
    return sum;
}


void  mostrar_frec(void* frec);

