package org.academiadecodigo.gamesweek.entity;

import org.academiadecodigo.gamesweek.Game;
import org.academiadecodigo.gamesweek.grid.Direction;
import org.academiadecodigo.gamesweek.grid.Grid;
import org.academiadecodigo.gamesweek.grid.GridPosition;
import org.academiadecodigo.gamesweek.interfaces.Controllable;

public class DrunkCodeCadet extends GameEntity implements Controllable {
    private boolean willShoot;

    public DrunkCodeCadet(Grid grid, GridPosition gridPosition, boolean opposite) {
        setOpposite(opposite);
        super.setGrid(grid);
        super.setGridPosition(gridPosition);
        setDirection(null);
        willShoot = false;
    }

    public void shoot() {
        willShoot = true;
    }

    @Override
    public void move() {
        if (willShoot) {
            willShoot = false;
            Game.collisionDetector.addBullet(new Bullet(this));
        }
        getGridPosition().moveInDirection(getDirection());
    }

    @Override
    public void setDirection(Direction direction) {
        if (isOpposite() && direction != null) {
            direction = Direction.values()[(direction.ordinal() + 2) % 4];
        }
        super.setDirection(direction);
    }
}
