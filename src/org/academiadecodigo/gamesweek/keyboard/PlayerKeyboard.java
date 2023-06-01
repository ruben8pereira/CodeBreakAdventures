package org.academiadecodigo.gamesweek.keyboard;

import org.academiadecodigo.gamesweek.interfaces.Controllable;
import org.academiadecodigo.gamesweek.grid.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

public class PlayerKeyboard implements KeyboardHandler {
    private final Keyboard keyboard;
    private final Controllable controllable;

    public PlayerKeyboard(Controllable controllable) {
        this.controllable = controllable;
        keyboard = new Keyboard(this);
        registerListeners();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KEY_RIGHT:
                controllable.setDirection(Direction.RIGHT);
                break;
            case KEY_LEFT:
                controllable.setDirection(Direction.LEFT);
                break;
            case KEY_SPACE:
                controllable.shoot();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KEY_RIGHT || keyboardEvent.getKey() == KEY_LEFT) {
            controllable.setDirection(null);
        }
    }

    private void registerListeners() {
        KeyboardEvent pressLEFT = new KeyboardEvent();
        pressLEFT.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressLEFT.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(pressLEFT);

        KeyboardEvent releaseLEFT = new KeyboardEvent();
        releaseLEFT.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseLEFT.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(releaseLEFT);

        KeyboardEvent pressRIGHT = new KeyboardEvent();
        pressRIGHT.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressRIGHT.setKey(KEY_RIGHT);
        keyboard.addEventListener(pressRIGHT);

        KeyboardEvent releaseRIGHT = new KeyboardEvent();
        releaseRIGHT.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseRIGHT.setKey(KEY_RIGHT);
        keyboard.addEventListener(releaseRIGHT);

        KeyboardEvent pressSPACE = new KeyboardEvent();
        pressSPACE.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressSPACE.setKey(KEY_SPACE);
        keyboard.addEventListener(pressSPACE);
    }
}
