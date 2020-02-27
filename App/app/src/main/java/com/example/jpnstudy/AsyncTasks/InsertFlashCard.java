package com.example.jpnstudy.AsyncTasks;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.FlashCard;

public class InsertFlashCard extends AsyncTask<FlashCard,Void,Void> {

    private FlashCardDatabase fcdb;
    public InsertFlashCard(FlashCardDatabase db)
    {
        fcdb=db;
    }

    @Override
    protected Void doInBackground(FlashCard... flashCards){
        FlashCard flashCard = flashCards[0];
        fcdb.flashCardDao().insert(flashCard);
        return null;
    }
}
