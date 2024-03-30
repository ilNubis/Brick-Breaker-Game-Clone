package org.nubis.brick.game.utils.windows;

public class FPSManager {
    private final long SEC_NSEC = 1000000000;
    private int maxFrames = 60;
    private double frameRunTime = (double) SEC_NSEC / maxFrames;

    private long lastTime;
    private double delta;

    private long timer;
    private int frame;

    public FPSManager() {
        this.lastTime = System.nanoTime();
    }

    public boolean run() {

        long currentTime = System.nanoTime();

        long deltaTime = (currentTime -this.lastTime);
        this.delta += deltaTime/this.frameRunTime;
        this.timer += deltaTime;
        this.lastTime = currentTime;

        boolean result = (delta >= 1);


        if (result) {
            this.delta--;
            this.frame++;
        }

        if (this.timer >= this.SEC_NSEC) {
            this.frame = 0;
            this.timer = 0;
        }

        return result;
    }

    public void setMaxFrames(int newLimit) {
        if (newLimit < 0) newLimit *= -1;

        this.maxFrames = newLimit;
        this.frameRunTime = (double) this.SEC_NSEC /newLimit;
    }

    public int getCurrentFrame() {
        return this.frame;
    }
}
