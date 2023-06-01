package org.academiadecodigo.gamesweek;

import org.academiadecodigo.gamesweek.entity.*;
import org.academiadecodigo.gamesweek.grid.Grid;
import org.academiadecodigo.gamesweek.interfaces.Movable;
import org.academiadecodigo.gamesweek.interfaces.Shootable;
import org.academiadecodigo.gamesweek.keyboard.InitialKeyboard;
import org.academiadecodigo.gamesweek.keyboard.MenuKeyboard;
import org.academiadecodigo.gamesweek.keyboard.PlayerKeyboard;
import org.academiadecodigo.gamesweek.screen.*;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class Game {
    private Grid grid;
    private ArrayList<Movable> movables;
    public static CollisionDetector collisionDetector;
    private InitialScreen initialScreen;
    private KeyboardHandler keyboardHandler;
    public static int NUM_LEVELS = 6;
    private MenuScreen menu;

    public Game() {
        keyboardHandler = new InitialKeyboard(this);
        initialScreen = new InitialScreen(this);
        initialScreen.show();
    }

    public void start() {
        for (int i = 1; i < NUM_LEVELS; i++) {
            loadLevel(i);
            while (!collisionDetector.isLevelCompleted()) {
                if (collisionDetector.isGameOver()) {
                    ScreenManager.displayScreen(FinalScreen.GAME_OVER, true);
                }
                for (Movable movable : movables) {
                    movable.move();
                }
                collisionDetector.check();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        ScreenManager.displayScreen(FinalScreen.YOU_WIN);
    }

    private void loadLevel(int level) {
        grid = new Grid(1000, 600);
        Picture background = new Picture(10, 10, "resources/GameBackground.png");
        background.draw();
        GameLevel gameLevel = new GameLevel("resources/" + level + ".lvl");
        GameEntityFactory gameEntityFactory = new GameEntityFactory();
        ArrayList<Beer> beers = gameEntityFactory.getCodeCadets(gameLevel.getCadetArray(), grid);
        ArrayList<Shootable> shootables = new ArrayList<>(beers);
        movables = new ArrayList<>(beers);
        DrunkCodeCadet drunkCodeCadet = gameEntityFactory.getDrunkCodeCadet(false, grid);
        movables.add(drunkCodeCadet);
        collisionDetector = new CollisionDetector(movables, shootables, drunkCodeCadet);
        keyboardHandler = new PlayerKeyboard(drunkCodeCadet);
    }

    public InitialScreen getInitialScreen() {
        return initialScreen;
    }

    public void makeMenu() {
        menu = new MenuScreen(this);
        keyboardHandler = new MenuKeyboard(this);
        menu.chooseGame();
    }

    public MenuScreen getMenu() {
        return menu;
    }
}
