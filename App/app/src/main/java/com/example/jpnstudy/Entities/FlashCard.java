package com.example.jpnstudy.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Fts4;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;



@Fts4
@Entity
public class FlashCard {

    @Ignore
    @PrimaryKey
    @ColumnInfo(name = "rowid")
    public int id;

    @ColumnInfo(name= "card_starred")
    boolean isStarred;

    @ColumnInfo(name= "card_known")
    boolean isKnown;

    @ColumnInfo(name= "card_mastered")
    boolean isMastered;

    @ColumnInfo(name= "card_right_counter")
    int rightCounter;

    @ColumnInfo(name= "card_hiragana")
    String hiragana;

    @ColumnInfo(name= "card_english")
    String english;

    @ColumnInfo(name = "card_kanji")
    String kanji;

    @ColumnInfo(name = "card_type")
    String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getHiragana() {
        return hiragana;
    }

    public void setHiragana(String hiragana) {
        this.hiragana = hiragana;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
