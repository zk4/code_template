#include <GL/glew.h>
#include <GLFW/glfw3.h>
#include <math.h>

#include <vector>
#include <iostream>
#include "math_3d.h"
#include "pipeline.h"
using namespace std;

#define WINDOW_WIDTH 640
#define WINDOW_HEIGHT 480

void CheckStatus( GLuint obj )
{
    GLint status = GL_FALSE;
    if( glIsShader(obj) ) glGetShaderiv( obj, GL_COMPILE_STATUS, &status );
    if( glIsProgram(obj) ) glGetProgramiv( obj, GL_LINK_STATUS, &status );
    if( status == GL_TRUE ) return;
    GLchar log[ 1 << 16 ] = { 0 };
    if( glIsShader(obj) ) glGetShaderInfoLog( obj, sizeof(log), NULL, log );
    if( glIsProgram(obj) ) glGetProgramInfoLog( obj, sizeof(log), NULL, log );
    std::cerr << log << std::endl;
    exit( -1 );
		
}

void AttachShader( GLuint program, GLenum type, const char* src )
{
    GLuint shader = glCreateShader( type );
    glShaderSource( shader, 1, &src, NULL );
    glCompileShader( shader );
    CheckStatus( shader );
    glAttachShader( program, shader );
    glDeleteShader( shader );

		

}

GLuint LoadProgram( const char* vert, const char* geom, const char* frag )
{
    GLuint prog = glCreateProgram();
    if( vert ) AttachShader( prog, GL_VERTEX_SHADER, vert );
    if( geom ) AttachShader( prog, GL_GEOMETRY_SHADER, geom );
    if( frag ) AttachShader( prog, GL_FRAGMENT_SHADER, frag );
    glLinkProgram( prog );
    CheckStatus( prog );
    return prog;
}

#define GLSL(version, shader) "#version " #version "\n" #shader


GLuint program;
GLuint VAO;
// Mouse position
static double xpos = 0, ypos = 0;

void initShader()
{
    const char* vert = GLSL
    (
        410 core,
        layout( location = 0 ) in vec3 position;
				uniform mat4 gWorld;                                                             
        out vec4 Color;
        void main()
        {
            gl_Position = gWorld * vec4(position  , 1.0);
    				Color = vec4(clamp(position, 0.0, 1.0), 1.0);
        }
    );

    const char* frag = GLSL
    (
        410 core,
				in vec4 Color;                                                                      
        out vec4 FragColor;
        void main()
        {
            FragColor = Color;
        }
    );

    program = LoadProgram( vert, NULL, frag );

}

void prepareData(){
    glGenVertexArrays( 1, &VAO );
    glBindVertexArray( VAO );

    GLuint vertex_buffer = 0;
    glGenBuffers( 1, &vertex_buffer );
    glBindBuffer( GL_ARRAY_BUFFER, vertex_buffer );
    Vector3f Vertices[4];
		Vertices[0] = Vector3f(-1.0f, -1.0f, 0.0f);
		Vertices[1] = Vector3f(0.0f, -1.0f, 1.0f);
		Vertices[2] = Vector3f(1.0f, -1.0f, 0.0f);
		Vertices[3] = Vector3f(0.0f, 1.0f, 0.0f);

		glBufferData(GL_ARRAY_BUFFER, sizeof(Vertices), Vertices, GL_STATIC_DRAW);

		// use index 
    GLuint IBO = 0;
    unsigned int indexes[] = {   0, 3, 1,
																 1, 3, 2,
																 2, 3, 0,
																 0, 1, 2 };
    glGenBuffers( 1, &IBO );
    glBindBuffer( GL_ELEMENT_ARRAY_BUFFER, IBO );
    glBufferData( GL_ELEMENT_ARRAY_BUFFER, sizeof(indexes), indexes, GL_STATIC_DRAW );

    glEnableVertexAttribArray( 0 );
    glVertexAttribPointer( 0, sizeof(Vector3f)/sizeof(GL_FLOAT), GL_FLOAT, GL_FALSE, 0, 0 );
		// cancel binding. good practice
    glBindVertexArray( 0 );
}
void renderScene(GLFWwindow* window){
    while( !glfwWindowShouldClose(window) )
    {
        glClearColor( 0, 0, 0, 0 );
        glClear( GL_COLOR_BUFFER_BIT );

    		static float Scale = 0.0f;
				Scale += 0.01f;

				Pipeline p;
				p.Rotate(0.0f, Scale, 0.0f);
				p.WorldPos(0.0f, 0.0f, 3.0f);
				Vector3f CameraPos(0.0f, 0.0f, -3.0f);
				Vector3f CameraTarget(0.0f, 0.0f, 2.0f);
				Vector3f CameraUp(0.0f, 1.0f, 0.0f);
				p.SetCamera(CameraPos, CameraTarget, CameraUp);
				p.SetPerspectiveProj(60.0f, WINDOW_WIDTH, WINDOW_HEIGHT, 1.0f, 100.0f);

    		GLuint gWorldLocation = glGetUniformLocation(program, "gWorld");
				glUniformMatrix4fv(gWorldLocation, 1, GL_TRUE, (const GLfloat*)p.GetTrans());


        glUseProgram( program );
        glBindVertexArray( VAO );
        glDrawElements( GL_TRIANGLES, 12, GL_UNSIGNED_INT, 0 );
        glBindVertexArray( 0 );

        glfwSwapBuffers( window );

        glfwPollEvents();
    }
}

static void cursorPosFun(GLFWwindow* window, double x, double y)
{
    int wnd_width, wnd_height, fb_width, fb_height;
    double scale;

    glfwGetWindowSize(window, &wnd_width, &wnd_height);
    glfwGetFramebufferSize(window, &fb_width, &fb_height);

    scale = (double) fb_width / (double) wnd_width;

    x *= scale;
    y *= scale;

    xpos = x;
    ypos = y;
		cout<< "position"<< x <<","<<y<<endl;
}

static void mouseButtonFun(GLFWwindow* window, int button, int action, int mods)
{
}

int main( int argc, char** argv )
{
    if( !glfwInit() )
        return -1;

    glfwWindowHint( GLFW_CONTEXT_VERSION_MAJOR, 4 );
    glfwWindowHint( GLFW_CONTEXT_VERSION_MINOR, 1 );
    glfwWindowHint( GLFW_OPENGL_FORWARD_COMPAT, GL_TRUE );
    glfwWindowHint( GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE );

    GLFWwindow* window = glfwCreateWindow(WINDOW_WIDTH , WINDOW_HEIGHT, "triangle", NULL, NULL );
    if( !window )
    {
        cerr << "Error on window creating" << endl;
        glfwTerminate();
        return -1;
    }

    glfwMakeContextCurrent( window );

    cout << "GLFW version                : " << glfwGetVersionString() << endl;
    cout << "GLEW_VERSION                : " << glewGetString( GLEW_VERSION ) << endl;
    cout << "GL_VERSION                  : " << glGetString( GL_VERSION ) << endl;
    cout << "GL_VENDOR                   : " << glGetString( GL_VENDOR ) << endl;
    cout << "GL_RENDERER                 : " << glGetString( GL_RENDERER ) << endl;
    cout << "GL_SHADING_LANGUAGE_VERSION : " << glGetString( GL_SHADING_LANGUAGE_VERSION ) << endl;

    glewExperimental = true;
    GLenum err = glewInit();
    if( err!= GLEW_OK )
    {
        cerr << "Glew init failed!" << endl;
        cerr << "Error: " << glewGetErrorString( err ) << endl;
    }


    initShader();
		prepareData();
    glfwSetCursorPosCallback(window, cursorPosFun);
    glfwSetMouseButtonCallback(window, mouseButtonFun);
		renderScene(window);
    glfwTerminate();
    return 0;
}
