package org.nubis.brick.game;

import org.nubis.brick.game.utils.CharList;
import org.nubis.brick.game.utils.windows.GameView;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //1. Create the frame.
        GameView mainWindow = new GameView();


        long SEC_NSEC = 1000000000;
        int MAX_FPS = 60;
        long TIME_SINGLE_FRAME = (SEC_NSEC/MAX_FPS);

        long execTimeFrame = 1;
        long startTime = 0;
        long endTime = 0;

        // prendere gli fps, capire se sono maggiori di quelli massimi, non eseguire
        while (true){
            if (execTimeFrame >= TIME_SINGLE_FRAME || startTime == 0) {
                startTime = System.nanoTime();
                // ... Code
                mainWindow.update();
                //System.out.println(SEC_NSEC/execTimeFrame);

            } else{
                endTime = System.nanoTime();
            }
            execTimeFrame = (endTime-startTime); // tempo in singolo

        }

    }
}