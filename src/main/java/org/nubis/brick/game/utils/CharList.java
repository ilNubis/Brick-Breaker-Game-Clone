package org.nubis.brick.game.utils;

public class CharList {

    private int availableSlot = 1;

    private int slotDimension = 5;

    private char cardSlot[][];

    private int totalCell = availableSlot*slotDimension;

    public CharList() {
        cardSlot = new char[availableSlot][slotDimension];
    }

    private void addSlot(){
        this.availableSlot += 1;

        char tempCard[][] = new char[this.availableSlot][slotDimension];

        for (int i = 0; i<this.availableSlot-1; i++){
            tempCard[i] = this.cardSlot[i];
        }
    }

    private void addSlot(int amount){
        this.availableSlot += amount;

        char tempCard[][] = new char[this.availableSlot][slotDimension];

        for (int i = 0; i<this.cardSlot.length; i++){
            tempCard[i] = this.cardSlot[i];
        }
        this.cardSlot = tempCard;
    }

    public void insert(char elem, int index) {

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

    public char get(int index) {

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
