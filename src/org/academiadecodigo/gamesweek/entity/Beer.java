package org.academiadecodigo.gamesweek.entity;

import org.academiadecodigo.gamesweek.grid.Direction;
import org.academiadecodigo.gamesweek.grid.Grid;
import org.academiadecodigo.gamesweek.grid.GridPosition;
import org.academiadecodigo.gamesweek.interfaces.Shootable;

public class Beer extends GameEntity implements Shootable {
    private boolean broken;
    private int directionCounter;
    private int goingDownCounter;
    private boolean isGoingDown;
    private Direction prevDir;

    public Beer(Grid grid, GridPosition gridPosition, Direction direction) {
        setGrid(grid);
        setGridPosition(gridPosition);
        setDirection(direction);
        broken = false;
        isGoingDown = false;
    }

    @Override
    public void getShot() {
        getGridPosition().delete();
        broken = true;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }

    @Override
    public void move() {
        if (broken) {
            return;
        }
        if (isGoingDown) {
            if (goingDownCounter % 15 == 0) {

                directionSwitch();
                isGoingDown = false;
            }
            goingDownCounter++;
            getGridPosition().moveInDirection(getDirection());
            return;
        }
        if (directionCounter % (getGrid().getWidth() / 10) == 0) {
            isGoingDown = true;
            prevDir = getDirection();
            setDirection(Direction.DOWN);
        }
        directionCounter++;
        getGridPosition().moveInDirection(getDirection());
    }

    private void directionSwitch() {
        setDirection(Direction.values()[(prevDir.ordinal() + 2) % 4]);
    }
}
