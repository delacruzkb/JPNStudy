package com.example.jpnstudy.AsyncTasks.Insert;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Grammar;

public class InsertGrammar extends AsyncTask<Grammar,Void,Void> {

    private FlashCardDatabase fcdb;
    public InsertGrammar(FlashCardDatabase db)
    {
        fcdb=db;
    }

    @Override
    protected Void doInBackground(Grammar... grammars){
        Grammar gram = grammars[0];
        fcdb.grammarDao().insert(gram);
        return null;
    }
}
