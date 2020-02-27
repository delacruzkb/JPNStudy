package com.example.jpnstudy.Database;

import android.content.Context;

import androidx.room.Room;

public class FlashCardDatabaseReader {
    FlashCardDatabase db;
    public FlashCardDatabaseReader(Context context, String dbName){
        db = Room.databaseBuilder(context.getApplicationContext(), FlashCardDatabase.class, dbName).build();
    }
}
