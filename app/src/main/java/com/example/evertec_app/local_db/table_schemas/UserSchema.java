package com.example.evertec_app.local_db.table_schemas;

import com.example.evertec_app.models.User;

public  class UserSchema {
    public static  final String tableName  = "users";
    public static final String userId = "user_id";
    public static final String userName = "user_name";
    public  static  final  String userEmail = "user_email";
    public static  final  String userPassword = "user_password";



    public final String  CreateTableQuery(){

        return "CREATE TABLE "+this.tableName+"(" +
                this.userId+"  INTEGER PRIMARY KEY AUTOINCREMENT," +
                this.userName+" TEXT NOT NULL,"+
                this.userEmail+" TEXT NOT NULL,"+
                this.userPassword+" TEXT NOT NULL"+
                ")";

    }

    public final String GetUserByEmail(String email){

        return "SELECT * FROM "+this.tableName+" WHERE "+this.userEmail+"= '"+email+"'";
    }
    public  String getInsertQuery(User user){

        return "INSERT INTO "+this.tableName+" ("+this.userName+" ,"+this.userEmail+" , "+this.userPassword+" )" +
                "VALUES ( "+user.getUserName()+" , "+user.getUserEmail()+" , "+ user.getUserPassword() +" ) ";

    }





}
