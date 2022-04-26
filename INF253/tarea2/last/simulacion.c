#include <stdio.h>
#include <stdlib.h>
#include <math.h>
//#include <stdbool.h> //bool no funcionaba (? creo que es por la version de C -> **cambiado por un int 0 y 1**
#include "Animal.h"



void iteracion_temp(Animal** Mundo, int** flag){
    for (int a = 0; a < n; a++){
        for (int b = 0; b < n; b++){
            int bandera = flags[a][b];
            if ((mundo[a][b].fuerza != NULL) && (bandera != 0)){
                int random = rand();

                if (random%4 == 0){ //up
                    if (mundo[a][limites(b+1)].fuerza == NULL){
                        Intercambiar(&(mundo[a][b]),&(mundo[a][limites(b+1)]));
                    }else{
                        int p = 0;
                        Animal* temp = SeleccionarEspacio(&(mundo[a][b]), &p);
                        if (p != 0){
                            Reproducir(&(mundo[a][b]),&(mundo[a][limites(b+1)]), &(*temp));
                        }
                        ComerOHuir(&(mundo[a][b]),&(mundo[a][limites(b+1)]));
                    }
                }
                if (random%4 == 1){ //right
                    if (mundo[limites(a+1)][b].fuerza == NULL){
                        Intercambiar(&(mundo[a][b]),&(mundo[limites(a+1)][b]));
                    }else{
                        int p = 0;
                        Animal* temp = SeleccionarEspacio(&(mundo[a][b]), &p);
                        if (p != 0){
                            Reproducir(&(mundo[a][b]),&(mundo[limites(a+1)][b]), &(*temp));
                        }
                        ComerOHuir(&(mundo[a][b]),&(mundo[limites(a+1)][b]));
                    }
                }
                if (random%4 == 2){ //down
                    if (mundo[a][limites(b-1)].fuerza == NULL){
                        Intercambiar(&(mundo[a][b]),&(mundo[a][limites(b-1)]));
                    }else{
                        int p = 0;
                        Animal* temp = SeleccionarEspacio(&(mundo[a][b]), &p);
                        if (p != 0){
                            Reproducir(&(mundo[a][b]),&(mundo[a][limites(b-1)]), &(*temp));
                        }
                        ComerOHuir(&(mundo[a][b]),&(mundo[a][limites(b-1)]));
                    }
                }
                if (random%4 == 3){ //left
                    if (mundo[limites(a-1)][b].fuerza == NULL){
                        Intercambiar(&(mundo[a][b]),&(mundo[limites(a-1)][b]));
                    }else{
                        int p = 0;
                        Animal* temp = SeleccionarEspacio(&(mundo[a][b]), &p);
                        if (p != 0){
                            Reproducir(&(mundo[a][b]),&(mundo[limites(a-1)][b]), &(*temp));
                        }
                        ComerOHuir(&(mundo[a][b]),&(mundo[limites(a-1)][b]));
                    }
                }
            }
        }
    }
    int i, j;
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            if (mundo[i][j].fuerza == NULL){
                flags[i][j] = 0;
            }else{
                flags[i][j] = 1;
            }
            
        }
        
    }
    
}


int n = 1000;  //cambiar dsps
Animal** mundo; //matriz global
int** flags; //flags globales de sim

int main(){
    int programa = 1; //ex bool
    int i, j;
    mundo = (Animal**)malloc(sizeof(Animal*) * n);
    for(i = 0; i < n; i++){
        mundo[i] = (Animal*)malloc(sizeof(Animal) * n);
    }

    flags = (int**)malloc(sizeof(int*) * n);
    for (int i = 0; i < n; i++){
        flags[i] = (int*)malloc(sizeof(int) * n);
    }
    
    for (i = 0; i < n; i++){
        for (j = 0; j < n; j++){
            flags[i][j] = 0;
        }   
    }
    
    srand(20788120);  //seed del rand()

    //menu
    while (programa == 1){
        int input;
        printf("\n");
        printf("------Menú------\n");
        printf("1.- Crear animal\n");
        printf("2.- Avanzar una iteración en el tiempo\n");
        printf("3.- Mostrar el mundo\n");
        printf("4.- Terminar el programa\n");
        printf("----------------\n");
        printf("\n");
        printf("Ingrese una opcion del menu: ");
        scanf(" %d", &input);
        if (input == 1){
            int x, y;
            printf("Ingrese coordenada x (0-999): ");
            scanf(" %d", &x);
            printf("Ingrese coordenada y (0-999): ");
            scanf(" %d", &y);
            mundo[x][y].coord1 = x;
            mundo[x][y].coord2 = y;
            CrearAnimal(&(mundo[x][y]));
            flags[x][y] = 1;
            continue;
        }
        if (input == 2){
            iteracion_temp(mundo, flags);
        }
        if (input == 3){
            MostrarMundo(mundo);
            continue;
        }
        if (input == 4){
            programa = 0;
            BorrarMundo(mundo);
            break;
        }
    }
    
    for (i = 0; i < n; i++){  
        free(flags[i]);      
    }
    free(flags);
    return 0;
}