package com.example.evertec_app.models;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.evertec_app.local_db.DbMainHelper;
import com.example.evertec_app.local_db.table_schemas.UserSchema;

public class User {
    private DbMainHelper localDbHelper;
    private Context context;
    private String userId;
    private String userName ;
    private String userEmail;
    private  String userPassword;

    public User (){}

    public User (Context context){

        this.localDbHelper =  new DbMainHelper(context);
        this.context = context;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public void setContext(Context context){
        this.context = context;
    }

    public boolean ValidateLogin(){
        boolean status = true;
        if  ( this.userEmail.isEmpty() ){
            status = false;
        }
        if  ( this.userPassword.isEmpty() ){
            status = false;
        }

        return status;
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

    public User getUsuarioByEmail(){

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
        cursor.moveToFirst();
        User user = new User();
        user.setUserId(cursor.getString(0));
        user.setUserName(cursor.getString(1));
        user.setUserEmail(cursor.getString(2));
        user.setUserPassword(cursor.getString(3));

        return user;

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

    public void saveSesion(){
        SharedPreferences sharedPref = this.context.getSharedPreferences("SESION",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(UserSchema.userId, this.userId);
        editor.putString(UserSchema.userName, this.userName);
        editor.putString(UserSchema.userEmail, this.userEmail);
        editor.commit();
    }
    public User getSesion(){
        SharedPreferences sharedPref = this.context.getSharedPreferences("SESION",Context.MODE_PRIVATE);
        User user = new User();
        user.setUserId(sharedPref.getString(UserSchema.userId,null));
        user.setUserName(sharedPref.getString(UserSchema.userName,null));
        user.setUserEmail(sharedPref.getString(UserSchema.userEmail,null));
        return user;
    }
    public void dropSesion(){
        SharedPreferences sharedPref = this.context.getSharedPreferences("SESION",Context.MODE_PRIVATE);
        sharedPref.edit().clear().commit();

    }
}
