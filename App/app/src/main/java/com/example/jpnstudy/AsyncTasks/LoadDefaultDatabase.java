package com.example.jpnstudy.AsyncTasks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;

import com.example.jpnstudy.Database.FlashCardDatabase;
import com.example.jpnstudy.Entities.FlashCard;
import java.util.ArrayList;

public class LoadDefaultDatabase extends AsyncTask<ArrayList<FlashCard>,Void,Void> {
    private FlashCardDatabase fcdb;
    @SuppressLint("StaticFieldLeak")
    private Context context;
    @SuppressLint("StaticFieldLeak")
    private ProgressBar loadingBar;
    public LoadDefaultDatabase(FlashCardDatabase db, Context context, ProgressBar progressBar) {
        fcdb=db;
        this.context = context;
        loadingBar = progressBar;
    }

    @Override
    protected Void doInBackground(ArrayList<FlashCard>... cards) {
        ArrayList<FlashCard> defaultCards = cards[0];
        for(int i =0; i<defaultCards.size(); i++)
        {
            fcdb.flashCardDao().insert(defaultCards.get(i));
            loadingBar.incrementProgressBy(1);
        }
        return null;
    }
}
