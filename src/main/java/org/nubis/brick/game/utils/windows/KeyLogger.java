package org.nubis.brick.game.utils.windows;

import org.nubis.brick.game.utils.BooleanList;


public class KeyLogger {
    private BooleanList stateLogger = new BooleanList();

    public void setKeyState(char keyChar, boolean keyState) { this.stateLogger.insert(keyState, (int)(keyChar)); }

    public boolean getKeyState(char keyChar) { return this.stateLogger.get((int)(keyChar)); }
}
