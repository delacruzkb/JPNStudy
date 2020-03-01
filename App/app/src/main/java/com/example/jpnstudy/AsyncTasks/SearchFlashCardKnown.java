package com.example.jpnstudy.AsyncTasks;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.FlashCard;

import java.util.ArrayList;

public class SearchFlashCardKnown extends AsyncTask<Void,Void, ArrayList<FlashCard>> {
    private FlashCardDatabase fcdb;
    private boolean isKnown;
    private int cardLimit;

    public SearchFlashCardKnown(FlashCardDatabase db, boolean bool) {
        fcdb = db;
        isKnown = bool;
    }
    public SearchFlashCardKnown(FlashCardDatabase db, boolean bool, int limit) {
        fcdb = db;
        isKnown = bool;
        cardLimit = Math.abs(limit);
    }

    @Override
    protected ArrayList<FlashCard> doInBackground(Void... voids) {
        ArrayList<FlashCard> rtnval = null;
        if(cardLimit==0)
        {
            rtnval = (ArrayList<FlashCard>)fcdb.flashCardDao().searchKnown(isKnown);
        }
        else
        {
            rtnval = (ArrayList<FlashCard>)fcdb.flashCardDao().searchKnown(isKnown,cardLimit);
        }
        return rtnval;

    }
}