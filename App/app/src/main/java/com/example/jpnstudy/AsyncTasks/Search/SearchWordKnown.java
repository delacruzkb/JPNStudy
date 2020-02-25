package com.example.jpnstudy.AsyncTasks.Search;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Word;

import java.util.ArrayList;

public class SearchWordKnown extends AsyncTask<Void,Void, ArrayList<Word>> {
    private FlashCardDatabase fcdb;
    private int isKnown;
    private int wordLimit;

    public SearchWordKnown(FlashCardDatabase db, int bool) {
        fcdb = db;
        isKnown = bool;
    }
    public SearchWordKnown(FlashCardDatabase db, int bool, int limit) {
        fcdb = db;
        isKnown = bool;
        wordLimit = Math.abs(limit);
    }

    @Override
    protected ArrayList<Word> doInBackground(Void... voids) {
        ArrayList<Word> rtnval = null;
        if(wordLimit==0)
        {
            rtnval = (ArrayList<Word>)fcdb.flashCardDao().searchKnownWordCards(isKnown);
        }
        else
        {
            rtnval = (ArrayList<Word>)fcdb.flashCardDao().searchKnownWordCards(isKnown,wordLimit);
        }
        return rtnval;

    }
}