package com.example.ken.github_challenge;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    Button btn;
    EditText txtEmail,txtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn=(Button) findViewById(R.id.btn_connect);

        txtEmail=(EditText) findViewById(R.id.email);
        txtPwd=(EditText) findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtEmail.getText().toString().equals("") || txtPwd.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Votre email ou votre mot de passe est vide !!!",Toast.LENGTH_LONG).show();
                }
                else {
                    if (txtEmail.getText().toString().equals("ghost")){
                        Toast.makeText(getApplicationContext(),"Votre email est invalide !!!",Toast.LENGTH_LONG).show();
                    }
                    else {
                        if (!txtEmail.getText().toString().equals("ghost@gmail.com")){
                            Toast.makeText(getApplicationContext(),"Votre email est incorect !!!",Toast.LENGTH_LONG).show();
                        }
                        else{
                            if (txtPwd.getText().toString().length()<5){
                                Toast.makeText(getApplicationContext(),"Votre mot de passe est trop court !!!",Toast.LENGTH_LONG).show();
                            }
                            else{

                                if ((txtEmail.getText().toString().equals("ghost@gmail.com")) && txtPwd.getText().toString().equals("ghost123")){
                                    Toast.makeText(getApplicationContext(),"Connexion reussie !!!", Toast.LENGTH_LONG).show();
                                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"Verifier vos informations !!!",Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    }
                }


            }
        });
    }
}
