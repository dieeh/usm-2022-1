typedef struct Animal{
    void* fuerza;
    char tipo_fuerza;
    void* velocidad;
    char tipo_velocidad;
    void* resistencia;
    char tipo_resistencia;
    void (*reproduccion)(struct Animal*, struct Animal*, struct Animal*);
    void (*comerHuir)(struct Animal*, struct Animal*);
    int coord1;
    int coord2;
} Animal;

extern int n;  //tamaño de la matriz
extern Animal** mundo; //matriz global
extern int** flags; //flags globales;

/*****
*   Animal* SeleccionarEspacio
******
*   Esta funcion revisa los espacios adyacentes al animal a1 y 
*   retorna un espacio disponible, en el caso de que no exista
*   algún espacio disponible, retorna la casilla (0,0) y cambia
*   el valor de bool a 0.
******
*   Input:
*       Animal* a1: Es el puntero a animal, que se usa como centro para ver
*                   los espacios adyacentes.
*       int* bool: Es el puntero a un int que cambiara a valor 1 si es que la
*                  funcion encuentra un espacio y 0 si no encuentra ninguno.
*   
******
*   Returns:
*       Animal* : Retorna el puntero a la casilla desocupada, o a (0, 0) en caso
*                 de que esta no exista.
*****/
extern Animal* SeleccionarEspacio(Animal* a1, int* bool);


/*****
*   void Intercambiar
******
*   Esta funcion intercambia los valores de 2 animales.
******
*   Input:
*       Animal* a1 : Es uno de los animales a intercambiar.
*       Animal* a2 : Es uno de los animales a intercambiar.
******
*   Returns:
*       void : No retorna, solo hace cambios a la matriz.
*****/
extern void Intercambiar(Animal* a1, Animal* a2);


/*****
*   int limites
******
*   Esta funcion cambia el valor del int que le pasan para que
*   esté entre 0 y 999.
******
*   Input:
*       int a : Es el entero a cambiar.
******
*   Returns:
*       int : Retorna el entero cambiado.
*****/
extern int limites(int a);


/*****
*   void CrearAnimal
******
*   Esta funcion crea los animales asignandole valores a las
*   variables sin inicializar del struct Animal.
******
*   Input:
*       Animal* a : Es la direccion de memoria del animal a crear.
******
*   Returns:
*       void : Solo modifica la casilla de la matriz donde se encuentra
*              el animal.
*****/
void CrearAnimal(Animal* a);


/*****
*   void Borrar
******
*   Esta funcion borra los datos del animal en la matriz.
******
*   Input:
*       Animal* a : Animal a borrar.
******
*   Returns:
*       void : No retorna nada, solo hace free() a las componentes del struct
*****/
void Borrar(Animal* a);


/*****
*   void MostrarAnimal
******
*   Esta funcion muestra las estadisticas del animal.
******
*   Input:
*       Animal* a : Es el animal a mostrar.
******
*   Returns:
*       void : No retorna nada, solo imprime por consola los valores.
*****/
void MostrarAnimal(Animal* a);


/*****
*   void Reproducir
******
*   Esta funcion toma al padre y a la madre y al azar selecciona cual
*   funcion reproducir va a utilizar
******
*   Input:
*       Animal* a1 : Es el puntero del animal padre.
*       Animal* a2 : Es el puntero del animal madre.
*       Animal* hijo : Es el puntero al hijo.
******
*   Returns:
*       void : No retorna, solo selecciona la funcion a utilizar.
*****/
void Reproducir(Animal* a1, Animal* a2, Animal* hijo);


/*****
*   void ComerOHuir
******
*   Esta funcion toma 2 animales y al azar selecciona que funcion
*   comerOHuir utilizará.
******
*   Input:
*       Animal* a1 : Animal a utilizar.
*       Animal* a2 : Animal a utilizar.
******
*   Returns:
*       void : No retorna, solo selecciona la funcion a utilizar.
*****/
void ComerOHuir(Animal* a1, Animal* a2);


/*****
*   int Comparar
******
*   Esta funcion compara dos animales transformando sus estadisticas a
*   enteros y comparandolos,
******
*   Input:
*       Animal* a1 : Animal a comparar.
*       Animal* a2 : Animal a comparar.
******
*   Returns:
*       int : Esta funcion retorna 1 si las estadisticas del a1 son mayores
*             a las de a2.
*****/
int Comparar(Animal* a1, Animal* a2);


/*****
*   void BorrarMundo
******
*   Esta funcion libera la memoria pedida para la matriz y borra
*   el mundo.
******
*   Input:
*       Animal** Mundo : Matriz donde están los animales.
******
*   Returns:
*       void: Solo borra el mundo.
*****/
void BorrarMundo(Animal** Mundo);


/*****
*   MostrarMundo
******
*   Esta funcion itera sobre la matriz y muestra los animales 
*   que encuentra por consola.
******
*   Input:
*       Animal** Mundo : Matriz donde están los animales.
******
*   Returns:
*       void : Solo muestra los animales por consola
*****/
void MostrarMundo(Animal** Mundo);


/*****
*   void ReproduccionSimple
******
*   Esta funcion compara las estadisticas de los padres y transmite
*   al hijo las caracteristicas del que tenga mayores estadisticas.
******
*   Input:
*       Animal* a1 : Es el animal padre.
*       Animal* a2 : Es el animal madre.
*       Animal* hijo : Es el puntero al hijo.
******
*   Returns:
*       void : No retorna, solo hace cambios en la matriz.
*****/
void ReproduccionSimple(Animal* a1, Animal* a2, Animal* hijo);


/*****
*   void ReproduccionCruzada
******
*   Esta funcion compara las estadisticas de los padres y transmite
*   al hijo las caracteristicas de forma cruzada, si son mayores las
*   estadisticas del padre, transmite la fuerza, velocidad y funcion de
*   reproduccion de este, y el resto de la madre, si son mayores las
*   estadisticas de la madre, se invierten las caracteristicas transmitidas.
******
*   Input:
*       Animal* a1 : Es el animal padre.
*       Animal* a2 : Es el animal madre.
*       Animal* hijo : Es el puntero al hijo.
******
*   Returns:
*       void : No retorna, solo hace cambios en la matriz.
*****/
void ReproduccionCruzada(Animal* a1, Animal* a2, Animal* hijo);


/*****
*   void ComerSiempre
******
*   Esta funcion compara la fuerza del animal 1 con la resistencia del
*   animal 2, el que tenga menor estadistica, muere.
******
*   Input:
*       Animal* a1 : Animal a utilizar.
*       Animal* a2 : Animal a utilizar.
******
*   Returns:
*       void : No retorna, solo hace cambios en la matriz.
*****/
void ComerSiempre(Animal* a1, Animal* a2);


/*****
*   void HuirSiempre
******
*   Esta funcion busca una casilla para escapar si la velocidad del
*   animal 1 es mayor a la del animal 2, en caso de no encontrarla, 
*   el animal 1 muere, y si la velocidad del animal 2 es mayor a la del
*   animal 1, este muere tambien.
******
*   Input:
*       Animal* a1 : Animal a utilizar.
*       Animal* a2 : Animal a utilizar.
******
*   Returns:
*       void : No retorna, solo hace cambios en la matriz.
*****/
void HuirSiempre(Animal* a1, Animal* a2);


/*****
*   void ComerAleatorio
******
*   Esta funcion toma una estadistica aleatoria de ambos animales,
*   el que tenga la estadistica menor, muere, en caso de empate, muere
*   el animal 1.
******
*   Input:
*       Animal* a1 : Animal a utilizar.
*       Animal* a2 : Animal a utilizar.
******
*   Returns:
*       void : No retorna, solo hace cambios en la matriz.
*****/
void ComerAleatorio(Animal* a1, Animal* a2);