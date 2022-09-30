#include "test1.h"

int main(){
    int num = 10;
    tEnunciadoAlternativa* alt = (tEnunciadoAlternativa*)malloc(sizeof(tEnunciadoAlternativa)* num);
    for (int i = 0; i < num; i++){
        alt[i].alternativas = (char**)malloc(sizeof(char*)*5);
    }
    printf("si llega aca entonces tamos");

    for (int j = 0; j < num; j++)
    {
        free(alt[j].alternativas);
    }
    free(alt);
    


    return 0;
}