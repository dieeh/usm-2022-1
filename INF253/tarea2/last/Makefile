
output.out: simulacion.o animal.o
	gcc simulacion.o animal.o -o  output.out -Wall -lm

animal.o: Animal.c Animal.h
	gcc -c Animal.c -Wall -lm

simulacion.o: simulacion.c
	gcc -c simulacion.c -Wall -lm

clean: 
	rm output.out simulacion.o animal.o

clear:
	rm output.out simulacion.o animal.o