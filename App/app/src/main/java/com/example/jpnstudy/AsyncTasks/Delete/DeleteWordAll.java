package com.example.jpnstudy.AsyncTasks.Delete;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;

public class DeleteWordAll extends AsyncTask<Void,Void,Void> {

    private FlashCardDatabase fcdb;
    public DeleteWordAll(FlashCardDatabase db)
    {
        fcdb=db;
    }

    @Override
    protected java.lang.Void doInBackground(Void... voids) {
        fcdb.wordDao().deleteAllWords();
        return null;
    }
}