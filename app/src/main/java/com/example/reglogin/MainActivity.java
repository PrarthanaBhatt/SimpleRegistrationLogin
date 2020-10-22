package com.example.reglogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName,editTextEmailId,editTextPassword;
    RadioButton radioButtonMale,radioButtonFemale,radioButtonOther;
    CheckBox checkBoxJava,checkBoxAndroid,checkBoxWeb;
    Button buttonRegister;

    String stringRegisterEmail,stringRegisterPassword,stringName,stringGenderMale,stringGenderFemale,stringGenderOther;
    String stringCheckBoxJava,stringCheckBoxAndroid,stringCheckBoxWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        editTextName = findViewById(R.id.editTextName);
        editTextEmailId = findViewById(R.id.editTextEmailId);
        editTextPassword = findViewById(R.id.editTextPassword);

        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioButtonOther = findViewById(R.id.radioButtonOther);

        checkBoxJava = findViewById(R.id.checkBoxJava);
        checkBoxAndroid = findViewById(R.id.checkBoxAndroid);
        checkBoxWeb = findViewById(R.id.checkBoxWeb);

        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                stringRegisterEmail = editTextEmailId.getText().toString();
                stringRegisterPassword = editTextPassword.getText().toString();

//                if(radioButtonMale.isChecked()){
//                    stringGenderMale = radioButtonMale.getText().toString();
//                }else if(radioButtonFemale.isChecked()){
//                    stringGenderFemale = radioButtonFemale.getText().toString();
//                }else{
//                    stringGenderOther = radioButtonOther.getText().toString();
//                }
//
//                if(checkBoxJava.isChecked()) {
//                    stringCheckBoxJava = checkBoxJava.getText().toString();
//                }else{
//                    stringCheckBoxJava = "null";
//                }
//
//                if(checkBoxAndroid.isChecked()) {
//                    stringCheckBoxAndroid = checkBoxAndroid.getText().toString();
//                }else{
//                    stringCheckBoxAndroid = "null";
//                }
//
//                if(checkBoxWeb.isChecked()){
//                    stringCheckBoxWeb = checkBoxWeb.getText().toString();
//                }else{
//                    stringCheckBoxWeb = "null";
//                }

                getNameValidate();

            }

            private void getNameValidate() {
                if(stringName.isEmpty()){
                    editTextName.setError("Name can't be empty!");
                }else if(stringName.length() < 2){
                    editTextName.setError("Name can't be single letter!");
                }else{
                    getRegisterEmailValidate();
                }

            }

            private void getRegisterEmailValidate() {
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


                if(stringRegisterEmail.isEmpty()){
                    editTextEmailId.setError("Email can't be empty!");
                }else if (!(stringRegisterEmail.matches(emailPattern))) {
                    Toast.makeText(getApplicationContext(), "Valid email address", Toast.LENGTH_SHORT).show();
                    getRegistrationPasswordValidate();
                }

            }

            private void getRegistrationPasswordValidate() {
                String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.* [@#$%^&+=!])(?=\\S+$).{4,}$";

                if(stringRegisterPassword.isEmpty()){
                    editTextPassword.setError("Password cam't be empty!");
                }else if (!(stringRegisterPassword.matches(PASSWORD_PATTERN))){
                    Toast.makeText(getApplicationContext(), "Valid password", Toast.LENGTH_SHORT).show();
                    getCourseValidate();
                }

            }

            private void getCourseValidate() {
                if(checkBoxJava.isChecked() || checkBoxAndroid.isChecked() || checkBoxWeb.isChecked() ){

                        Intent intentObject = new Intent(MainActivity.this,LoginActivity.class);

                        Bundle bundleObject = new Bundle();
                        bundleObject.putString("registerEmail",stringRegisterEmail);
                        bundleObject.putString("registerPassword",stringRegisterPassword);

//                        bundleObject.putString("radioButtonMale",stringGender);
//                        bundleObject.putString("radioButtonFemale",stringGender);
//                        bundleObject.putString("radioButtonOther",stringGender);

//                        bundleObject.putString("checkBoxJava",stringCheckBoxJava);
//                        bundleObject.putString("checkBoxAndroid",stringCheckBoxAndroid);
//                        bundleObject.putString("checkBoxWeb",stringCheckBoxWeb);

                        intentObject.putExtras(bundleObject);

                        startActivity(intentObject);

                }else{
                    Toast.makeText(getApplicationContext(), "No course is selected!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}