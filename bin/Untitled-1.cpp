#include <windows.h> // for MS Windows

#include <GL/glut.h> // GLUT, include glu.h and gl.h


/* Initialize OpenGL Graphics */

void init() {

// Set "clearing" or background color

glClearColor(0.0f, 0.0f, 0.0f, 1.0f); // Black and opaque

}


void display() {

glClear(GL_COLOR_BUFFER_BIT); // Clear the color buffer

glMatrixMode(GL_MODELVIEW); // To operate on Model-View matrix

glLoadIdentity(); // Reset the model-view matrix


glTranslatef(1.1f, 0.2f, 0.0f); // Translate right and up

glBegin(GL_TRIANGLES); // Each set of 3 vertices form a triangle

glColor3f(0.0f, 0.0f, 1.0f); // Blue

glVertex2f(-0.3f, -0.2f);

glVertex2f( 0.3f, -0.2f);

glVertex2f( 0.0f, 0.3f);

glEnd();


glFlush(); // Render now

}


/* Handler for window re-size event */

void reshape(GLsizei width, GLsizei height)

{

// Compute aspect ratio of the new window

if(height == 0) height = 1; // To prevent divide by 0

GLfloat aspect =(GLfloat)width /(GLfloat)height;


// Set the viewport to cover the new window

glViewport(0, 0, width, height);


// Set the aspect ratio of the clipping area to match the viewport

glMatrixMode(GL_PROJECTION);

glLoadIdentity();

if(width >= height) {

// aspect >= 1, set the height from -1 to 1, with larger width

gluOrtho2D(-1.0 * aspect, 1.0 * aspect, -1.0, 1.0);

} else {

// aspect < 1, set the width to -1 to 1, with larger height

gluOrtho2D(-1.0, 1.0, -1.0 / aspect, 1.0 / aspect);

}

} //reshape


int main(int argc, char** argv)

{

glutInit(&argc, argv); // Initialize GLUT

glutInitWindowSize(640, 480); // Set the window's initial width & height - non-square

glutInitWindowPosition(50, 50); // Position the window's initial top-left corner

glutCreateWindow("sv102102102 - Modelview matrix");

glutDisplayFunc(display); // Register callback handler for window re-paint event

glutReshapeFunc(reshape); // Register callback handler for window re-size event

init(); // Our own OpenGL initialization

glutMainLoop(); // Enter the infinite event-processing loop

return 0;

}//main