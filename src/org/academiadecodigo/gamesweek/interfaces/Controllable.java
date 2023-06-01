package org.academiadecodigo.gamesweek.interfaces;

import org.academiadecodigo.gamesweek.grid.Direction;

public interface Controllable {
    void setDirection(Direction direction);

    void shoot();
}