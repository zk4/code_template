.PHONY: default, tags

CC=clang++
CFLAGS=-std=c++11 -stdlib=libc++  `Magick++-config --cppflags`
FRAMEWORK=-framework CoreVideo -framework OpenGL -framework IOKit  -framework Cocoa -framework Carbon  
HEAD=-I./deps  -I/usr/local/Cellar/imagemagick/7.0.8-46/include/ImageMagick-7
LIB =-I/usr/local/Cellar/glfw3/3.2.1/include/ -L/usr/local/Cellar/glfw3/3.2.1/lib -lglfw3  
LIB+=-I/usr/local/Cellar/glew/2.1.0/include -L/usr/local/Cellar/glew/2.1.0/lib -lglew `Magick++-config --libs` `Magick++-config --ldflags`


default: out
	./out

out: *.cpp
	$(CC) $(CFLAGS) $(HEAD) $(LIB) $(FRAMEWORK) *.cpp -o $@


tags:
	g++ -M -I$(HEAD) *.cpp *.h 2>/dev/null \
		| tr -d \\ \
		| awk 'ORS=" "' \
		|xargs  ctags -L - --c++-kinds=+p --fields=+iaS --extras=+q
