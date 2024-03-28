package org.nubis.brick.game.utils.windows;

import org.nubis.brick.game.utils.BooleanList;

public class KeyLogger {
    private BooleanList keyStateList = new BooleanList();

    public void setKeyState(char keyChar, boolean state) {
        this.keyStateList.insert(state, (int)(keyChar));
    }

    public boolean getKeyState(char keyChar) {
        return this.keyStateList.get((int)(keyChar));
    }
}
