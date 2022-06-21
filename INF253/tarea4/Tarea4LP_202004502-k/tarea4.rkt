#lang scheme

(define (suma_especial l a)
    (truncate (/ ((lambda (x) 
            (let suma ((a x))
                (if (null? a)
                    0
                    (+ (car a) (suma (cdr a)))
                    )
                )
            )l)a)
        )
    )

(define (merge_simple l1 l2 ops)
    (let ((choose (lambda (x y o) 
        (if (null? x)
            '()
            (cond 
                [(eqv? (car o) #\S) (+ (car x) (car y))]
                [(eqv? (car o) #\R) (- (car x) (car y))]
                [(eqv? (car o) #\M) (* (car x) (car y))]
                )
            )
        )))
        (if (null? l1)
            '()
            (cons (choose l1 l2 ops) (merge_simple (cdr l1) (cdr l2) (cdr ops)))
            )
        )
    )

(define (merge_cola l1 l2 ops)
    ((lambda (x y o)
        (let merge ((a x)(b y)(c o)(l '()))
            (if (or (null? a) (null? b))
                l
                (cond 
                    [(eqv? (car c) #\S) (merge (cdr a)(cdr b)(cdr c)(append l (list((lambda (x y)(+ x y))(car a)(car b)))))]
                    [(eqv? (car c) #\R) (merge (cdr a)(cdr b)(cdr c)(append l (list((lambda (x y)(- x y))(car a)(car b)))))]
                    [(eqv? (car c) #\M) (merge (cdr a)(cdr b)(cdr c)(append l (list((lambda (x y)(* x y))(car a)(car b)))))]
                    )
                )
            )
        )l1 l2 ops)
    )

(define (demerge_simple l f)
    (list (map f l) 
        ((lambda (x y) 
            (let demerge ((a x)(b y))
                (if (null? a)
                    '()
                    (cons ((lambda (x y)(- x y))(car a)(car b))(demerge (cdr a)(cdr b)))
                    )   
                )
            )l (map f l))
        )
    )


;;(mapTail f l)
;;Implementacion de la funcion map que utiliza recursion de cola.
;;Entrega una lista con los resultados de la aplicacion de la funcion f
;;a todos los miembros de la lista l
(define (mapTail f l)
    ((lambda (x y) 
        (let mapeo ((a x)(b y)(c '()))
            (if (null? b)
                c
                (mapeo a (cdr b) (append c (list(a(car b)))))
                )
            )
        )f l)
    )

(define (demerge_cola l f)
    (list (mapTail f l)
        ((lambda (x y) 
            (let demerge ((a x)(b y)(c '()))
                (if (null? a)
                    c
                    (demerge (cdr a)(cdr b)(append c (list((lambda (x y)(- x y))(car a)(car b)))))
                    )
                )
            )l (mapTail f l))
        )
    )

(define (superior l ops f num)
    (if (> (* 2 (suma_especial l num)) 
            (+ (suma_especial (car (demerge_cola (merge_cola l l ops) f)) num) 
                (suma_especial (car (cdr (demerge_cola (merge_cola l l ops) f))) num)
                )
            )
        1
        0)
    )

(define (all_superior matriz_ls matriz_ops matriz_f matriz_nums c f)
    ((lambda (x y z w)
        (let allsup ((a x)(b y)(c z)(d w))
            (if (null? a)
                '()
                (cons (mapTail (lambda (x y z w) (superior x y z w)) (car a)(car b)(car c)(car d) )
                    (allsup (cdr a)(cdr b)(cdr c)(cdr d))
                    )
                )
            )
        )matriz_ls matriz_ops matriz_f matriz_nums)
    )

; Casos de ejemplos
; Cabe destacar que su tarea debe funcionar para cualquier
; caso, hay mas casos de prueba para la correccion

; Funcion 1
(suma_especial '(1 2 3 4) 4)

; Funcion 2
(merge_simple '(1 2 3) '(4 5 6) '(#\S #\M #\R))
(merge_cola '(1 2 3) '(4 5 6) '(#\S #\M #\R))

; Funcion 3
(demerge_simple '(1 2 3 4 5 6) (lambda (x) (quotient x 2)))
(demerge_simple '(1 2 3 4 5 6) (lambda (x) (modulo x 2)))
(demerge_cola '(1 2 3 4 5 6) (lambda (x) (quotient x 2)))
(demerge_cola '(1 2 3 4 5 6) (lambda (x) (modulo x 2)))

; Funcion 4
(superior '(1 2 3) '(#\S #\M #\R) (lambda (x) (- x 2)) 2)
(superior '(1 2 3) '(#\S #\S #\M) (lambda (x) (modulo x 2)) 2)

; Funcion 5
(all_superior
 '(((1 2 3) (1 1 1)) ((2 2 2) (3 4 5)))
 '(((#\S #\M #\R) (#\S #\S #\S)) ((#\R #\R #\R) (#\S #\S #\M)))
 (list (list (lambda (x) (- x 2)) (lambda (x) (modulo x 2))) (list (lambda (x) (quotient x 2)) (lambda (x) (modulo x 2))))
 '((2 3) (2 2))
 2 2
 )

; Otro test
(all_superior
 '(((1 2 3)(4 5 6)(7 8 9)) ((9 8 7)(6 5 4)(3 2 1)) ((3 3 3)(4 4 4)(5 5 5)))
 '(((#\S #\M #\R)(#\S #\S #\S)(#\R #\R #\R))((#\S #\S #\M)(#\M #\M #\M)(#\S #\M #\S))((#\R #\M #\R)(#\R #\S #\S)(#\S #\S #\R)))
 (list (list (lambda (x)(* 2 x))(lambda (x)(* (/ 1 2) x))(lambda (x)(modulo x 3)))(list (lambda (x) (quotient x 2)) (lambda (x) (modulo x 2))(lambda (x) (+ 5 x))) (list (lambda (x)(* 4 x))(lambda (x)(* (/ 1 3) x))(lambda (x)(modulo x 4))))
 '((2 3 2)(3 4 4)(4 2 2)) 
 3 3
 )