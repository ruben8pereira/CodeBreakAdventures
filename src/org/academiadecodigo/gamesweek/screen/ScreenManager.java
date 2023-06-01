package org.academiadecodigo.gamesweek.screen;

public class ScreenManager {
    public static void displayScreen(FinalScreen finalScreen) {
        Screen screen = new Screen(finalScreen.getPath());
        screen.draw();
    }

    public static void displayScreen(FinalScreen finalScreen, boolean hold) {
        Screen screen = new Screen(finalScreen.getPath());
        screen.draw(hold);
    }
}
