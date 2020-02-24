package com.example.jpnstudy.AsyncTasks;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Word;

import java.util.ArrayList;

public class SearchWordMastered extends AsyncTask<Void,Void, ArrayList<Word>> {
    private FlashCardDatabase fcdb;
    private int isMastered;
    private int wordLimit;

    public SearchWordMastered(FlashCardDatabase db, int bool) {
        fcdb = db;
        isMastered = bool;
    }
    public SearchWordMastered(FlashCardDatabase db, int bool, int limit) {
        fcdb = db;
        isMastered = bool;
        wordLimit = Math.abs(limit);
    }

    @Override
    protected ArrayList<Word> doInBackground(Void... voids) {
        ArrayList<Word> rtnval = null;
        if(wordLimit==0)
        {
        rtnval = (ArrayList<Word>)fcdb.flashCardDao().searchMasteredWordCards(isMastered);
        }
        else
        {
        rtnval = (ArrayList<Word>)fcdb.flashCardDao().searchMasteredWordCards(isMastered,wordLimit);
        }
        return rtnval;

    }
}