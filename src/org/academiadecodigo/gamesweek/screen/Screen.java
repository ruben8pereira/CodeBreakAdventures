package org.academiadecodigo.gamesweek.screen;

import org.academiadecodigo.gamesweek.grid.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Screen {
    private final String imagePath;

    public Screen(String imagePath) {
        this.imagePath = imagePath;
    }

    public void draw() {
        Picture picture = new Picture(Grid.PADDING, Grid.PADDING, imagePath);
        picture.draw();
    }

    public void draw(boolean hold) {
        draw();
        while(hold) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
