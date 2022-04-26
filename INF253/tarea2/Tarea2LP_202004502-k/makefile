
run.out: main.o Unario.o Frec.o Inc.o
	gcc main.o Unario.o Frec.o Inc.o -o  run.out -Wall -lm

Unario.o: Unario.c Unario.h
	gcc -c Unario.c -Wall -lm

Frec.o: Frec.c Frec.h
	gcc -c Frec.c -Wall -lm

Inc.o: Inc.c Inc.h
	gcc -c Inc.c -Wall -lm

main.o: main.c 
	gcc -c main.c -Wall -lm

clean: 
	rm *.o *.out

clear:
	rm *.o *.out