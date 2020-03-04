package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.jpnstudy.R;

public class FlashCardMenu extends AppCompatActivity {
    boolean isHone;
    String cardFront;
    String cardBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_menu);
        Intent intent = getIntent();
        isHone = intent.getBooleanExtra("isHone",false);
        if (isHone)
        {
            setTitle(getString(R.string.flash_card_hone_title));
        }
        else{
            setTitle(R.string.flash_card_learn_title);
        }

    }
    public void submit(View view){
        EditText amountEdit = findViewById(R.id.flash_card_menu_amount_edittext);


        String amountText =amountEdit.getText().toString();
        if(  amountText.length()<1 || Integer.parseInt(amountText)==0)
        {
            Toast.makeText(this,getText(R.string.wrong_amount_error), Toast.LENGTH_SHORT).show();
        }
        else if( cardBack.equalsIgnoreCase(cardFront))
        {
            Toast.makeText(this,getText(R.string.same_card_error), Toast.LENGTH_SHORT).show();
        }
        else{
            int amount = Integer.parseInt(amountEdit.getText().toString());
            Intent intent = new Intent(this, FlashCardPage.class);
            intent.putExtra("cardFront",cardFront);
            intent.putExtra("cardBack",cardBack);
            intent.putExtra("amount",amount);
            intent.putExtra("mode",isHone);

            startActivity(intent);
        }
    }

    public void onCardFrontRadioButtonClick(View view){
        RadioButton radioButton = (RadioButton) view;
        boolean checked = radioButton.isChecked();
        if(checked)
        {
            cardFront= radioButton.getText().toString();
        }
    }

    public void onCardBackRadioButtonClick(View view){
        RadioButton radioButton = (RadioButton) view;
        boolean checked = radioButton.isChecked();
        if(checked)
        {
            cardBack= radioButton.getText().toString();
        }
    }
}
