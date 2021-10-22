package com.example.evertec_app.views.card;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.evertec_app.R;

public class AddCard extends AppCompatActivity {

    EditText EditTextTargetNumber;
    EditText EditTextTargetExpiration;
    EditText EditTextTargetCvv;
    Button BtnCompleteRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        getSupportActionBar().setTitle("Agregar tarjeta");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BtnCompleteRegister = (Button) findViewById(R.id.btn_complete_register);
        EditTextTargetNumber = (EditText) findViewById(R.id.edit_text_number);
        EditTextTargetExpiration = (EditText) findViewById(R.id.edit_text_date_expiration);
        EditTextTargetCvv = (EditText) findViewById(R.id.edit_text_cvc);

        EditTextTargetExpiration.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if ( s.length() == 1 && !s.toString().contains("/")  ){
                    EditTextTargetExpiration.setText(s.toString()+"/");
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        BtnCompleteRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}