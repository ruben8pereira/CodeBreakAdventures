package org.academiadecodigo.gamesweek.entity;

import org.academiadecodigo.gamesweek.grid.Direction;
import org.academiadecodigo.gamesweek.grid.GridPosition;
import org.academiadecodigo.gamesweek.interfaces.Movable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Bullet extends GameEntity implements Movable {
    private Direction direction;
    private DrunkCodeCadet drunkCodeCadet;

    public Bullet(DrunkCodeCadet drunkCodeCadet) {
        this.drunkCodeCadet = drunkCodeCadet;
        setOpposite(drunkCodeCadet.isOpposite());
        int x = drunkCodeCadet.getGridPosition().getX() + 30;
        int y = isOpposite() ? drunkCodeCadet.getGridPosition().getMaxY() : drunkCodeCadet.getGridPosition().getY() - 33;
        Picture picture = new Picture(x, y, "resources/Depende.png");
        setGrid(drunkCodeCadet.getGrid());
        setGridPosition(new GridPosition(drunkCodeCadet.getGrid(), picture));
        direction = drunkCodeCadet.getDirection();
    }

    @Override
    public void move() {
        if (isOpposite()) {
            getGridPosition().moveInDirection(Direction.DOWN);
        } else {
            getGridPosition().moveInDirection(Direction.UP);
        }
        getGridPosition().moveInDirection(direction);
    }

    public void delete() {
        getGridPosition().delete();
    }
}
