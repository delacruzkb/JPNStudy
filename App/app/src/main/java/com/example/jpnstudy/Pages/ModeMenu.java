package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jpnstudy.R;

public class ModeMenu extends AppCompatActivity {
    String mode;
    String cardFront;
    String cardBack;
    Spinner ordealSpinner;
    TextView ordealDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_menu);
        Intent intent = getIntent();
        mode = intent.getStringExtra(getString(R.string.mode_key));

        if(!mode.equals(getString(R.string.ordeal_label)))
        {
            hideOrdealViews();
        }
        else
        {
            ordealModeSetup();
        }
    }

    public void submit(View view){
        EditText amountEdit = findViewById(R.id.flash_card_menu_amount_edittext);
        RadioGroup frontRadioGroup = findViewById(R.id.flash_card_menu_card_front_radio_group);
        RadioGroup backRadioGroup= findViewById(R.id.flash_card_menu_card_back_radio_group);

        String amountText =amountEdit.getText().toString();
        if(  amountText.length()<1 || Integer.parseInt(amountText)==0)
        {
            Toast.makeText(this,getText(R.string.wrong_amount_error), Toast.LENGTH_SHORT).show();
        }
        else if(frontRadioGroup.getCheckedRadioButtonId() == -1 ||
                backRadioGroup.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this,getText(R.string.null_card_side_error), Toast.LENGTH_SHORT).show();
        }
        else if( cardBack.equalsIgnoreCase(cardFront))
        {
            Toast.makeText(this,getText(R.string.same_card_error), Toast.LENGTH_SHORT).show();
        }
        else{
            int amount = Integer.parseInt(amountEdit.getText().toString());
            Intent intent = new Intent(this, ModePage.class);
            if(mode.equals(getString(R.string.ordeal_label))){
               mode= ordealSpinner.getSelectedItem().toString();
            }
            intent.putExtra(getString(R.string.card_front_key),cardFront);
            intent.putExtra(getString(R.string.card_back_key),cardBack);
            intent.putExtra(getString(R.string.amount_key), amount);
            intent.putExtra(getString(R.string.mode_key),mode);
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

    private void hideOrdealViews(){
        LinearLayout ordealLayout = findViewById(R.id.flash_card_menu_ordeal_layout);
        ordealLayout.setVisibility(View.GONE);
    }

    private void ordealModeSetup() {
        TextView question = findViewById(R.id.mode_menu_card_front_text_view);
        TextView answer = findViewById(R.id.mode_menu_card_back_text_view);
        question.setText(getString(R.string.question_label));
        answer.setText(getString(R.string.answer_label));

        ordealDescription = findViewById(R.id.flash_card_menu_ordeal_description_text_view);
        ordealDescription.setText(getString(R.string.mode_menu_ordeal_multiple_choice_description));
        ordealSpinner= findViewById(R.id.flash_card_menu_ordeal_spinner);
        ordealSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position)
                {
                    case 0:
                        ordealDescription.setText(getString(R.string.mode_menu_ordeal_multiple_choice_description));
                        break;
                    case 1:
                        ordealDescription.setText(getString(R.string.mode_menu_ordeal_character_choice_description));
                        break;
                    case 2:
                        ordealDescription.setText(getString(R.string.mode_menu_ordeal_key_in_description));
                        break;
                    case 3:
                        ordealDescription.setText(getString(R.string.mode_menu_ordeal_mixed_description));
                        break;
                    case 4:
                        ordealDescription.setText(getString(R.string.mode_menu_ordeal_weighted_description));
                        break;
                    default:
                        ordealDescription.setText(getString(R.string.mode_menu_ordeal_multiple_choice_description));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }
}

