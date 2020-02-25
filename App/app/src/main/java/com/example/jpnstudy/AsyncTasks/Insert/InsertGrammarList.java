package com.example.jpnstudy.AsyncTasks.Insert;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Grammar;

import java.util.ArrayList;

public class InsertGrammarList extends AsyncTask<ArrayList<Grammar>,Void,Void> {

    private FlashCardDatabase fcdb;
    public InsertGrammarList(FlashCardDatabase db) {
        fcdb=db;
    }

    @Override
    protected Void doInBackground(ArrayList<Grammar>... grammar) {
        ArrayList<Grammar> gram= grammar[0];
        for(int i =0; i<gram.size();i++)
        {
            fcdb.grammarDao().insert(gram.get(i));
        }

        return null;
    }
}