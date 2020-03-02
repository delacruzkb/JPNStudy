package com.example.jpnstudy.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jpnstudy.R;

public class FlashCardMenu extends AppCompatActivity {
    boolean isHone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_menu);
        Intent intent = getIntent();
        isHone = intent.getBooleanExtra("isHone",false);
        if (isHone)
        {
            setTitle("Hone your skills");
        }
        else{
            setTitle("Learn a card");
        }

    }
    public void submit(View view){
        EditText amountEdit = findViewById(R.id.flash_card_menu_amount_edittext);
        Spinner propertiesSpinner = findViewById(R.id.flash_card_properties_spinner);

        String amountText =amountEdit.getText().toString();
        if(  amountText.length()<1)
        {
            Toast.makeText(this,"Invalid Amount", Toast.LENGTH_SHORT).show();
        }
        else{
            int amount = Integer.parseInt(amountEdit.getText().toString());
            String properties = propertiesSpinner.getSelectedItem().toString();


            Intent intent = new Intent(this, FlashCardPage.class);

            intent.putExtra("properties",properties);
            intent.putExtra("amount",amount);
            intent.putExtra("mode",isHone);

            startActivity(intent);
        }

    }
}
