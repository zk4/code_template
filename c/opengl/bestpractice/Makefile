.PHONY: default

CC=clang++
CFLAGS=-std=c++11 -stdlib=libc++ 
FRAMEWORK=-framework CoreVideo -framework OpenGL -framework IOKit  -framework Cocoa -framework Carbon  
HEAD=-I./deps
LIB =-I/usr/local/Cellar/glfw3/3.2.1/include/ -L/usr/local/Cellar/glfw3/3.2.1/lib -lglfw3  
LIB+=-I/usr/local/Cellar/glew/2.1.0/include -L/usr/local/Cellar/glew/2.1.0/lib -lglew


default: out
	./out

out: bestpractice.c
	$(CC) $(CFLAGS) $(HEAD) $(LIB) $(FRAMEWORK) *.c -o $@


dev:
	watchexec -rce c "make"


