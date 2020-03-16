CC=clang++
CFLAGS=-std=c++11 -stdlib=libc++ 
default: bestpractice.out
	./bestpractice.out

bestpractice.out: bestpractice.cpp
	$(CC) $(CFLAGS) -lglfw -framework CoreVideo -framework OpenGL -framework IOKit -framework Cocoa  -L/usr/local/Cellar/glew/2.1.0/include -lGLEW -framework Carbon bestpractice.cpp -o bestpractice.out


