

CC = g++
OBJS = $(patsubst %.cxx, %.o, $(wildcard *.cxx))


%.o: %.cxx
	$(CC) -c $< -o $@

lib%.a:%.o
	ar rc $@ $<

lib%.so: %.o
	rm -f lib%.a
	$(CC) -shared %.o -o lib%.so


clean:
	rm -f *.a
	rm -f *.o


.PHONY: *.exe 

main.exe: libmain.a libwork.a
	gcc -S  main.cxx -o main.s
	@$(CC) -L. -o $@ -lwork -lmain

main2.exe: libmain.a libwork.a
	$(CC) -L. -o $@ -lmain -lwork 
	./$@

main3.exe: libmain.a libwork.a libconflict.a
	$(CC) -L. -o $@ -lmain -lwork -lconflict
	./$@

main4.exe: libmain.a libwork.a libconflict.a
	$(CC) -L. -o $@ -lmain -lconflict -lwork 
	./$@

main5.exe: clean libmain.a libwork.a libconflict.so
	$(CC) -L. -o $@ -lmain -lconflict -lwork 
	export LD_LIBRARY_PATH=. && ./$@
