
default: out
	./out

out: *.cpp
	clang++ -std=c++11 -stdlib=libc++ \
	-I/Users/zk/git/cPrj/oglsuperbible5/Src/GLTools/include \
	-I/usr/local/Cellar/glew/2.1.0/include/GL \
	-framework OpenGL \
	-framework GLUT \
	-framework Cocoa  \
	-L/Users/zk/git/cPrj/oglsuperbible5/XCode/GLTools -lGLTools \
	-L/usr/local/Cellar/glew/2.1.0/ -lGLEW \
	-lglew \
	 *.cpp \
	-o $@


