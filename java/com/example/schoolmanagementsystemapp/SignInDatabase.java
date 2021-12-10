package com.example.schoolmanagementsystemapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SignInDatabase extends SQLiteOpenHelper {
    private  static final String DbName="SignInDatabase.db";
    private Context context;

    public SignInDatabase(Context context) {
        super(context, DbName, null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tableNameQuery="create table SignInTable (id integer primary key autoincrement,Name text,EmailId text,Password text,DateOfBirth text,Address text,Gender text)";
        db.execSQL(tableNameQuery);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS SignInTable");
        onCreate(db);
    }

    public  String addToSignInTable(String name,String email,String password,String dob,String address,String gender){
        SQLiteDatabase sqlDb= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("EmailId",email);
        contentValues.put("Password",password);
        contentValues.put("DateOfBirth ",dob);
        contentValues.put("Gender",gender);

        contentValues.put("Address",address);
        long res= sqlDb.insert("SignInTable",null,contentValues);//it returns values
        sqlDb.close();
        if (res== -1){
            return "Failed to insert Data";
        }
        else
            return "SuccessFully Inserted";
    }

}
