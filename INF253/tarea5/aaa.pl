% separacion(_,A,B,_):-
%     A > B,
%     !.
% separacion([],_,_,[]).
% separacion(LISTA, X, X, [L]):- 
%     nth0(X, LISTA, L).
% separacion(LISTA, I, J, L):-
%     nth0(I, LISTA, Y),
%     append(L, [Y], L1),
%     I2 is I + 1,
%     (I2 \= J -> separacion(LISTA, I2, J, L1);
%         (nth0(J, LISTA, Z),
%         append(L1, [Z], L2),
%         L = L2)
%     ).


separacion([],_,_,[]).
separacion(LISTA, X, X, [L]):- 
    nth0(X, LISTA, L).
separacion(LISTA, I, J, L):-
    nth0(I, LISTA, X),
    nth1(J, LISTA, Y),
    append(_,[X|Z], LISTA),
    append(P,[Y|_],Z),
    append([X],P,R1),
    append(R1,[Y],L).

%[1,4,23,10,2,5]  3, 5, [10,2,5]


% postorden(vacioB,[]).
% postorden(nodoB(I,R,D),IDR) :-
% 	postorden(I,PostI),
% 	postorden(D,PostD),
% 	concatena(PostI,PostD,ID),
% 	concatena(ID,[R],IDR).

separ(LISTA, I, J, L, NewL):-
    I < J+1,
    nth0(I, LISTA, X),
    append(L, [X], NewL),
    I2 is I + 1,
    separ(LISTA,I2,J,L2,NewL);
    nth0(I, LISTA, X),
    nth0(J, LISTA, Y),
    append(L, [X,Y], NewL).

separ([],_,_,[]).
separ(LISTA, A, A, [L]):- 
    nth0(A, LISTA, L).
separ(LISTA, I, J, L):-
    separ(LISTA, I, J, L, NewL).


arbolbonito([], false).
arbolbonito([_,[],[]], false).
arbolbonito([A, [X,[_],[_]], [Y,[_],[_]]], V):-
    !,
    pasadofuturo(A, 1),
    pasadofuturo(X, 1),
    V is true;
    pasadofuturo(A, 1),
    pasadofuturo(Y, 1),
    V is true.
arbolbonito([A, [X,[_],[_]], [Y,[_],[_]]], V):- 
    !,
    pasadofuturo(A, 0),
    pasadofuturo(X, 0),
    V is true;
    pasadofuturo(A, 0),
    pasadofuturo(Y, 0),
    V is true.
arbolbonito([A, [X,[_],[_]], [_,[],[]]], V):- 
    !,
    pasadofuturo(A, 1),
    pasadofuturo(X, 1),
    V is true;
    pasadofuturo(A, 0),
    pasadofuturo(X, 0),
    V is true.
arbolbonito([A, [_,[],[]], [Y,[_],[_]]], V):- 
    !,
    pasadofuturo(A, 1),
    pasadofuturo(Y, 1),
    V is true;
    pasadofuturo(A, 0),
    pasadofuturo(Y, 0),
    V is true.
arbolbonito([_, B, C], true):-
    arbolbonito(B, true),
    arbolbonito(C, true).