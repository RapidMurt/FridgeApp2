package com.example.fridgeapp.Party;

import androidx.annotation.Keep;

public class CardParty {

    private String title;
    private int quantity;
    private double price;
    private String type;
    @Keep
    public CardParty()
    {
        //empty constructor needed
    }
    public CardParty (String title, int quantity  , String type , double price)
    {
        this.title = title;
        this.quantity = quantity;
        this.type = type;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
