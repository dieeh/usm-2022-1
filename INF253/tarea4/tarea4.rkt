#lang scheme

(define (suma_especial l a)
	(define (suma_aux lista)
		(if (null? lista)
			0
			(+ (car lista) (suma_aux (cdr lista)))
			)
		)
	(/ (suma_aux l) a)
	)

(define (merge_simple l1 l2 ops)
	(let ((choose (lambda (x y o) 
		(if (null? x)
			`()
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
	(lambda (x y o)
		(let merge ((a x)(b y)(c o)(l '()))
						
			)
		)
	)

(define (demerge_simple l f)
	; aqui va la implementacion de esta funcion
	)

(define (demerge_cola l f)
	; aqui va la implementacion de esta funcion
	)

(define (superior l ops f num)
	; aqui va la implementacion de esta funcion
	)

(define (all_superior matriz_ls matriz_ops matriz_f matriz_nums c f)
	; aqui va la implementacion de esta funcion
	)

; Casos de ejemplos
; Cabe destacar que su tarea debe funcionar para cualquier
; caso, hay mas casos de prueba para la correccion

; Funcion 1
(suma_especial '(1 2 3 4) 4)   ;2.5 o 2 1/2

; Funcion 2
(merge_simple '(1 2 3) '(4 5 6) '(#\S #\M #\R))  ; (5 10 -3)
(merge_cola '(1 2 3) '(4 5 6) '(#\S #\M #\R)) 

; Funcion 3
(demerge_simple '(1 2 3 4 5 6) '(lambda (x) (quotient x 2)))
(demerge_simple '(1 2 3 4 5 6) '(lambda (x) (modulo x 2)))
(demerge_cola '(1 2 3 4 5 6) '(lambda (x) (quotient x 2)))
(demerge_cola '(1 2 3 4 5 6) '(lambda (x) (modulo x 2)))

; Funcion 4
(superior '(1 2 3) '(#\S #\M #\R) (lambda (x) (- x 2)) 2)
(superior '(1 2 3) '(#\S #\S #\M) (lambda (x) (modulo x 2)) 2)

; Funcion 5
(all_superior
 '(((1 2 3) (1 1 1)) ((2 2 2) (3 4 5)))
 '(((#\S #\M #\R) (#\S #\S #\S)) ((#\R #\R #\R) (#\S #\S #\M)))'
 '(((lambda (x) (- x 2)) (lambda (x) (modulo x 2))) ((lambda (x) (quotient x 2)) (lambda (x) (modulo x 2))))
 '((2 3) (2 2))
 2 2
 )