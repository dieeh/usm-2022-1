#include <stdio.h>
#include <math.h>
#include "Unario.h"
#include "Frec.h"
#include "Inc.h"



typedef struct Conjunto_comprimido {
    // arreglo de representaciones de grupos de numeros dentro del conjunto
    void* representaciones;
} Conjunto_comprimido;

typedef struct Representacion{
    void* representacion; // puntero a la representacion creada
    int* (*su_descomprimir)(void*);  //  punteros a funciones
    int (*su_donde_esta)(void*,int ,int);
    int (*su_cuantos_mas_grande)(void*, int);
    int (*su_bits)(void*);
    void (*su_mostrar)(void*);
} Representacion;

Conjunto_comprimido* comprimir(int c, int* numeros , int g);
int* descomprimir(Conjunto_comprimido* conjunto_comprimido);
int donde_esta(Conjunto_comprimido* conjunto_comprimido , int e, int i);
int cuantos_mas_grande(Conjunto_comprimido* conjunto_comprimido , int e);
int bits_total(Conjunto_comprimido* conjunto_comprimido);
void mostrar(Conjunto_comprimido* conjunto_comprimido);

int main(){
    int c_conjunto, c_grupos;
    printf("Ingrese la cantidad de numeros en el conjunto:");
    scanf("%d", &c_conjunto);
    printf("Ingrese la cantidad de numeros por grupo:");
    scanf("%d", &c_grupos);
    double cantidad_grupos = c_conjunto/c_grupos;
    int x = ceil(cantidad_grupos);

    int** grupos = (int**)malloc(sizeof(int*) * x);
    for (int i = 0; i < cantidad_grupos; i++){
        grupos[i] = (int*)malloc(sizeof(int) * c_grupos);
    }
    
    printf("Ingrese los numeros de forma separada:");
    int conta = 0;
    int n_con, n_pos;
    n_con = n_pos = 0;
    while (conta < c_conjunto){
        int temp;
        printf("Grupo %d, numero %d: ", n_con+1, n_pos+1);  
        scanf("%d", &temp);
        printf("\n");
        grupos[n_con][n_pos++] = temp;
        if (n_pos == c_grupos){
            n_con++;
        }
        conta++;
    }
    
    Conjunto_comprimido conjuntos;
    *(Representacion*)conjuntos.representaciones = (Representacion*)malloc(sizeof(Representacion)*x);

    for (int i = 0; i < x; i++){
        Unario* temp1 = comprimir_en_unario(c_grupos, grupos[i]);
        Frec* temp2 = comprimir_en_frec(c_grupos, grupos[i]);
        Inc* temp3 = comprimir_en_inc(c_grupos, grupos[i]);

        int a, b, c;
        a = bits_unario(temp1);
        b = bits_frec(temp2);
        c = bits_inc(temp3);


        if ((a > b)||(b < c)){
            free(temp1);
            free(temp3);
            *(Frec*)conjuntos.representaciones[i]->representacion = temp2;
            

        }
        
        


    }
    




    return 0;
}