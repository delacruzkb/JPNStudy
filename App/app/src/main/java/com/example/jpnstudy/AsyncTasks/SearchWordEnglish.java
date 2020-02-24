package com.example.jpnstudy.AsyncTasks;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.Word;

import java.util.ArrayList;

public class SearchWordEnglish extends AsyncTask<Void,Void, ArrayList<Word>> {
    private FlashCardDatabase fcdb;
    private String searchKey;
    public SearchWordEnglish(FlashCardDatabase db, String search)
    {
        fcdb=db;
        searchKey = search;
    }

    @Override
    protected ArrayList<Word> doInBackground(Void... voids) {
        return (ArrayList)fcdb.wordDao().searchEnglish(searchKey);
    }
}
