package org.nubis.brick.game.utils;

import org.jetbrains.annotations.NotNull;

public class Vector2D {

    private double x;

    private double y;

    private double mug;

    private double degree;

    public Vector2D(){

    }

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
        this.mug = getMug();
        this.degree = getDegree();
    }

    public double getMug() {
        return Math.sqrt(
                (this.x*this.x)+(this.y*this.y)
        );
    }

    public double getDegree() {

        double degree = Math.toDegrees(Math.acos(getNormalizedX()));
        if (this.y < 0 && degree < 180){
            degree = 360.0d - degree;
        }

        return degree;
    }

    public double getRealX() {
        return this.x;
    }

    public double getRealY() {
        return this.y;
    }

    public double getNormalizedX() {
        return this.x/this.mug;
    }

    public double getNormalizedY() {
        return this.y/this.mug;
    }

    public int getX() {
        return (int)(this.x + 0.5d);
    }

    public int getY() {
        return (int)(this.y + 0.5d);
    }

    public int getWidth() {
        return getX();
    }

    public int getHeight() {
        return getY();
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
        this.mug = getMug();
        this.degree = getDegree();
    }

    public void add(@NotNull Vector2D vector) {
        add(vector.getRealX(), vector.getRealY());
    }

    public void sub(float x, float y) {
        add(-x, -y);
    }

    public void sub(@NotNull Vector2D vector) {
        add(-vector.getX(), -vector.getY());
    }

    public void normalize() {
        double normalizedMug = 1/this.mug;
        this.x *= normalizedMug;
        this.y *= normalizedMug;
        this.mug = getMug();
    }

    public Vector2D getNormalized() {
        return new Vector2D(
                this.x/this.mug,
                this.y/this.mug
        );
    }

    public void setMug(double newMug) {
        this.mug = Math.abs(newMug);
        this.x *= newMug;
        this.y *= newMug;
    }

    public void setDegree(double degree) {
        if (degree < 0) {
            degree *= -1;
        }

        if (degree > 360) {
            degree -= 360*((int)(degree/360));
        }

        this.degree = degree;
        double radians = Math.round(Math.toRadians(degree));
        this.x = Math.round(Math.cos(radians));
        this.y = Math.round(Math.sin(radians));

        this.setMug(this.mug);
    }

    public void str() {
        System.out.println("("+Double.toString(this.x)+", " +Double.toString(this.y)+ ")");
    }
}
