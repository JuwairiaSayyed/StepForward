package com.example.signup_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password,vpassword;
    Button button,button3;
    DBHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.username);

        password=(EditText)findViewById(R.id.password);
        vpassword=(EditText)findViewById(R.id.vpassword);
        button= (Button)findViewById(R.id.button);
        button3=(Button)findViewById(R.id.button3);


        myDb = new DBHelper(this);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String vpass = vpassword.getText().toString();
                if (user.equals("") || pass.equals("") || vpass.equals("")) {
                    Toast.makeText(MainActivity.this, "Fill all the fields.", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if(pass.equals(vpass))
                    {
                       Boolean usercheckResult = myDb.checkusername(user);
                       if(usercheckResult==false){
                          Boolean regResult =  myDb.insertData(user,pass);
                           if(regResult==true){
                               Toast.makeText(MainActivity.this, "Registration Successful.", Toast.LENGTH_SHORT).show();
                               Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                               startActivity(intent);

                           }
                           else{
                               Toast.makeText(MainActivity.this, "Registration Failed.", Toast.LENGTH_SHORT).show();
                           }
                       }
                       else {
                           Toast.makeText(MainActivity.this, "User already Exists.\n Please Sign In.", Toast.LENGTH_SHORT).show();
                       }
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Password not Matching.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        button3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });




    }
}