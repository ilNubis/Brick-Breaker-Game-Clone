package org.nubis.brick.game.utils;

public class BooleanList{

    private int availableSlot = 1;

    private int slotDimension = 5;

    private boolean cardSlot[][];

    private int totalCell = availableSlot*slotDimension;

    public BooleanList() {
        cardSlot = new boolean[availableSlot][slotDimension];
    }

    private void addSlot(){
        this.availableSlot += 1;

        boolean tempCard[][] = new boolean[this.availableSlot][slotDimension];

        for (int i = 0; i<this.availableSlot-1; i++){
            tempCard[i] = this.cardSlot[i];
        }
    }

    private void addSlot(int amount){
        this.availableSlot += amount;

        boolean tempCard[][] = new boolean[this.availableSlot][slotDimension];

        for (int i = 0; i<this.cardSlot.length; i++){
            tempCard[i] = this.cardSlot[i];
        }
        this.cardSlot = tempCard;
    }

    public void insert(boolean elem, int index) {

        float slotTarghet = 0.0f;
        if (index != 0.0f) {
            slotTarghet = index/slotDimension;
        }


        if (slotTarghet > availableSlot) {
            addSlot(
                    (int)(slotTarghet - availableSlot + 0.9f)
            );
        }

        index -= (int)((slotTarghet)*slotDimension);
        this.cardSlot[(int)(slotTarghet)-1][index] = elem;
    }

    public boolean get(int index) {

        float slotTarghet = 0.0f;
        if (index != 0.0f) {
            slotTarghet = index/slotDimension;
        }

        if (slotTarghet > availableSlot) {
            addSlot(
                    (int)(slotTarghet - availableSlot + 0.9f)
            );
        }

        index -= (int)((slotTarghet)*slotDimension);
        return this.cardSlot[(int)(slotTarghet)-1][index];
    }
}