package com.example.signup_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class patients1 extends AppCompatActivity implements View.OnClickListener {

    EditText pname,page,pcon,loc;
    Button s2;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients1);

        pname = (EditText) findViewById(R.id.pname);
        page = (EditText) findViewById(R.id.page);
        pcon = (EditText) findViewById(R.id.pcon);
        loc = (EditText) findViewById(R.id.loc);
        s2 = (Button) findViewById(R.id.s2);

        myDb = new DBHelper(this);
        s2.setOnClickListener(this);
    }

    public void onClick(View v) {
        if(v==s2)
        {
            // Checking for empty fields
            if(pname.getText().toString().trim().length()==0||
                    page.getText().toString().trim().length()==0||
                    pcon.getText().toString().trim().length()==0||
                    loc.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter all values");
                return;
            }
            myDb.execSQL("INSERT INTO users VALUES('"+pname.getText()+"','"+page.getText()+
                    "','"+pcon.getText()+"','"+loc.getText()+"');");
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
        pname.setText("");
        page.setText("");
        pcon.setText("");
        loc.setText("");
    }
}
