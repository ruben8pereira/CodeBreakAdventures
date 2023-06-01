package org.academiadecodigo.gamesweek.grid;

public class Grid {
    private int width;
    private int height;
    public static int PADDING = 10;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
