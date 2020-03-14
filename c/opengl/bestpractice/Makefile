
bestpractice.out: bestpractice.c
	clang++ -std=c++11 -stdlib=libc++ -lglfw -framework CoreVideo -framework OpenGL -framework IOKit -framework Cocoa  -L/usr/local/Cellar/glew/2.1.0/include -lGLEW -framework Carbon bestpractice.c -o bestpractice.out


run: bestpractice.out
	./bestpractice.out
