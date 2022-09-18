CFLAGS= -g -Wall
CC=g++

main: main.o graph.o model.o
	$(CC) $(CFLAGS) -o main main.o graph.o model.o

main.o: main.cpp graph.h model.h
	$(CC) $(CFLAGS) -c main.cpp

graph.o: graph.h

model.o: model.h graph.h

clean:
	rm -f *.o main

zip:
	zip project1.zip main.cpp model.h model.cpp graph.h graph.cpp Makefile README.md

cleanzip:
	rm project1.zip 

run:
	./main