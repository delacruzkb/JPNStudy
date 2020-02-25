package com.example.jpnstudy.AsyncTasks.Delete;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;

public class DeleteGrammarAll extends AsyncTask<Void,Void,Void> {

    private FlashCardDatabase fcdb;
    public DeleteGrammarAll(FlashCardDatabase db) {
        fcdb=db;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        fcdb.wordDao().deleteAllWords();
        return null;
    }
}