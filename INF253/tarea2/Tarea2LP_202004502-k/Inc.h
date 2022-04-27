
typedef  struct  Inc {
    char* bits; // arreglo de ’0’ y ’1’
    char* representaciones; // arreglo para recordar que representacion tiene cada numero
    char* n; // cantidad de numeros distintos en el conjunto
} Inc;

Inc* comprimir_en_inc(int n, int* grupo);
int* descomprimir_en_inc(void* inc);
int  donde_esta_inc(void* inc , int e, int i);
int  cuantos_mas_grande_inc(void* inc , int e);
int  bits_inc(void* inc);
void  mostrar_inc(void* inc);

