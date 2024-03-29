package org.nubis.brick.game.utils.windows;

import org.nubis.brick.game.utils.BooleanList;


public class KeyLogger {
    private final BooleanList keyStateList = new BooleanList();

    public void setKeyState(char keyChar, boolean state) { this.keyStateList.insert(state, keyChar); }

    public boolean getKeyState(char keyChar) { return this.keyStateList.get(keyChar); }
}
