package com.example.jpnstudy.Dialogs;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.jpnstudy.Pages.LessonPage;
import com.example.jpnstudy.R;

public class LessonMenuDialog extends AppCompatDialogFragment {
    EditText cardAmountEditText;
    Spinner flashCardPairSpinner;
    View view;
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.activity_lesson_menu_dialog,null);
        cardAmountEditText = view.findViewById(R.id.challenge_dialog_card_amount_editText);
        flashCardPairSpinner = view.findViewById(R.id.challenge_dialog_flash_card_pair_spinner);
        builder.setView(view)
                .setTitle("Lesson Specifics")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("learn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int cardAmount = Integer.parseInt(cardAmountEditText.getText().toString());
                        String flashCardPair= flashCardPairSpinner.getSelectedItem().toString();
                        Intent intent = new Intent(view.getContext(), LessonPage.class);
                        intent.putExtra("flashCardPair",flashCardPair);
                        intent.putExtra("cardAmount",cardAmount);
                        startActivity(intent);
                    }
                });
        return builder.create();
    }

}
