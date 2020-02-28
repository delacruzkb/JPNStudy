package com.example.jpnstudy.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Fts4;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Fts4
@Entity
public class Grammar extends FlashCard{
    //TODO: implement
    @Ignore
    @PrimaryKey
    @ColumnInfo(name = "rowid")
    public int id;

    @ColumnInfo(name = "grammar_name")
    String name;

    @ColumnInfo(name = "grammar_definition")
    String definition;

    @ColumnInfo(name= "grammar_example")
    String example;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
