package com.example.evertec_app.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.evertec_app.R;
import com.example.evertec_app.models.User;
import com.example.evertec_app.views.card.CardList;
import com.example.evertec_app.views.payment.AddPayment;
import com.example.evertec_app.views.payment.PaymentLIst;

public class Home extends AppCompatActivity {

    Button btnTransactions;
    Button btnTarget;
    Button btnPays;
    Button btnLogout;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Bienvenido usuario");

        btnTransactions = (Button) findViewById(R.id.btn_transactions);
        btnTarget = (Button) findViewById(R.id.btn_targets);
        btnPays = (Button) findViewById(R.id.btn_pays);
        btnLogout = (Button) findViewById(R.id.btn_logout);

        btnTransactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(v.getContext(), AddPayment.class);
                startActivity(intent);

            }
        });
        btnTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(v.getContext(), CardList.class);
                startActivity(intent);

            }
        });
        btnPays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(v.getContext(), PaymentLIst.class);
                startActivity(intent);

            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new User().dropSesion();
                finish();
            }
        });









    }


    @Override
    public void onBackPressed () {

    }
    @Override
    public boolean onKeyDown(int key_code, KeyEvent key_event) {
        if (key_code== KeyEvent.KEYCODE_BACK) {
            super.onKeyDown(key_code, key_event);
            return true;
        }
        return false;
    }
}