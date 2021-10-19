package com.example.evertec_app.local_db.models;

import com.example.evertec_app.models.Card;

public class CreditCard {

    public static final String tableName = "credit_card";
    public static final String creditCardId = "credit_card_id";
    public static final String creditCardToken = "credit_card_token";
    public static final String subtoken = "credit_card_subtoken";
    public static final String franchise = "credit_card_franchise";
    public static final String franchiseName = "credit_card_franchise_name";
    public static final String lastDigits = "credit_card_last_digits";
    public static final String validUntil = "credit_card_valid_until";
    public static final String installments = "credit_card_installments";
    public static final String userId = "credit_card_"+Users.userId;

    public  final String CreateTableQuery(){

            return "CREATE TABLE "+this.tableName+"(" +
                    this.creditCardId+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    this.creditCardToken+" TEXT NOT NULL," +
                    this.subtoken+" TEXT NOT NULL," +
                    this.franchise+" TEXT NULL," +
                    this.franchiseName+" TEXT NULL," +
                    this.lastDigits+" TEXT NULL," +
                    this.validUntil+" TEXT NULL," +
                    this.installments+" TEXT NULL," +
                    this.userId+" INTEGER NOT NULL" +
                   ")";

    }

    public final String GetUserCreditCard(int userId){

        return "SELECT * FROM "+this.tableName+" WHERE "+this.userId+" ="+userId;
    }



}
