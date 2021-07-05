package com.example.signup_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText Loginusername,Loginpassword;
    Button btnlogin;
    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Loginusername=(EditText)findViewById(R.id.Loginusername);
        Loginpassword=(EditText)findViewById(R.id.Loginpassword);

        btnlogin=(Button)findViewById(R.id.btnlogin);

        myDB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = Loginusername.getText().toString();
                String pass = Loginpassword.getText().toString();


                if(user.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this,"Please enter the Credentials.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean result = myDB.checkusernamePassword(user,pass);
                    if(result==true){

                        Intent intent = new Intent(getApplicationContext(), volunteers1.class);
                        startActivity(intent);
                    }
                    else
                    {
                       Toast.makeText(LoginActivity.this,"Invalid Credentials.",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

}
}