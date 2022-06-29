
separacion([],_,_,[]).
separacion(LISTA, X, X, [Y]):- nth0(X, LISTA, Y).
separacion(LISTA, I, J, L):- nth0(I, LISTA, X), nth0(J, LISTA, Y), append(_, [X|Z], LISTA), append(P, [Y|_], Z), append([X], P, T), append(T, [Y], L).

division([], [[], []]).
division(L, [X,Y]):- append(X, Y, L), length(X, P), length(Y, P).
division(L, [X,Y]):- append(X, Y, L), length(X, R), length(Y, P), R is P+1.

pasadofuturo([], 0).
pasadofuturo(LISTA, RES):- division(LISTA, [X, Y]), sum_list(X, Sum1), sum_list(Y, Sum2), Sum1 > Sum2, RES is 1; RES is 0.

arbolbonito([], false).
arbolbonito(ARBOL, ESBONITO):- append([], [], R1), append([_], R1, LISTA).
arbolbonito(ARBOL, true):- append([], [X, [Y|_], Z], ARBOL), pasadofuturo(X,1), pasadofuturo(Y,1);
                            append([], [X, Y, [Z|_]], ARBOL), pasadofuturo(X,1), pasadofuturo(Z,1).
arbolbonito(ARBOL, ESBONITO):- append([], [X, [Y,S,D], Z], ARBOL), member(_, S), arbolbonito(Y, true);
                                append([], [X, Y, [Z,S,D]], ARBOL), member(_, S), arbolbonito(Z, true);

    

[ [1, 4, 23, 10, 2, 5], [ [1, 2, 3], [ [1, 2], [], [] ], [ [2, 3], [], [] ] ], [ [1, 2], [], []] ].