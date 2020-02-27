package com.example.jpnstudy.AsyncTasks;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.FlashCard;
import com.example.jpnstudy.Entities.Grammar;

import java.util.ArrayList;

public class InsertFlashCardList extends AsyncTask<ArrayList<FlashCard>,Void,Void> {

    private FlashCardDatabase fcdb;
    public InsertFlashCardList(FlashCardDatabase db) {
        fcdb=db;
    }

    @Override
    protected Void doInBackground(ArrayList<FlashCard>... flashCard) {
        ArrayList<FlashCard> cards= flashCard[0];
        for(int i =0; i<cards.size();i++)
        {
            fcdb.flashCardDao().insert(cards.get(i));
        }

        return null;
    }
}