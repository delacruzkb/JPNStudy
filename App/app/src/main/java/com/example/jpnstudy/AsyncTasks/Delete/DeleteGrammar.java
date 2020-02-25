package com.example.jpnstudy.AsyncTasks.Delete;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Grammar;

public class DeleteGrammar extends AsyncTask<Grammar,Void,Void> {

        private FlashCardDatabase fcdb;
        public DeleteGrammar(FlashCardDatabase db) {
            fcdb=db;
        }

        @Override
        protected Void doInBackground(Grammar... grammar) {
            Grammar gram= grammar[0];
            fcdb.grammarDao().delete(gram);
            return null;
        }
}