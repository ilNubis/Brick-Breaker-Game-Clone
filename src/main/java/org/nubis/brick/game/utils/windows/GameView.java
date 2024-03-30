package org.nubis.brick.game.utils.windows;

import org.jetbrains.annotations.NotNull;
import org.nubis.brick.game.entity.Player;
import org.nubis.brick.game.utils.Vector2D;
import org.nubis.brick.game.utils.windows.KeyLogger;

import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameView extends JPanel implements Runnable{

    private Color backgroundColor = new Color(0, 0, 0);

    private Vector2D size = new Vector2D(500, 500);

    private Thread thread;

    private KeyLogger keyLogger;

    private Player player = new Player(
            new Vector2D(10, 10),
            new Vector2D(30, 60)
    );

    public GameView() {
        setPreferredSize(this.size);
        setBackground(this.backgroundColor);
        setDoubleBuffered(true);
    }

    public GameView(Vector2D size) {
        setPreferredSize(size);
        setBackground(this.backgroundColor);
        setDoubleBuffered(true);
    }

    public void setPreferredSize(Vector2D preferredSize) {

        super.setPreferredSize(
                new Dimension(
                        preferredSize.getWidth(),
                        preferredSize.getHeight()
                )
        );
    }

    public void startThread(KeyLogger keyLogger) {
        // player settings
        this.player.setColor(Color.WHITE);

        // Keyboard logger
        this.keyLogger = keyLogger;

        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run() {
        FPSManager gameLoop = new FPSManager();

        while (this.thread != null) {

            if (gameLoop.run()) {
                update();

                repaint();
            }
        }
    }

    public void update(){


        // Player movement
        Vector2D move = new Vector2D();

        if (keyLogger.getKeyState('w')) move.add(0, -1);
        if (keyLogger.getKeyState('a')) move.add(-1, 0);
        if (keyLogger.getKeyState('s')) move.add(0, 1);
        if (keyLogger.getKeyState('d')) move.add(1, 0);

        this.player.position.add(move);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.player.draw(g);
    }
}
