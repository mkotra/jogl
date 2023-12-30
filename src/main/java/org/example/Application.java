package org.example;

/**
 * Hello world!
 */
public class Application {

    public static void main(String[] args) {
        System.setProperty("jogl.disable.openglcore", "false");

        MainFrame demo = new MainFrame();
        demo.setVisible(true);
    }
}
