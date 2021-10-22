package com.example.evertec_app.models;

import java.util.regex.Pattern;

public class Card {
    private String number;
    private String expiration;
    private String cvv;
    private int installments;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public int getInstallments() {
        return installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

    public boolean isValidTarget(){
            boolean status = true;

            if ( this.number.length() < 20 ){
                status = false;
            }
            if ( this.cvv.length() != 3 ){
                status = false;
            }
            if (!Pattern.matches("^[01]\\d\\/\\d{2}$",this.expiration)){
                status = false;
            }


            return status;


    }


}
