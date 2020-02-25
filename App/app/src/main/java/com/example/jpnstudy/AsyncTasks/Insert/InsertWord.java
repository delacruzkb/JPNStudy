package com.example.jpnstudy.AsyncTasks.Insert;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Word;

public class InsertWord extends AsyncTask<Word,Void,Void> {

    private  FlashCardDatabase fcdb;
    public InsertWord(FlashCardDatabase db)
    {
        fcdb=db;
    }

    @Override
    protected Void doInBackground(Word... words) {
        Word word = words[0];
        fcdb.wordDao().insert(word);
        return null;
    }
}
