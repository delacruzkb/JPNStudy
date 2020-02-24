package com.example.jpnstudy.AsyncTasks;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Word;

import java.util.ArrayList;

public class SearchWordStarred extends AsyncTask<Void,Void, ArrayList<Word>> {
    private FlashCardDatabase fcdb;
    private int isStarred;
    private int wordLimit;

    public SearchWordStarred(FlashCardDatabase db, int bool) {
        fcdb = db;
        isStarred = bool;
    }
    public SearchWordStarred(FlashCardDatabase db, int bool, int limit) {
        fcdb = db;
        isStarred = bool;
        wordLimit = Math.abs(limit);
    }

    @Override
    protected ArrayList<Word> doInBackground(Void... voids) {
        ArrayList<Word> rtnval = null;
        if(wordLimit==0)
        {
        rtnval = (ArrayList<Word>)fcdb.flashCardDao().searchStarredWordCards(isStarred);
        }
        else
        {
        rtnval = (ArrayList<Word>)fcdb.flashCardDao().searchStarredWordCards(isStarred,wordLimit);
        }
        return rtnval;

    }
}