package org.nubis.brick.game.utils.game;

import org.nubis.brick.game.utils.Vector2D;
import org.nubis.brick.game.utils.game.CollideShape;
import org.nubis.brick.game.utils.game.DrawMode;

import javax.swing.*;
import java.awt.*;


public class GameEntity {
    private CollideShape collideShape = CollideShape.RECT;

    private DrawMode drawMode = DrawMode.IMAGE;

    private Vector2D shapeDimension;

    private Image sprite;

    public Vector2D position = new Vector2D(0, 0);

    public GameEntity(String spritePath) {
        setSprite(spritePath);
    }

    public GameEntity(Vector2D shapeDimension, Vector2D position) {
        this.drawMode = DrawMode.AUTO;
        this.shapeDimension = shapeDimension;
        this.position = position;
    }

    public GameEntity(Vector2D shapeDimension){
        this.drawMode = DrawMode.AUTO;
        this.shapeDimension = shapeDimension;
    }

    public GameEntity(String spritePath, int x, int y) {
        this.position = new Vector2D(x, y);
        setSprite(spritePath);
    }

    public GameEntity(String spritePath, CollideShape collideShape){
        this.collideShape = collideShape;
        setSprite(spritePath);
    }

    public void setSprite(String spritePath) {
        this.sprite = new ImageIcon(spritePath).getImage();
        this.shapeDimension = new Vector2D(
                this.sprite.getWidth(null),
                this.sprite.getHeight(null)
        );
    }

    public void draw(Graphics g){
        switch (this.drawMode){
            case AUTO -> {
                g.setColor(new Color(0, 0, 0));
                switch (this.collideShape){
                    case RECT -> {
                        g.fillRect(
                                this.position.getX(),
                                this.position.getY(),
                                this.shapeDimension.getWidth(),
                                this.shapeDimension.getHeight()
                        );
                    }
                    case CIRCLE -> {
                        g.fillOval(
                                this.position.getX(),
                                this.position.getY(),
                                this.shapeDimension.getWidth(),
                                this.shapeDimension.getHeight()
                        );
                    }
                }

            }
            case IMAGE -> {
                g.drawImage(
                        this.sprite,
                        this.position.getX(),
                        this.position.getY(),
                        null
                );
            }
        }
    }

    public boolean isColliding(Vector2D position) {
        return false;
    }
    public boolean isColliding(int x, int y) {
        return false;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void setPosition(int x, int y) {
        this.position = new Vector2D(x, y);
    }

    public Vector2D getPosition() {
        return this.position;
    }

}



