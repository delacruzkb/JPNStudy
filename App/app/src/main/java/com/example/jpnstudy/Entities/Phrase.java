package com.example.jpnstudy.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Fts4;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Fts4
@Entity
public class Phrase extends FlashCard{
  @Ignore
  @PrimaryKey
  @ColumnInfo(name="rowid")
  public int id;
  
  @ColumnInfo(name = "phrase_phrase")
  String phrase;

  @ColumnInfo(name = "phrase_phrase_blank")
  String phraseBlank;

  @ColumnInfo(name= "grammar_phrase_answer")
  String phraseAnswer;
  
  //TODO: Getters and setters
  
}
