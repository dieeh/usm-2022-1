
typedef  struct  Inc {
    char* bits; // arreglo de ’0’ y ’1’
    char* representaciones; // arreglo para recordar que representacion tiene cada numero
    char* n; // cantidad de numeros distintos en el conjunto
} Inc;

typedef struct Representacion{
    void* representacion; // puntero a la representacion creada
    int* (*descomprimir_en_inc)(void*);  //  punteros a funciones
    int (*donde_esta_inc)(void*,int ,int);
    int (*cuantos_mas_grande_inc)(void*,int ,int);
    int (*bits_inc)(void*);
    void (*mostrar_inc)(void*);
} Representacion;


int* descomprimir_en_inc(void* inc);
int  donde_esta_inc(void* inc , int e, int i);
int  cuantos_mas_grande_inc(void* inc , int e);
int  bits_inc(void* inc);
void  mostrar_inc(void* inc);

