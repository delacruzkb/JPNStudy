package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.jpnstudy.Entities.FlashCard;
import com.example.jpnstudy.R;

public class FlashCardMenu extends AppCompatActivity {
    int known;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_menu);
        Intent intent = getIntent();
        known = intent.getIntExtra("mode",0);
    }
    public void submit(View view){
        EditText amountEdit = findViewById(R.id.flash_card_menu_amount_edittext);
        Spinner propertiesSpinner = findViewById(R.id.flash_card_properties_spinner);

        int amount = Integer.parseInt(amountEdit.getText().toString());
        String properties = propertiesSpinner.getSelectedItem().toString();


        Intent intent = new Intent(this, FlashCard.class);

        intent.putExtra("properties",properties);
        intent.putExtra("amount",amount);
        intent.putExtra("mode",known);
        
        startActivity(intent);
    }
}
