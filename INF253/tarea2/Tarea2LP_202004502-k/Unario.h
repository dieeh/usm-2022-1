
typedef struct Unario{
    char* bits;  //  arreglo  de  ’0’ y  ’1’
} Unario;

typedef struct Representacion{
    void* representacion; // puntero a la representacion creada
    int* (*descomprimir_en_unario)(void*);  //  punteros a funciones
    int (*donde_esta_unario)(void*,int ,int);
    int (*cuantos_mas_grande_unario)(void*,int ,int);
    int (*bits_unario)(void*);
    void (*mostrar_unario)(void*);
} Representacion;

Unario* comprimir_en_unario(int n, int* grupo);
int* descomprimir_en_unario(void* unario);
int  donde_esta_unario(void* unario , int e, int i);
int  cuantos_mas_grande_unario(void* unario , int e);
int  bits_unario(void* unario);
void  mostrar_unario(void* unario); 