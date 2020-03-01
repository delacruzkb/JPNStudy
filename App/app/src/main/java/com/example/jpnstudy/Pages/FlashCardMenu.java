package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.jpnstudy.Entities.FlashCard;
import com.example.jpnstudy.R;

public class FlashCardMenu extends AppCompatActivity {
    boolean isHone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_menu);
        Intent intent = getIntent();
        isHone = intent.getBooleanExtra("isHone",false);
        TextView modeLabel= findViewById(R.id.flash_card_menu_mode_label);
        if(isHone)
        {
            modeLabel.setText("Hone!");
        }
        else
        {
            modeLabel.setText("Learn!");
        }

    }
    public void submit(View view){
        EditText amountEdit = findViewById(R.id.flash_card_menu_amount_edittext);
        Spinner propertiesSpinner = findViewById(R.id.flash_card_properties_spinner);

        int amount = Integer.parseInt(amountEdit.getText().toString());
        String properties = propertiesSpinner.getSelectedItem().toString();


        Intent intent = new Intent(this, FlashCardPage.class);

        intent.putExtra("properties",properties);
        intent.putExtra("amount",amount);
        intent.putExtra("mode",isHone);
        
        startActivity(intent);
    }
}
