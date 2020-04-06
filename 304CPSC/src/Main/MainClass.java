package Main;

import GUI.LoginWindow;
import GUI.Screen;
import database.gameHandler;

public class MainClass {
    private Screen screen = null;
    private gameHandler gh = null;
    private LoginWindow lw = null;

    public MainClass() {
        gh = new gameHandler();
    }

    private void start() {
//        lw = new LoginWindow();
//        lw.showFrame(this);
//        screen = new Screen();
//        screen.showFrame();
          login("ora_peterle", "a21320163");

    }

    public static void main(String[] args) {
        MainClass mc = new MainClass();
        mc.start();
    }

    public void login(String text, String valueOf) {
        boolean didConnect = gh.login(text, valueOf);

        if (didConnect) {
            // Once connected, remove login window and start text transaction flow
            // lw.dispose();
            screen = new Screen();
            screen.showFrame();
        }
    }
}
