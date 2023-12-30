package org.example;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

import java.util.logging.Logger;

public class SceneView implements GLEventListener {

    private static Logger logger = Logger.getLogger(SceneView.class.getName());

    float angle = 0.1f; // Przykładowy kąt rotacji
    private long lastUpdateTime;

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 0);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        logger.info("display called! angle: " + angle);

        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastUpdateTime >= 16) { // 60 FPS (1000 ms / 60 = 16.67)
            if (angle > 1.0f) {
                angle = 0.1f;
            }
            angle += 0.1f; // Zwiększenie kąta rotacji
            lastUpdateTime = currentTime;
        }

        gl.glRotatef(angle, 1.0f, 1.0f, 1.0f);

        gl.glBegin(GL2.GL_TRIANGLES);

        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(-0.5f, -0.5f, 0.0f);

        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.5f, -0.5f, 0.0f);

        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.5f, 0.0f);

        gl.glEnd();
        gl.glFlush();

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

    }
}
