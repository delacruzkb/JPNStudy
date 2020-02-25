package com.example.jpnstudy.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Fts4;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Fts4
@Entity
public class Word extends FlashCard{

    @Ignore
    @PrimaryKey
    @ColumnInfo(name = "rowid")
    public int id;


    @ColumnInfo(name = "word_hiragana")
    String hiragana;


    @ColumnInfo(name = "word_english")
    String english;


    @ColumnInfo(name = "word_kanji")
    String kanji;


    @ColumnInfo(name = "word_type")
    String type;


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
