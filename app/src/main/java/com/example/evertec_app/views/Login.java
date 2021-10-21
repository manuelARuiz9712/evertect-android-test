package com.example.evertec_app.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evertec_app.R;
import com.example.evertec_app.local_db.DbMainHelper;

public class Login extends AppCompatActivity {

    DbMainHelper localDbHelper;
    TextView registerText ;
    EditText editEmail;
    EditText editPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

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

                if ( ValidateForm()){




                }else{
                    Toast.makeText(v.getContext(),"Los campos son obligatorios",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private boolean ValidateForm (){
        boolean status = true;
        if ( this.editEmail.getText().toString().isEmpty() ){
            status = false;
        }
        if ( this.editPassword.getText().toString().isEmpty() ){
            status = false;
        }


        return status;
    }


}