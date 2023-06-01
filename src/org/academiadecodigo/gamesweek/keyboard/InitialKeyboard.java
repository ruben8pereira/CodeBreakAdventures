package org.academiadecodigo.gamesweek.keyboard;

import org.academiadecodigo.gamesweek.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.KEY_SPACE;

public class InitialKeyboard implements KeyboardHandler {
    private Keyboard keyboard;
    private Game game;

    public InitialKeyboard(Game game) {
        this.game = game;
        this.keyboard = new Keyboard(this);
        KeyboardEvent pressSpace = new KeyboardEvent();
        pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressSpace.setKey(KEY_SPACE);
        keyboard.addEventListener(pressSpace);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KEY_SPACE) {
            game.getInitialScreen().stop();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
