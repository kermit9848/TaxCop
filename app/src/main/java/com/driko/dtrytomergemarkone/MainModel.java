package com.driko.dtrytomergemarkone;

public class MainModel {
    Integer cardLogo;
    String cardName;

    public MainModel (Integer cardLogo, String cardName){
        this.cardLogo = cardLogo;
        this.cardName = cardName;
    }

    public Integer getCardLogo(){
        return cardLogo;
    }

    public String getCardName(){
        return cardName;
    }
}
