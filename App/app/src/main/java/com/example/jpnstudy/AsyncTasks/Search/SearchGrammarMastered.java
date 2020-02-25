package com.example.jpnstudy.AsyncTasks.Search;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Grammar;

import java.util.ArrayList;

public class SearchGrammarMastered extends AsyncTask<Void,Void, ArrayList<Grammar>> {
    private FlashCardDatabase fcdb;
    private int isMastered;
    private int gramLimit;

    public SearcGrammarMastered(FlashCardDatabase db, int bool) {
        fcdb = db;
        isMastered = bool;
    }
    public SearchGrammarMastered(FlashCardDatabase db, int bool, int limit) {
        fcdb = db;
        isMastered = bool;
        gramLimit = Math.abs(limit);
    }

    @Override
    protected ArrayList<Grammar> doInBackground(Void... voids) {
        ArrayList<Grammar> rtnval = null;
        if(wordLimit==0)
        {
            rtnval = (ArrayList<Word>)fcdb.flashCardDao().searchMasteredGrammarCards(isMastered);
        }
        else
        {
            rtnval = (ArrayList<Word>)fcdb.flashCardDao().searchMasteredGrammarCards(isMastered,gramLimit);
        }
        return rtnval;

    }
}
