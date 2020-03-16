CC=clang++
CFLAGS=-std=c++11 -stdlib=libc++ 
FRAMEWORK=-framework CoreVideo -framework OpenGL -framework IOKit  -framework Cocoa -framework Carbon 
HEAD=-I/usr/local/Cellar/glew/2.1.0/include
LIB=-lglfw  -lGLEW 
default: out
	./out

bestpractice.o: *.cpp
	$(CC) $(CFLAGS) $(HEAD) $(LIB) $(FRAMEWORK) -c *.cpp

out: bestpractice.o
	$(CC) $(CFLAGS) $(HEAD) $(LIB) $(FRAMEWORK) *.cpp -o $@


