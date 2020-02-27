package com.example.jpnstudy.AsyncTasks;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.FlashCard;

import java.util.ArrayList;

public class SearchFlashCardType extends AsyncTask<String,Void, ArrayList<FlashCard>> {
    private FlashCardDatabase fcdb;
    public SearchFlashCardType(FlashCardDatabase db)
    {
        fcdb=db;
    }

    @Override
    protected ArrayList<FlashCard> doInBackground(String... strings) {
        return (ArrayList)fcdb.flashCardDao().searchType(strings[0]);
    }
}