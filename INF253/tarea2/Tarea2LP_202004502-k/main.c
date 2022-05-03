#include <stdio.h>
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

    return 0;
}