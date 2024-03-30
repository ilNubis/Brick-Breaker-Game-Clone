package org.nubis.brick.game.utils.windows;

import org.jetbrains.annotations.NotNull;
import org.nubis.brick.game.utils.Vector2D;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame implements KeyListener {

    private KeyLogger keyLogger = new KeyLogger();

    private Vector2D size = new Vector2D(500, 500);

    private GameView gameView = new GameView(this.size);

    public GameWindow(){
        setTitle("Brick Breaker Game CLone");
        addKeyListener(this);
        add(this.gameView);
        setLocation(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pack();
        setVisible(true);

        this.gameView.startThread(this.keyLogger);
    }

    @Override
    public void keyTyped(@NotNull KeyEvent e) {
        //System.out.println(e.getKeyChar());
    }

    @Override
    public void keyPressed(@NotNull KeyEvent e) {
        keyLogger.setKeyState(e.getKeyChar(), true);
    }

    @Override
    public void keyReleased(@NotNull KeyEvent e) {
        keyLogger.setKeyState(e.getKeyChar(), false);
    }
}
