package com.example.reglogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
public class LoginActivity extends AppCompatActivity {

    EditText editTextLoginId,editTextLoginPassword;
    Button buttonLogin;

    String stringRegisterEmail,stringRegisterPassword,stringLoginEmail,stringLoginPassword;
    String stringMale,stringFemale,stringOther,stringJava,stringAndroid,stringWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        editTextLoginId = findViewById(R.id.editTextLoginId);
        editTextLoginPassword = findViewById(R.id.editTextLoginPassword);

        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                getBundleData();

                stringLoginEmail = editTextLoginId.getText().toString();
                stringLoginPassword = editTextLoginPassword.getText().toString();

                getValidationLogin();

            }

            private void getBundleData() {
                Bundle bundleLoginObject = getIntent().getExtras();

                stringRegisterEmail = bundleLoginObject.getString("registerEmail");
                stringRegisterPassword = bundleLoginObject.getString("registerPassword");
//                stringMale = bundleLoginObject.getString("radioButtonMale");
//                stringFemale = bundleLoginObject.getString("radioButtonFemale");
//                stringOther = bundleLoginObject.getString("radioButtonOther");
//                stringJava = bundleLoginObject.getString("checkBoxJava");
//                stringAndroid = bundleLoginObject.getString("checkBoxAndroid");
//                stringWeb = bundleLoginObject.getString("checkBoxWeb");


                //Toast.makeText(getApplicationContext(),"bundleEmail:"+stringRegisterEmail,Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(),"bundlePassword:"+stringRegisterPassword,Toast.LENGTH_LONG).show();

            }
            private void getValidationLogin() {
                if(stringLoginEmail.isEmpty())
                {
                    editTextLoginId.setError("Please enter Login email...");
                    Toast.makeText(getApplicationContext(),"Please enter Login email...",Toast.LENGTH_LONG).show();
                }else if(stringLoginPassword.isEmpty())
                {
                    editTextLoginPassword.setError("Please enter Login password...");
                    Toast.makeText(getApplicationContext(),"Please enter Login password...",Toast.LENGTH_LONG).show();
                }else
                {
                    if(stringLoginEmail.equals(stringRegisterEmail))
                    {
                        if (stringLoginPassword.equals(stringRegisterPassword))
                        {
                            Toast.makeText(getApplicationContext(),"Login Successful...",Toast.LENGTH_LONG).show();
                        }else
                        {
                            editTextLoginId.setError("Password Incorrect...");
                            //Toast.makeText(getApplicationContext(),"password incorrect",Toast.LENGTH_LONG).show();
                        }
                    }else
                    {
                        editTextLoginId.setError("Email Incorrect...");
                        // Toast.makeText(getApplicationContext(),"email incorrect",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}









