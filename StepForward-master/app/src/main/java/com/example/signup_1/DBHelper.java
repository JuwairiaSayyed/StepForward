package com.example.signup_1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper{


    public DBHelper(Context context){
        super(context,"Signup.db",null,1);
      }

    @Override
    public void onCreate(SQLiteDatabase myDB,myDBv) {
          myDB.execSQL("create Table users(username Text primary key,password Text)");
          myDBv.execSQL("create Table volunteers(vname Text primary key, vage Int, vcon Num, vemail Text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
          myDB.execSQL("drop Table if exists users");
    }
    public Boolean insertData(String username,String password){
        SQLiteDatabase myDB= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);

        long result = myDB.insert("users",null,contentValues);

        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean checkusername(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username= ?",new String[] {username});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean checkusernamePassword(String username, String password){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username= ? and password=?",new String[] {username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
}
