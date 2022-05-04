#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "Inc.h"

Inc* comprimir_en_inc(int n, int* grupo){
    int* n_dif = (int*)malloc(sizeof(int)*n);
    int i, j, k;
    for (i = 0;i<n;i++){
        n_dif[i] = -1;
    }
    int flag, ind = 0;
    for (i = 0;i<n;i++){
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
    int cont = 0;
    for (i = 0; i < n; i++){
        if (n_dif[i] != -1){
            cont++;
        }
    }
    int* numeros_dist = (int*)malloc(sizeof(int)*cont);
    for (j = 0; j < cont; j++){
        numeros_dist[j] = n_dif[j];
    }
    
    //{8,2,3} = 111111110011010111011
    int sum = n;
    for (k = 0; k < cont; k++){
        sum += numeros_dist[k];
        if (k+1 < cont){
            sum += k+1;
        }else if (k+1 == cont){
            sum += k;
        }
    }
    i = j = k = 0;
    char* representacion = (char*)malloc(sizeof(char)*sum);
    for (i = 0; i < sum; i++){
        if (j < numeros_dist[k]){
            representacion[i] = '1';
            j++;
        }else{
            representacion[i++] = '0';
            if (k == 0){
                representacion[i++] = '0';
            }else if ((k > 0) || (k+1 < cont) ){
                int a = 0;
                while (a < k){
                    representacion[i++] = '1';
                    a++;
                }
                representacion[i++] = '0';
            }else{
                int a = 0;
                while (a <= k){
                    representacion[i++] = '1';
                }
            }
        }
    }
    int suma = 0;
    int contador, l, numero_rep;
    l = i = j = k = 0;
    while (l < sum){
        if (representacion[l++] == '1'){   //1111111101011
            i++;
        }else{
            contador = 0;
            numero_rep = i;
            for (int k = 0; k < n; k++){
                if (numero_rep == grupo[k]){
                    contador++;
                }
            }
            if (j == 0){
                suma += 1*contador;
            }else if ((j < cont) || (j+1 < cont)){
                suma += (j+1) * contador;
            }else{
                suma += j * contador;
            }
            j++;
        }
    }
    char* bitcon = (char*)malloc(sizeof(char)*suma);
    l = i = j = k = 0;
    while (l < n){
        for ( i = 0; i < cont; i++){
            if (numeros_dist[i] == grupo[n]){
                if (i == 0){
                    bitcon[j++] = '0';
                }
                if ((i > 0) || (i < cont-1)){
                    int a = 0;
                    while (a < i){
                        bitcon[k++] = '1';
                    }
                    bitcon[k++] = '1';
                }
                if (i+1 == cont){
                    int a = 0;
                    while (a <= i){
                        bitcon[k++] = '1';
                    }
                }
            }
            
        }
        
    }
    int u;
    char* nummm = (char*)malloc(sizeof(char)*cont);
    for (u = 0; u < cont; u++){
        nummm[u] = '1';
    }
    Inc* temp = (Inc*)malloc(sizeof(Inc));
    temp->representaciones = representacion;
    temp->bits = bitcon;
    temp->n = nummm;
    free(n_dif);
    free(numeros_dist);
    return temp;
}


int* descomprimir_en_inc(void* inc){
    Inc temp = *(Inc*)inc;
    int bit = sizeof(temp.bits)/sizeof(temp.bits[0]);
    int repre = sizeof(temp.representaciones)/sizeof(temp.representaciones[0]);
    int nnn = sizeof(temp.n)/sizeof(temp.n[0]);
    int numero_distintos = 0;
    for (int i = 0; i < nnn; i++){
        numero_distintos++;
    }
    
}   


int  donde_esta_inc(void* inc , int e, int i){

}


int  cuantos_mas_grande_inc(void* inc , int e){

}


int  bits_inc(void* inc){
    Inc temp = *(Inc*)inc;
    int bit = sizeof(temp.bits)/sizeof(temp.bits[0]);
    int repre = sizeof(temp.representaciones)/sizeof(temp.representaciones[0]);
    int nnn = sizeof(temp.n)/sizeof(temp.n[0]);
    return bit+repre+nnn;
}


void  mostrar_inc(void* inc){
    Inc temp = *(Inc*)inc;
    int bit = sizeof(temp.bits)/sizeof(temp.bits[0]);
    int repre = sizeof(temp.representaciones)/sizeof(temp.representaciones[0]);
    int nnn = sizeof(temp.n)/sizeof(temp.n[0]);
    printf("INCREMENTAL:\n");
    for (int i = 0; i < bit; i++){
        printf("%c", temp.bits[i]);
    }
    printf("\n");
    for (int j = 0; j < repre; j++){
        printf("%c", temp.representaciones[j]);
    }
    printf("\n");
    for (int k = 0; k < nnn; k++){
        printf("%c", temp.n[k]);
    }
    printf("\n");
}

