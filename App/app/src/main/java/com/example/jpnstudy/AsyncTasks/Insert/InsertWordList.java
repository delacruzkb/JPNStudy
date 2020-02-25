package com.example.jpnstudy.AsyncTasks.Insert;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Word;

import java.util.ArrayList;

public class InsertWordList extends AsyncTask<ArrayList<Word>,Void,Void> {

    private FlashCardDatabase fcdb;
    public InsertWordList(FlashCardDatabase db)
    {
        fcdb=db;
    }

    @Override
    protected Void doInBackground(ArrayList<Word>... words) {
        ArrayList<Word> wordList = words[0];
        for(int i =0; i<wordList.size();i++){
            fcdb.wordDao().insert(wordList.get(i));
        }
        return null;
    }
}
