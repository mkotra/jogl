package org.example;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame {

    public MainFrame() {
        super("Basic JOGL Demo");

        setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        setSize(600, 600);
        setLocation(40, 40);

        setVisible(true);

        setupJOGL();
    }

    private void setupJOGL(){
        GLCapabilities caps = new GLCapabilities(GLProfile.getDefault());
        caps.setDoubleBuffered(true);
        caps.setHardwareAccelerated(true);

        GLCanvas canvas = new GLCanvas(caps);
        canvas.addGLEventListener(new SceneView());
        canvas.requestFocus();

        add(canvas, BorderLayout.CENTER);

        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();
    }
}
