package com.example.jpnstudy.AsyncTasks.Search;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Grammar;

import java.util.ArrayList;

public class SearchGrammarStarred extends AsyncTask<Void,Void, ArrayList<Grammar>> {
    private FlashCardDatabase fcdb;
    private int isStarred;
    private int gramLimit;

    public SearchGrammarStarred(FlashCardDatabase db, int bool) {
        fcdb = db;
        isStarred = bool;
    }
    public SearchGrammarStarred(FlashCardDatabase db, int bool, int limit) {
        fcdb = db;
        isStarred = bool;
        gramLimit = Math.abs(limit);
    }

    @Override
    protected ArrayList<Grammar> doInBackground(Void... voids) {
        ArrayList<Grammar> rtnval = null;
        if(wordLimit==0)
        {
            rtnval = (ArrayList<Word>)fcdb.flashCardDao().searchStarredGrammarCards(isStarred);
        }
        else
        {
            rtnval = (ArrayList<Word>)fcdb.flashCardDao().searchStarredGrammarCards(isStarred,gramLimit);
        }
        return rtnval;

    }
}
