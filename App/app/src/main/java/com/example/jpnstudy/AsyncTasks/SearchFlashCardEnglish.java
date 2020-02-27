package com.example.jpnstudy.AsyncTasks;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.FlashCard;

import java.util.ArrayList;

public class SearchFlashCardEnglish extends AsyncTask<Void,Void, ArrayList<FlashCard>> {
    private FlashCardDatabase fcdb;
    private String searchKey;
    public SearchFlashCardEnglish(FlashCardDatabase db, String search)
    {
        fcdb=db;
        searchKey = search;
    }

    @Override
    protected ArrayList<FlashCard> doInBackground(Void... voids) {
        return (ArrayList)fcdb.flashCardDao().searchEnglish(searchKey);
    }
}