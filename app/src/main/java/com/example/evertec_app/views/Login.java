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

public class Login extends AppCompatActivity {

    TextView registerText ;
    EditText editEmail;
    EditText editPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                    Toast.makeText(v.getContext(),"Los campos son obligatorios",Toast.LENGTH_LONG);
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