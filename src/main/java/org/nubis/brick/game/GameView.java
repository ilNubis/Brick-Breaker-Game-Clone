package org.nubis.brick.game;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    private Image brick;
    private Image player;


    public GameView(){
        setTitle("Brick Breaker Game CLone");
        setSize(500, 500);
        setLocation(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void loadPics(){
        brick = new ImageIcon("Sprites//brick.png").getImage();


        repaint();
    }
    public void paint(@NotNull Graphics g){
        g.drawImage(brick, 0, 30, null);
    }

    public void update(){
        loadPics();
    }
}
