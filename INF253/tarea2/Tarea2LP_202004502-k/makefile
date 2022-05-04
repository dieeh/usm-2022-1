
run.out: main.o Unario.o Frec.o Inc.o
	gcc main.o Unario.o Frec.o Inc.o -o  run.out -Wall -Wextra -lm

Unario.o: Unario.c Unario.h
	gcc -c Unario.c -Wall -Wextra

Frec.o: Frec.c Frec.h
	gcc -c Frec.c -Wall -Wextra

Inc.o: Inc.c Inc.h
	gcc -c Inc.c -Wall -Wextra

main.o: main.c 
	gcc -c main.c -Wall -Wextra -lm

clean: 
	rm *.o *.out

clear:
	rm *.o *.out