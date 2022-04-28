#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "Unario.h"

Unario* comprimir_en_unario(int n, int* grupo){
    int i = 0;
    int k = 0;
    int sum = 0;
    while (k<n){
        sum = sum + grupo[k];
        k++;
    }
    char out[sum];
    k = 0;
    while (k<sum){
        while (i<n){
            int j = 0;
            int p = grupo[i];
            while (j<p){
                out[j] = '1';
                j++;
            }
            out[j]='0';
            i++;
            k = k + (j-1);
        }
    }

    Unario* tempo = (Unario*)malloc(sizeof(Unario*));
    tempo->bits = out;
    return tempo;
}


int* descomprimir_en_unario(void* unario){
    Unario temp = *(Unario*)unario;
    int largo = sizeof(temp.bits)/sizeof(char*);
    int cantidad = 1;
    for (int i = 0; i < largo; i++){
        if (temp.bits[i] == '0'){
            cantidad++;
        }
    }
    int* arreglo = (int*)malloc(sizeof(int)*cantidad);
    int ind = 0;
    int sum = 0;
    for (int j = 0; j < largo; j++){
        if (temp.bits[j]== '1'){
            sum++;
        }else{
            arreglo[ind] = sum;
            sum = 0;
            ind++;
        }
    }
    return arreglo;    
}


int  donde_esta_unario(void* unario , int e, int i);


int  cuantos_mas_grande_unario(void* unario , int e);


int  bits_unario(void* unario){
    Unario temp = *(Unario*)unario;
    int largo = sizeof(temp.bits)/sizeof(char*);
    return largo;
}


void  mostrar_unario(void* unario){
    Unario temp = *(Unario*)unario;
    int largo = sizeof(temp.bits)/sizeof(char*);
    printf("UNARIO:\n");
    for (int i = 0; i < largo; i++){
        printf("%c", temp.bits[i]);
    }
    printf("\n");
}