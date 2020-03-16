#include <GL/glew.h>
#include <GLFW/glfw3.h>
#include <math.h>

#include <vector>
#include <iostream>
#include "math_3d.h"
using namespace std;


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
        layout( location = 0 ) in vec2 position;
				uniform mat4 gWorld;                                                             
        void main()
        {
            gl_Position = gWorld * vec4( position, 0.0, 1.0 );
        }
    );

    const char* frag = GLSL
    (
        410 core,
        out vec4 FragColor;
        void main()
        {
            FragColor = vec4( 0.6, 1.0, 1.0, 1.0 );
        }
    );

    program = LoadProgram( vert, NULL, frag );

    glGenVertexArrays( 1, &VAO );
    glBindVertexArray( VAO );

    GLuint vertex_buffer = 0;
    glGenBuffers( 1, &vertex_buffer );
    glBindBuffer( GL_ARRAY_BUFFER, vertex_buffer );
    float data[] =
    {
        0.0f,0.8f,
        -0.8f, 0.0f,
        0.8f,0.0f
    };
    glBufferData( GL_ARRAY_BUFFER, sizeof(data), data, GL_STATIC_DRAW );

    GLuint index_buffer = 0;
    glGenBuffers( 1, &index_buffer );
    glBindBuffer( GL_ELEMENT_ARRAY_BUFFER, index_buffer );
    unsigned int indexes[] =
    {
        0,1,2
    };
    glBufferData( GL_ELEMENT_ARRAY_BUFFER, sizeof(indexes), indexes, GL_STATIC_DRAW );

    glEnableVertexAttribArray( 0 );

    glVertexAttribPointer( 0, 2, GL_FLOAT, GL_FALSE, 0, 0 );

    glBindVertexArray( 0 );
}
void renderScene(GLFWwindow* window){
    while( !glfwWindowShouldClose(window) )
    {
        glClearColor( 0, 0, 0, 0 );
        glClear( GL_COLOR_BUFFER_BIT );

    		static float Scale = 0.0f;
				Scale += 0.001f;

				Matrix4f World;

				World.m[0][0] = 1.0f; World.m[0][1] = 0.0f; World.m[0][2] = 0.0f; World.m[0][3] = sinf(Scale);
				World.m[1][0] = 0.0f; World.m[1][1] = 1.0f; World.m[1][2] = 0.0f; World.m[1][3] = 0.0f;
				World.m[2][0] = 0.0f; World.m[2][1] = 0.0f; World.m[2][2] = 1.0f; World.m[2][3] = 0.0f;
				World.m[3][0] = 0.0f; World.m[3][1] = 0.0f; World.m[3][2] = 0.0f; World.m[3][3] = 1.0f;

    		GLuint gWorldLocation = glGetUniformLocation(program, "gWorld");
				glUniformMatrix4fv(gWorldLocation, 1, GL_TRUE, &World.m[0][0]);

        glUseProgram( program );
        glBindVertexArray( VAO );
        glDrawElements( GL_TRIANGLES, 3, GL_UNSIGNED_INT, 0 );
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

    GLFWwindow* window = glfwCreateWindow( 640, 480, "bestpractice", NULL, NULL );
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
    glfwSetCursorPosCallback(window, cursorPosFun);
    glfwSetMouseButtonCallback(window, mouseButtonFun);
		renderScene(window);
    glfwTerminate();
    return 0;
}
