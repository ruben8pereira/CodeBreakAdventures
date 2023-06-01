package org.academiadecodigo.gamesweek.screen;

import org.academiadecodigo.gamesweek.Game;
import org.academiadecodigo.gamesweek.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MenuScreen {
    private Picture menu;
    private Game game;
    private boolean notChosen = true;

    public MenuScreen(Game game) {
        this.game = game;
        menu = new Picture(Grid.PADDING, Grid.PADDING, "resources/MenuScreen.png");
        menu.draw();
    }

    public void chooseGame() {
        while (notChosen) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Error!");
            }
        }
        menu.delete();
        game.start();
    }

    public void setNotChosen(boolean bool) {
        this.notChosen = bool;
    }
}
