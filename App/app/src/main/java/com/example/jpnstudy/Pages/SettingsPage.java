package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jpnstudy.Database.FlashCardDatabaseReader;
import com.example.jpnstudy.Entities.FlashCard;
import com.example.jpnstudy.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class SettingsPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
    }

    public void addNewTerm(View view)
    {
        //TODO: addNewTerm
        //dialog
    }

    public void editRemoveTerm(View view)
    {
        //TODO: editRemoveTerm
        //search page
        // dialog search?
    }

    public void defaultDatabase(View view)
    {
        //TODO: defaultDatabase
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.settings_default_database_warning)
                .setTitle(R.string.settings_default_database_title)
                .setPositiveButton(R.string.settings_default_database_confirm_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        loadDefaultDatabase();
                    }
                })
                .setNegativeButton(R.string.settings_default_database_cancel_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //do nothing
                    }
                });
    }

    public void clearDatabase(View view)
    {
        //TODO: clearDatabas
    }

    @SuppressLint("SetTextI18n")
    private void loadDefaultDatabase() {
        try {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

            ArrayList<FlashCard> defaultCards = new ArrayList<>();
            InputStreamReader is = new InputStreamReader(getAssets().open(getString(R.string.collin_dictionary)));
            BufferedReader reader = new BufferedReader(is);
            reader.readLine();
            String line;
            while ( (line = reader.readLine()) != null)
            {
                String[] properties = line.split(",");
                // hiragana, english, kanji, type

                FlashCard newCard = new FlashCard();
                newCard.setHiragana(properties[0]);
                newCard.setEnglish(properties[1]);
                newCard.setKanji(properties[2]);
                newCard.setType(properties[3]);

                defaultCards.add(newCard);
            }

            ProgressBar loadingBar = findViewById(R.id.settings_loading_progress_bar);
            loadingBar.setMax(defaultCards.size());

            FlashCardDatabaseReader dbr = new FlashCardDatabaseReader(this);
            dbr.loadDefaultDatabase(defaultCards, loadingBar);

            while (loadingBar.getProgress() != loadingBar.getMax())
            {
                TextView textView = findViewById(R.id.settings_loading_text_view);
                textView.setText(getString(R.string.settings_loading_text_database_reading) + " (" + loadingBar.getProgress() + "/" + loadingBar.getMax() + ")");
            }
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
        catch (Exception e)
        {
            //TODO: handle error
        }
    }
}
