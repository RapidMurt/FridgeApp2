package com.example.fridgeapp.Fridge;

import androidx.annotation.Keep;

public class Card {
    private String title;
    private String expireDate;
    private String type;
    private String quantity;

    @Keep
    public Card()
    {
        //empty constructor needed
    }
    public Card (String title, String expireDate , String type , String quantity)
    {
        this.title = title;
        this.expireDate = expireDate;
        this.type = type;
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public String getType() {
        return type;
    }
}
