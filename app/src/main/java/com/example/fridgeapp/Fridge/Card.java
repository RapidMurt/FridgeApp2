package com.example.fridgeapp.Fridge;

public class Card {
    private String title;
    private String expireDate;
    private String type;

    public Card()
    {
        //empty constructor needed
    }
    public Card (String title, String expireDate , String type)
    {
        this.title = title;
        this.expireDate = expireDate;
        this.type = type;
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
