package org.academiadecodigo.gamesweek.entity;

import org.academiadecodigo.gamesweek.GameLevel;
import org.academiadecodigo.gamesweek.grid.Direction;
import org.academiadecodigo.gamesweek.grid.Grid;
import org.academiadecodigo.gamesweek.grid.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class GameEntityFactory {
    public ArrayList<Beer> getCodeCadets(ArrayList<boolean[]> cadetPosConfig, Grid grid) {
        ArrayList<Beer> beers = new ArrayList<>();
        Direction initialDirection = Direction.RIGHT;
        int numRows = cadetPosConfig.size();
        for (int i = 0; i < numRows; i++) {
            int upperPadding = 10;
            int horizontalPadding = 80;
            int horizontalInterval = (grid.getWidth() - horizontalPadding) / (GameLevel.MAX_BEERS_PER_ROW + 2);
            int verticalInterval = (grid.getHeight() - upperPadding) / (numRows * 2);
            for (int j = 0; j < GameLevel.MAX_BEERS_PER_ROW; j++) {
                int x = horizontalPadding + horizontalInterval + (j * (horizontalInterval + 1));
                int y = upperPadding + i * verticalInterval;
                Picture picture = new Picture(x, y, "resources/Beer.png");
                if (cadetPosConfig.get(i)[j]) {
                    GridPosition position = new GridPosition(grid, picture);
                    Beer beer = new Beer(grid, position, initialDirection);
                    beers.add(beer);
                }
            }
            initialDirection = Direction.values()[(initialDirection.ordinal() + 2) % 4];
        }
        return beers;
    }

    public DrunkCodeCadet getDrunkCodeCadet(boolean opposite, Grid grid) {
        int x = (int) (Math.floor(grid.getWidth() / 2.25));
        int y = opposite ? Grid.PADDING + 25 : grid.getHeight() - 55;
        Picture picture = new Picture(x, y, "resources/Aldino.png");
        GridPosition gridPosition = new GridPosition(grid, picture);
        return new DrunkCodeCadet(grid, gridPosition, opposite);
    }
}
