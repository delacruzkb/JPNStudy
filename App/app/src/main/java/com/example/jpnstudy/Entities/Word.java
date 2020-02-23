package com.example.jpnstudy.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Fts4;
import androidx.room.PrimaryKey;

@Fts4
@Entity
public class Word extends FlashCard{

    @PrimaryKey
    @ColumnInfo(name = "rowid")
    public int id;

    @NonNull
    @ColumnInfo(name = "word_japanese")
    String japanese;

    @NonNull
    @ColumnInfo(name = "word_english")
    String english;


    @ColumnInfo(name = "word_kanji")
    String kanji;

    @NonNull
    @ColumnInfo(name = "word_type")
    String type;



    public String getJapanese() {
        return japanese;
    }

    public void setJapanese(String japanese) {
        this.japanese = japanese;
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
