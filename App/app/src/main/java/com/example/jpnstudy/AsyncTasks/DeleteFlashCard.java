package com.example.jpnstudy.AsyncTasks;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.FlashCard;

public class DeleteFlashCard  extends AsyncTask<FlashCard,Void,Void> {

    private FlashCardDatabase fcdb;
    public DeleteFlashCard(FlashCardDatabase db)
    {
        fcdb=db;
    }

    @Override
    protected Void doInBackground(FlashCard... flashCards) {
        FlashCard flashCard = flashCards[0];
        fcdb.flashCardDao().delete(flashCard);
        return null;
    }
}
