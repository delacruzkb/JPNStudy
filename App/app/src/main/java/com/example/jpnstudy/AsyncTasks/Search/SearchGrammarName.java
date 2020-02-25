package com.example.jpnstudy.AsyncTasks.Search;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Grammar;

public class SearchGrammarName extends AsyncTask<Void,Void, ArrayList<Grammar>> {
    private FlashCardDatabase fcdb;
    private String searchKey;
    public SearchGrammarName(FlashCardDatabase db, String search)
    {
        fcdb=db;
        searchKey = search;
    }

    @Override
    protected ArrayList<Grammar> doInBackground(Void... voids) {
        return (ArrayList)fcdb.grammarDao().searchGrammarName(searchKey);
    }
}
