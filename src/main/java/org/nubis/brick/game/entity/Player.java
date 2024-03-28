package org.nubis.brick.game.entity;

import org.nubis.brick.game.utils.CollideShape;
import org.nubis.brick.game.utils.GameEntity;
import org.nubis.brick.game.utils.Vector2D;

import java.awt.*;

public class Player extends GameEntity {


    public Player(String spritePath) {
        super(spritePath);
    }

    public Player(Vector2D shapeDimension, Vector2D position) {
        super(shapeDimension, position);
    }

    public Player(Vector2D shapeDimension) {
        super(shapeDimension);
    }

    public Player(String spritePath, int x, int y) {
        super(spritePath, x, y);
    }

    public Player(String spritePath, CollideShape collideShape) {
        super(spritePath, collideShape);
    }
}