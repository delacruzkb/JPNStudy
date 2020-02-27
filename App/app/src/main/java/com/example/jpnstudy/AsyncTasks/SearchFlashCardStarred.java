package com.example.jpnstudy.AsyncTasks;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.FlashCard;

import java.util.ArrayList;

public class SearchFlashCardStarred extends AsyncTask<Void,Void, ArrayList<FlashCard>> {
    private FlashCardDatabase fcdb;
    private int isStarred;
    private int cardLimit;

    public SearchFlashCardStarred(FlashCardDatabase db, int bool) {
        fcdb = db;
        isStarred = bool;
    }
    public SearchFlashCardStarred(FlashCardDatabase db, int bool, int limit) {
        fcdb = db;
        isStarred = bool;
        cardLimit = Math.abs(limit);
    }

    @Override
    protected ArrayList<FlashCard> doInBackground(Void... voids) {
        ArrayList<FlashCard> rtnval = null;
        if(cardLimit==0)
        {
        rtnval = (ArrayList<FlashCard>)fcdb.flashCardDao().searchStarred(isStarred);
        }
        else
        {
        rtnval = (ArrayList<FlashCard>)fcdb.flashCardDao().searchStarred(isStarred,cardLimit);
        }
        return rtnval;

    }
}