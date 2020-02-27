package com.example.jpnstudy.AsyncTasks;

import android.os.AsyncTask;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.FlashCard;

import java.util.ArrayList;

public class SearchFlashCardMastered extends AsyncTask<Void,Void, ArrayList<FlashCard>> {
    private FlashCardDatabase fcdb;
    private int isMastered;
    private int cardLimit;

    public SearchFlashCardMastered(FlashCardDatabase db, int bool) {
        fcdb = db;
        isMastered = bool;
    }
    public SearchFlashCardMastered(FlashCardDatabase db, int bool, int limit) {
        fcdb = db;
        isMastered = bool;
        cardLimit = Math.abs(limit);
    }

    @Override
    protected ArrayList<FlashCard> doInBackground(Void... voids) {
        ArrayList<FlashCard> rtnval = null;
        if(cardLimit==0)
        {
        rtnval = (ArrayList<FlashCard>)fcdb.flashCardDao().searchMastered(isMastered);
        }
        else
        {
        rtnval = (ArrayList<FlashCard>)fcdb.flashCardDao().searchMastered(isMastered,cardLimit);
        }
        return rtnval;

    }
}