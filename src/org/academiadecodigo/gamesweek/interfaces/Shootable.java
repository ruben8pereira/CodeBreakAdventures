package org.academiadecodigo.gamesweek.interfaces;

import org.academiadecodigo.gamesweek.grid.GridPosition;

public interface Shootable {
    void getShot();

    boolean isBroken();

    GridPosition getGridPosition();
}