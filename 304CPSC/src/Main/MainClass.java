package Main;

import GUI.Screen;

public class MainClass {
    private Screen screen = null;

    public MainClass() {
    }

    private void start() {
        screen = new Screen();
        screen.showFrame();
    }

    public static void main(String[] args) {
        MainClass mc = new MainClass();
        mc.start();
    }
}
