package org.nubis.brick.game.utils.windows;

import org.jetbrains.annotations.NotNull;
import org.nubis.brick.game.entity.Player;
import org.nubis.brick.game.utils.Vector2D;
import org.nubis.brick.game.utils.windows.KeyLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameView extends JFrame implements KeyListener {
    private Image brick;
    private Player player = new Player(
            new Vector2D(10, 10),
            new Vector2D(30, 60)
    );

    private KeyLogger keyLogger = new KeyLogger();

    public GameView(){
        setTitle("Brick Breaker Game CLone");
        addKeyListener(this);
        setSize(500, 500);
        setLocation(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        loadPics();
    }
    public void loadPics(){
        brick = new ImageIcon("Sprites//brick.png").getImage();


        repaint();
    }
    public void paint(@NotNull Graphics g){ // 30 pixel gap on Y axes
        this.player.draw(g);

    }

    public void update(){
        Vector2D direction = new Vector2D();

        if(keyLogger.getKeyState('w')) direction.add(0, -1);
        if(keyLogger.getKeyState('a')) direction.add(-1, 0);
        if(keyLogger.getKeyState('s')) direction.add(0, 1);
        if(keyLogger.getKeyState('d')) direction.add(1, 0);


        this.player.position.add(direction);
        this.player.position.str();
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
