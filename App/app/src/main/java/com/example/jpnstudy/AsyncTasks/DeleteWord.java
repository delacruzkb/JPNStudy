package com.example.jpnstudy.AsyncTasks;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Word;

public class DeleteWord extends AsyncTask<Word,Void,Void> {

    private FlashCardDatabase fcdb;
    public DeleteWord(FlashCardDatabase db)
    {
        fcdb=db;
    }

    @Override
    protected Void doInBackground(Word... words) {
        Word word = words[0];
        fcdb.wordDao().delete(word);
        return null;
    }
}
