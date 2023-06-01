package org.academiadecodigo.gamesweek.grid;

import org.academiadecodigo.simplegraphics.graphics.*;

public class GridPosition {
    private Grid grid;
    private Shape shape;

    public GridPosition(Grid grid, Shape shape) {
        this.grid = grid;
        this.shape = shape;
        shape.draw();
    }

    public void moveInDirection(Direction direction) {
        if (direction == null) {
            return;
        }
        switch (direction) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case RIGHT:
                moveRight();
                break;
            case LEFT:
                moveLeft();
                break;
        }
    }

    private void moveUp() {
        int yTranslate = (getY() <= Grid.PADDING) ? 0 : -1;
        ((Movable) shape).translate(0, yTranslate);
    }

    public void moveDown() {
        int yTranslate = (getMaxY() == grid.getHeight()) ? 0 : 1;
        ((Movable) shape).translate(0, yTranslate);
    }

    public void moveLeft() {
        int xTranslate = (getX() <= Grid.PADDING) ? 0 : -1;
        ((Movable) shape).translate(xTranslate, 0);
    }

    public void moveRight() {
        int xTranslate = (getMaxX() == grid.getWidth() + Grid.PADDING) ? 0 : 1;
        ((Movable) shape).translate(xTranslate, 0);
    }

    public int getX() {
        return shape.getX();
    }

    public int getY() {
        return shape.getY();
    }

    public int getWidth() {
        return shape.getWidth();
    }

    public int getHeight() {
        return shape.getHeight();
    }

    public int getMaxX() {
        return shape.getX() + getWidth();
    }

    public int getMaxY() {
        return shape.getY() + getHeight();
    }

    public void delete() {
        shape.delete();
    }
}
