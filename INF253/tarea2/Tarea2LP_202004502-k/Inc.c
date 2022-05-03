#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "Inc.h"

Inc* comprimir_en_inc(int n, int* grupo){
    int* n_dif = (int*)malloc(sizeof(int)*n);
    for (int i = 0;i<n;i++){
        n_dif[i] = -1;
    }
    int flag, ind = 0;
    for (int i = 0;i<n;i++){
        flag = 0;
        for (int j = 0;j<n;j++){
            if (grupo[i] == n_dif[j]){
                flag = 1;
            }
        }
        if (flag == 0){
            n_dif[ind++] = grupo[i];
        }
    }
}


int* descomprimir_en_inc(void* inc);


int  donde_esta_inc(void* inc , int e, int i);


int  cuantos_mas_grande_inc(void* inc , int e);


int  bits_inc(void* inc){
    Inc temp = *(Inc*)inc;
    int bit = sizeof(temp.bits)/sizeof(temp.bits[0]);
    int repre = sizeof(temp.representaciones)/sizeof(temp.representaciones[0]);
    return bit+repre+temp.n;
}


void  mostrar_inc(void* inc){
    Inc temp = *(Inc*)inc;
    int bit = sizeof(temp.bits)/sizeof(temp.bits[0]);
    int repre = sizeof(temp.representaciones)/sizeof(temp.representaciones[0]);
    printf("INCREMENTAL:\n");
    for (int i = 0; i < bit; i++){
        printf("%c", temp.bits[i]);
    }
    printf("\n");
    for (int j = 0; j < repre; j++){
        printf("%c", temp.representaciones[j]);
    }
    printf("\n");
    printf("%c", temp.n);
    printf("\n");
}

