package com.example.jpnstudy.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.jpnstudy.DAO.FlashCardDao;
import com.example.jpnstudy.Entities.FlashCard;

@Database(entities = {FlashCard.class}, version = 1, exportSchema = false)
public abstract class FlashCardDatabase extends RoomDatabase{
    public abstract FlashCardDao flashCardDao();
}
