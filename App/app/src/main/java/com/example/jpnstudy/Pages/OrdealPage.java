package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jpnstudy.Entities.FlashCard;
import com.example.jpnstudy.R;

import java.util.ArrayList;

public class OrdealPage extends AppCompatActivity {
    ArrayList<FlashCard> ordeals;
    FlashCard currentOrdeal;
    String ordealPromptType;
    String ordealAnswerType;
    String mode;
    String userAnswer;
    String correctAnswer;
    int amount;
    int cardCount;
    int currentCardIndex;
    int score;


    MenuItem starIcon;
    MenuItem masterIcon;

    LinearLayout multiSelectLayout;
    LinearLayout charSelectLayout;
    EditText answerFieldEditText;
    TextView promptTextView;
    Button helperButton;
    Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordeal_page);

        initialSetup();

        loadOrdeal(0);
    }
    //TODO: star and master for ordeal?
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_bar_menu,menu);
        starIcon=menu.getItem(0);
        masterIcon=menu.getItem(1);
        if(currentOrdeal.isStarred())
        {
            starIcon.setIcon(R.drawable.ic_starred);
        }
        if(currentOrdeal.isMastered())
        {
            masterIcon.setIcon(R.drawable.ic_mastered);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_master:
                toggleMaster(item);
                return true;
            case R.id.action_star:
                toggleStar(item);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void initialSetup() {
        Intent intent = getIntent();
        ordealPromptType = intent.getStringExtra(getString(R.string.card_front_key));
        ordealAnswerType = intent.getStringExtra(getString(R.string.card_back_key));
        mode = intent.getStringExtra(getString(R.string.mode_key));
        amount = intent.getIntExtra(getString(R.string.amount_key),1);
        ordeals = (ArrayList<FlashCard>) intent.getSerializableExtra(getString(R.string.card_key));

        charSelectLayout = findViewById(R.id.ordeal_char_include);
        multiSelectLayout  = findViewById(R.id.ordeal_multi_include);
        answerFieldEditText =findViewById(R.id.ordeal_answer_field_edit_text);
        helperButton = findViewById(R.id.ordeal_helper_button);
        confirmButton = findViewById(R.id.ordeal_confirm_button);
        promptTextView = findViewById(R.id.prompt_text_view);
    }

    private void loadOrdeal(int index) {
        //set up Layout
        if(mode.equals(getString(R.string.mode_menu_ordeal_multiple_choice_description))){
            multiSelectLayoutSetup();
        }
        else if(mode.equals(getString(R.string.mode_menu_ordeal_character_choice_description))){
            charSelectLayoutSetup();
        }
        else if(mode.equals(getString(R.string.mode_menu_ordeal_weighted_description))){
            weightedLayoutSetup();
        }
        else if(mode.equals(getString(R.string.mode_menu_ordeal_mixed_description))){
            mixedLayoutSetup();
        }
        else {
            keyInLayoutSetup();
        }

        //loads proper information
        currentOrdeal = ordeals.get(index);
        currentCardIndex = index;
        setTitle("Ordeal #" + currentCardIndex);

        if(ordealPromptType.equals(getString(R.string.english_label))) {
            promptTextView.setText(currentOrdeal.getEnglish());
        }
        else if(ordealPromptType.equals(getString(R.string.hiragana_label))) {
            promptTextView.setText(currentOrdeal.getHiragana());
        }
        else if(ordealPromptType.equals(getString(R.string.kanji_label))) {
            promptTextView.setText(currentOrdeal.getKanji());
        }

        if(ordealAnswerType.equals(getString(R.string.english_label))) {
            answerFieldEditText.setHint(R.string.english_label);
            correctAnswer = currentOrdeal.getEnglish();
        }
        else if(ordealAnswerType.equals(getString(R.string.hiragana_label))) {
            answerFieldEditText.setHint(R.string.hiragana_label);
            correctAnswer = currentOrdeal.getHiragana();
        }
        else if(ordealAnswerType.equals(getString(R.string.kanji_label))) {
            answerFieldEditText.setHint(R.string.kanji_label);
            correctAnswer = currentOrdeal.getKanji();
        }

    }

    public void confirmButtonPressed(View view){
        //check if right
        //if right: show master button and increase score and right counter
        //proceed until done
    }

    public void multipleChoiceButtonPressed(View view){
        Button input = (Button) view;
        input.requestFocus();
        userAnswer= input.getText().toString();
        if(confirmButton.getVisibility() == View.INVISIBLE)
        {
            confirmButton.setVisibility(View.VISIBLE);
        }
    }

    public void characterChoiceButtonPressed(View view){
        Button input = (Button) view;
        userAnswer = answerFieldEditText.getText().toString() + input.getText().toString();
        answerFieldEditText.setText(userAnswer);
        if(confirmButton.getVisibility() == View.INVISIBLE)
        {
            confirmButton.setVisibility(View.VISIBLE);
        }
    }

    private void weightedLayoutSetup() {
        int rc = currentOrdeal.getRightCounter();
        if(rc<3)
        {
            multiSelectLayoutSetup();
        }
        else if(rc<6)
        {
            charSelectLayoutSetup();
        }
        else
        {
            keyInLayoutSetup();
        }
    }

    private void mixedLayoutSetup(){
        int layoutPicker = (int)(Math.random()+2);

        switch (layoutPicker){
            case 0:
                multiSelectLayoutSetup();
                break;
            case 1:
                charSelectLayoutSetup();
                break;
            case 2:
                keyInLayoutSetup();
                break;
        }
    }

    private void keyInLayoutSetup() {
       charSelectLayout.setVisibility(View.GONE);
       multiSelectLayout.setVisibility(View.GONE);
       answerFieldEditText.setVisibility(View.VISIBLE);
       confirmButton.setVisibility(View.VISIBLE);
       confirmButton.setText(R.string.clear_button);
       confirmButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               answerFieldEditText.setText("");
           }
       });
   }

    private void charSelectLayoutSetup() {
       charSelectLayout.setVisibility(View.VISIBLE);
       multiSelectLayout.setVisibility(View.GONE);
       answerFieldEditText.setVisibility(View.GONE);
        confirmButton.setVisibility(View.INVISIBLE);
        confirmButton.setText(R.string.clear_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentAnswer = answerFieldEditText.getText().toString();
                if( currentAnswer.length() >0){
                    answerFieldEditText.setText(currentAnswer.substring(0, currentAnswer.length()-1));
                }
            }
        });
   }

    private void multiSelectLayoutSetup() {
       charSelectLayout.setVisibility(View.GONE);
       multiSelectLayout.setVisibility(View.INVISIBLE);
       answerFieldEditText.setVisibility(View.GONE);
       confirmButton.setVisibility(View.GONE);
   }

    private void toggleStar(MenuItem item) {
        currentOrdeal.setStarred(!currentOrdeal.isStarred());
        //TODO: UPDATE DAO star
        if(currentOrdeal.isStarred())
        {
            item.setIcon(R.drawable.ic_starred);
        }
        else
        {
            item.setIcon(R.drawable.ic_un_starred);
        }
    }

    private void toggleMaster(MenuItem item) {
        currentOrdeal.setMastered(!currentOrdeal.isMastered());
        //TODO: UPDATE DAO star
        if(currentOrdeal.isMastered())
        {
            item.setIcon(R.drawable.ic_mastered);
        }
        else
        {
            item.setIcon(R.drawable.ic_un_mastered);
        }
    }

    //TODO: update command for done/again/quit
    @Override
    public void onBackPressed() {
        final Context context = this;
        Intent intent = new Intent(context, ModeMenu.class);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.done_dialog_title)
                .setPositiveButton(R.string.again_dialog_button, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(context, ModeMenu.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.putExtra(getString(R.string.mode_key),getString(R.string.ordeal_label));
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.return_home_dialog_button, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(context, HomePage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                });
        builder.create();
        builder.show();
    }
}
