package com.example.schoolmanagementsystemapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginSQLiteDatabase extends SQLiteOpenHelper {
    private  static final String DbName="LoginDatabase.db";
    private Context context;

    public LoginSQLiteDatabase(Context context) {
        super(context, DbName, null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tableNameQuery="create table LoginTable (id integer primary key autoincrement,Name text,RegistrationNo text,Password text)";
        db.execSQL(tableNameQuery);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS LoginTable");
        onCreate(db);
    }

    public  String addToLoginTable(String name,String regNo,String password){
        SQLiteDatabase sqlDb= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("RegistrationNo",regNo);
        contentValues.put("Password",password);
        long res= sqlDb.insert("LoginTable",null,contentValues);//it returns values
        sqlDb.close();
        if (res== -1){
            return "Failed to insert Data";
        }
        else
            return "SuccessFully Inserted";
    }

}



