package com.example.evertec_app.views;

import androidx.appcompat.app.AppCompatActivity;

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

public class Register extends AppCompatActivity {


    TextView inicioSesion;
    EditText name;
    EditText email;
    EditText password;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Registro de usuarios");


        inicioSesion = (TextView) findViewById(R.id.text_iniciar_sesion);
        name = (EditText) findViewById(R.id.edit_text_name);
        email = (EditText) findViewById(R.id.edit_text_email);
        password = (EditText) findViewById(R.id.edit_text_password);
        btnRegister = (Button) findViewById(R.id.btn_register);


        inicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User newUser = new User(getApplicationContext());

                newUser.setUserName(name.getText().toString());
                newUser.setUserEmail(email.getText().toString());
                newUser.setUserPassword(password.getText().toString());

                if ( !newUser.ValidateRegister()  ){
                    Toast.makeText(v.getContext(),"Algunos campos estan vacios",Toast.LENGTH_LONG).show();
                }else{
                    if ( newUser.existUser() ){
                        Toast.makeText(v.getContext(),"El usuario ya existe en la base de datos",Toast.LENGTH_LONG).show();
                    }else{

                        long userId =  newUser.saveUser();
                        Log.e("USER_ID::",userId+"");
                        Toast.makeText(v.getContext(),"Usuario registrado exitosamente",Toast.LENGTH_LONG).show();

                    }


                }




            }
        });



    }
}