package org.academiadecodigo.gamesweek.keyboard;

import org.academiadecodigo.gamesweek.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MenuKeyboard implements KeyboardHandler {
    private Keyboard keyboard;
    private Game game;

    public MenuKeyboard(Game game) {
        this.game = game;
        this.keyboard = new Keyboard(this);
        KeyboardEvent pressSPACE = new KeyboardEvent();
        pressSPACE.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressSPACE.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(pressSPACE);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            game.getMenu().setNotChosen(false);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
