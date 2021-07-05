package com.example.signup_1;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class volunteers1 extends AppCompatActivity implements View.OnClickListener {

    EditText vname,vage,vcon,vemail;
    Button s1;
    DBHelper myDBv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteers);

        vname = (EditText) findViewById(R.id.vname);
        vage = (EditText) findViewById(R.id.vage);
        vcon = (EditText) findViewById(R.id.vcon);
        vemail = (EditText) findViewById(R.id.vemail);
        s1 = (Button) findViewById(R.id.s1);

        myDbv= new DBHelper(this);
        s1.setOnClickListener(this);
    }

    public void onClick(View v) {
        if(v==s1)
        {
            // Checking for empty fields
            if(vname.getText().toString().trim().length()==0||
                    vage.getText().toString().trim().length()==0||
                    vcon.getText().toString().trim().length()==0||
                    vemail.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter all values");
                return;
            }
            myDbv.execSQL("INSERT INTO users VALUES('"+vname.getText()+"','"+vage.getText()+
                    "','"+vcon.getNum()+"','"+vemail.getText()+"');");
            showMessage("Success", "Details saved");
            clearText();
        }
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText()
    {
        vname.setText("");
        vage.setText("");
        vcon.setText("");
        vemail.setText("");
    }
}
