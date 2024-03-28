package org.nubis.brick.game.utils;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameView extends JFrame implements KeyListener {
    private Image brick;
    private Image player;


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
        g.setColor(new Color(255, 0, 0));
        g.fillRect(0, 35, 100, 100);
        g.setColor(new Color(0, 255, 0));
        g.fillRect(0, 35, 10, 10);
    }

    public void update(){
    }

    @Override
    public void keyTyped(@NotNull KeyEvent e) {
        //System.out.println(e.getKeyChar());
    }

    @Override
    public void keyPressed(@NotNull KeyEvent e) {
        //System.out.println(e.getKeyChar());
    }

    @Override
    public void keyReleased(@NotNull KeyEvent e) {
        System.out.println(e.getKeyChar());
    }
}
