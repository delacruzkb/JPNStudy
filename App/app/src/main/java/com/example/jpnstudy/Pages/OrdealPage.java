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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.jpnstudy.Entities.FlashCard;
import com.example.jpnstudy.R;

import java.util.ArrayList;
import java.util.Collections;

public class OrdealPage extends AppCompatActivity {
    ArrayList<FlashCard> ordeals;
    FlashCard currentOrdeal;
    String ordealPromptType;
    String ordealAnswerType;
    String mode;
    String userAnswer;
    String correctAnswer;
    int amount;
    int currentCardIndex;
    int score;


    MenuItem starIcon;
    MenuItem masterIcon;

    LinearLayout multiSelectLayout;
    LinearLayout charSelectLayout;
    EditText answerFieldEditText;
    TextView promptTextView;
    TextView scoreTextView;
    Button helperButton;
    Button confirmButton;
    Button continueButton;

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
        continueButton = findViewById(R.id.ordeal_continue_button);

        promptTextView = findViewById(R.id.prompt_text_view);
        scoreTextView = findViewById(R.id.ordeal_score_label);
        setScore(0);
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
        if(masterIcon != null)
        {
            masterIcon.setVisible(false);
        }


        //loads proper information
        userAnswer="";
        currentOrdeal = ordeals.get(index);
        currentCardIndex = index;
        setTitle("Ordeal #" + (currentCardIndex + 1 ));

        promptTextView.setText(getStringFromType(currentOrdeal, ordealPromptType));

        correctAnswer = getStringFromType(currentOrdeal, ordealAnswerType);
        answerFieldEditText.setHint(ordealAnswerType);
    }

    public void confirmButtonPressed(View view){
        String alertMessage = getString(R.string.wrong_answer_message) + correctAnswer;
        String alertTitle = getString(R.string.wrong_answer_title);
        if(answerFieldEditText.getVisibility() == View.VISIBLE)
        {
            userAnswer = answerFieldEditText.getText().toString().trim();
        }
        if(userAnswer.equalsIgnoreCase(correctAnswer))
        {
            score = score + 1;
            setScore(score);
            alertMessage = getString(R.string.correct_answer_message);
            alertTitle = getString(R.string.correct_answer_title);
            masterIcon.setVisible(true);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage(alertMessage);
        builder.setTitle(alertTitle);
        builder.setPositiveButton(R.string.ordeal_dialog_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //do nothing
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        confirmButton.setVisibility(View.GONE);
        continueButton.setVisibility(View.VISIBLE);
    }

    public void continueButtonPressed(View view){
        if(currentCardIndex < amount-1) {
            confirmButton.setVisibility(View.VISIBLE);
            currentCardIndex = currentCardIndex + 1;
            loadOrdeal(currentCardIndex);
            RadioGroup radioGroup = findViewById(R.id.ordeal_multiple_choice_radio_group);
            radioGroup.clearCheck();
            answerFieldEditText.setText("");
        }
        else{
            onBackPressed();
        }
    }

    public void multipleChoiceButtonPressed(View view){
        if(continueButton.getVisibility() != View.VISIBLE)
        {
            RadioButton input = (RadioButton) view;
            userAnswer= input.getText().toString();
            confirmButton.setVisibility(View.VISIBLE);
        }

    }

    public void characterChoiceButtonPressed(View view){
        Button input = (Button) view;
        userAnswer = answerFieldEditText.getText().toString() + input.getText().toString();
        answerFieldEditText.setText(userAnswer);
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
        int layoutPicker = (int)(Math.random()*3);

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
       answerFieldEditText.setFocusable(true);
       helperButton.setVisibility(View.GONE);
       continueButton.setVisibility(View.GONE);
   }

    private void charSelectLayoutSetup() {
       multiSelectLayout.setVisibility(View.GONE);
       helperButton.setVisibility(View.VISIBLE);
       charSelectLayout.setVisibility(View.VISIBLE);
       answerFieldEditText.setVisibility(View.VISIBLE);
       answerFieldEditText.setFocusable(false);
       continueButton.setVisibility(View.GONE);
   }

    private void multiSelectLayoutSetup() {
        // Hide other ordeal views
       charSelectLayout.setVisibility(View.GONE);
       helperButton.setVisibility(View.GONE);
       answerFieldEditText.setVisibility(View.GONE);

       //show proper view
       multiSelectLayout.setVisibility(View.VISIBLE);
       continueButton.setVisibility(View.GONE);

       //populate 4 choices
       ArrayList<FlashCard> ordealsCopy =(ArrayList<FlashCard>) ordeals.clone();
       FlashCard answerOrdeal = ordealsCopy.remove(currentCardIndex);
       Collections.shuffle(ordealsCopy);
       ArrayList<FlashCard> choices = new ArrayList<>();
       choices.add(answerOrdeal);
       for(int i =0; i< 3; i++)
       {
           choices.add(ordealsCopy.remove(0));
       }
       Collections.shuffle(choices);

       RadioButton choice1= findViewById(R.id.ordeal_multiple_choice_radio_button_1);
       choice1.setText(getStringFromType(choices.remove(0),ordealAnswerType));

       RadioButton choice2= findViewById(R.id.ordeal_multiple_choice_radio_button_2);
       choice2.setText(getStringFromType(choices.remove(0),ordealAnswerType));

       RadioButton choice3= findViewById(R.id.ordeal_multiple_choice_radio_button_3);
       choice3.setText(getStringFromType(choices.remove(0),ordealAnswerType));

       RadioButton choice4= findViewById(R.id.ordeal_multiple_choice_radio_button_4);
       choice4.setText(getStringFromType(choices.remove(0),ordealAnswerType));
   }

    private String getStringFromType(FlashCard card, String type) {
        String rtnval="";
        if(type.equals(getString(R.string.english_label))) {
            rtnval = card.getEnglish();
        }
        else if(type.equals(getString(R.string.hiragana_label))) {
            rtnval = card.getHiragana();
        }
        else if(type.equals(getString(R.string.kanji_label))) {
            rtnval = card.getKanji();
        }

        return rtnval;
    }

    private void setScore(int score) {
        scoreTextView.setText(score +  " " + getString(R.string.score_text));
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
