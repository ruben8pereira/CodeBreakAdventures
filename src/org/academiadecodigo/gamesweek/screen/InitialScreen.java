package org.academiadecodigo.gamesweek.screen;

import org.academiadecodigo.gamesweek.Game;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class InitialScreen {
    private Picture background;
    private boolean drawn = false;
    private boolean notStarted = true;
    private Game game;

    public InitialScreen(Game game) {
        background = new Picture(10, 10, "resources/StartScreen.png");
        background.draw();
        this.game = game;
    }

    public void show() {
        while (notStarted) {
            try {
                if (drawn) {
                    drawn = false;
                    Thread.sleep(750);
                } else {
                    drawn = true;
                    Thread.sleep(750);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        background.delete();
        System.out.println(Canvas.getInstance().getShapes().size());
        game.makeMenu();
    }

    public void stop() {
        notStarted = false;
    }
}
