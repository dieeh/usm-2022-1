#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "Frec.h"

Frec* comprimir_en_frec(int n, int* grupo);
int* descomprimir_en_frec(void* frec);
int  donde_esta_frec(void* frec , int e, int i);
int  cuantos_mas_grande_frec(void* frec , int e);
int  bits_frec(void* frec);
void  mostrar_frec(void* frec);