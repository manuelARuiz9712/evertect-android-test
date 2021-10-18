package com.example.evertec_app.models;

public class AmountConversion {

    private AmountBase from;
    private AmountBase to;
    private int factor;

    public AmountBase getFrom() {
        return from;
    }

    public void setFrom(AmountBase from) {
        this.from = from;
    }

    public AmountBase getTo() {
        return to;
    }

    public void setTo(AmountBase to) {
        this.to = to;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }
}
