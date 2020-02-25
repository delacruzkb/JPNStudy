package com.example.jpnstudy.AsyncTasks.Search;


import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Grammar;


public class SearchGrammarDefinition extends AsyncTask<Void,Void, ArrayList<Grammar>> {
    private FlashCardDatabase fcdb;
    private String searchKey;
    public SearchGrammarDefinition(FlashCardDatabase db, String search)
    {
        fcdb=db;
        searchKey = search;
    }

    @Override
    protected ArrayList<Grammar> doInBackground(Void... voids) {
        return (ArrayList)fcdb.grammarDao().searchGrammarDefinition(searchKey);
    }
}
