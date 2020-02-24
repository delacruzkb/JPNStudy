package com.example.jpnstudy.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.jpnstudy.DAO.FlashCardDao;
import com.example.jpnstudy.DAO.GrammarDao;
import com.example.jpnstudy.DAO.WordDao;
import com.example.jpnstudy.Entities.Grammar;
import com.example.jpnstudy.Entities.Word;

@Database(entities = {Word.class, Grammar.class}, version = 1, exportSchema = false)
public abstract class FlashCardDatabase extends RoomDatabase{
    public abstract WordDao wordDao();
    public abstract GrammarDao grammarDao();
    public abstract FlashCardDao flashCardDao();
}
