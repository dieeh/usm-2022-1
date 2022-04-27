
typedef struct Frec {
    char* bits;  //  arreglo de ’0' y ’1’
    char* representaciones;   //  arreglo para recordar que representacion tiene cada numero
} Frec;

Frec* comprimir_en_frec(int n, int* grupo);
int* descomprimir_en_frec(void* frec);
int  donde_esta_frec(void* frec , int e, int i);
int  cuantos_mas_grande_frec(void* frec , int e);
int  bits_frec(void* frec);
void  mostrar_frec(void* frec);