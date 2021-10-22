package com.example.evertec_app.views.card;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.evertec_app.R;

public class CardList extends AppCompatActivity {

    Button btnAddTarget;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        btnAddTarget = (Button) findViewById(R.id.btn_nueva_tarjeta);

        btnAddTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(v.getContext(),AddCard.class);
                startActivity(intent);

            }
        });

    }
}