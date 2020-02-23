package com.example.jpnstudy.Entities;

import androidx.room.ColumnInfo;

public class FlashCard {

    @ColumnInfo(name= "card_starred")
    boolean isStarred;

    @ColumnInfo(name= "card_known")
    boolean isKnown;

    @ColumnInfo(name= "card_mastered")
    boolean isMastered;

    @ColumnInfo(name= "card_right_counter")
    int rightCounter;


    public boolean isStarred() {
        return isStarred;
    }

    public void setStarred(boolean starred) {
        isStarred = starred;
    }

    public boolean isKnown() {
        return isKnown;
    }

    public void setKnown(boolean known) {
        isKnown = known;
    }

    public boolean isMastered() {
        return isMastered;
    }

    public void setMastered(boolean mastered) {
        isMastered = mastered;
    }

    public int getRightCounter() {
        return rightCounter;
    }

    public void setRightCounter(int rightCounter) {
        this.rightCounter = rightCounter;
    }
}
