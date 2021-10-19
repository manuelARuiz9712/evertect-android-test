package com.example.evertec_app.local_db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.evertec_app.local_db.models.CreditCard;
import com.example.evertec_app.local_db.models.Users;

public class DbMain extends SQLiteOpenHelper {

    private  Users user = new Users();
    private CreditCard creditCard = new CreditCard();
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "test_evertec.db";

    public DbMain(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.user.CreateTableQuery());
        db.execSQL(this.creditCard.CreateTableQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
