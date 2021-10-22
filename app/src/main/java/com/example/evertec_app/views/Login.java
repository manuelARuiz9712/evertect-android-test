package com.example.evertec_app.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evertec_app.R;
import com.example.evertec_app.local_db.DbMainHelper;
import com.example.evertec_app.models.User;
import com.google.gson.Gson;

public class Login extends AppCompatActivity {

    DbMainHelper localDbHelper;
    TextView registerText ;
    EditText editEmail;
    EditText editPassword;
    Button btnLogin;
    User user;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        user = new User(getApplicationContext()).getSesion();

        if ( user.getUserId() != null ){
            intent = new Intent(this.getApplicationContext(),Home.class);
            startActivity(intent);
        }

        localDbHelper = new DbMainHelper(getApplicationContext());
        registerText = (TextView) findViewById(R.id.text_register);
        editEmail = (EditText) findViewById(R.id.edit_text_email);
        editPassword = (EditText) findViewById(R.id.edit_text_clave);
        btnLogin = (Button) findViewById(R.id.btn_iniciar_sesion);


        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(),Register.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Home.class);
                User user = new User(v.getContext());
                user.setUserEmail(editEmail.getText().toString());
                user.setUserPassword(editPassword.getText().toString());

                if ( !user.ValidateLogin()){
                    Toast.makeText(v.getContext(),"Los campos son obligatorios",Toast.LENGTH_LONG).show();
                    return;
                }
                if ( !user.existUser() ){
                    Toast.makeText(v.getContext(),"Credenciales incorrectas",Toast.LENGTH_LONG).show();
                    return;
                }
                user.setContext(v.getContext());

                user.getUsuarioByEmail();





                if ( ! user.getUserPassword().equals(editPassword.getText().toString()) ){
                    Toast.makeText(v.getContext(),"Credenciales incorrectas",Toast.LENGTH_LONG).show();
                    return;
                }

                user = user.getUsuarioByEmail();
                user.setContext(v.getContext());
                user.saveSesion();
                startActivity(intent);









            }
        });
    }



}