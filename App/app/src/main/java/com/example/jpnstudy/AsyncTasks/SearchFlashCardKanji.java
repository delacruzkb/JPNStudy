package com.example.jpnstudy.AsyncTasks;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.FlashCard;

import java.util.ArrayList;

public class SearchFlashCardKanji extends AsyncTask<String,Void, ArrayList<FlashCard>> {
    private FlashCardDatabase fcdb;
    public SearchFlashCardKanji(FlashCardDatabase db)
    {
        fcdb=db;
    }

    @Override
    protected ArrayList<FlashCard> doInBackground(String... strings) {
        return (ArrayList)fcdb.flashCardDao().searchKanji(strings[0]);
    }
}