package com.example.evertec_app.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.evertec_app.local_db.DbMainHelper;
import com.example.evertec_app.local_db.table_schemas.UserSchema;

public class User {
    private DbMainHelper localDbHelper;
    private String UserId;
    private String userName ;
    private String userEmail;
    private  String userPassword;

    public User (){}

    public User (Context context){
        this.localDbHelper =  new DbMainHelper(context);
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public boolean ValidateRegister(){
        boolean status = true;
        if  ( this.userName.isEmpty() ){
            status = false;
        }
        if  ( this.userEmail.isEmpty() ){
            status = false;
        }
        if  ( this.userPassword.isEmpty() ){
            status = false;
        }

        return status;
    }

    public boolean existUser (){
        SQLiteDatabase db = this.localDbHelper.getReadableDatabase();

        String selection = UserSchema.userEmail + " = ?";
        String[] projection;
        String[] selectionArgs = { this.userEmail };

        Cursor cursor = db.query(
                UserSchema.tableName,
                null,
                selection,
                selectionArgs,
                null,
                null,
                        null
                );

        if (cursor.getCount() > 0){
            return  true;
        }

        return false;
    }

    public long saveUser (){

        SQLiteDatabase db = this.localDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserSchema.userName,this.userName);
        values.put(UserSchema.userEmail,this.userEmail);
        values.put(UserSchema.userPassword,this.userPassword);
        return   db.insert(UserSchema.tableName, null, values);


        // db.validateSql( userTableSchema.getInsertQuery(this),null );

    }
}
