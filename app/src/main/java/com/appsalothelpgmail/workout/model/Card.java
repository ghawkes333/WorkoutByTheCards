package com.appsalothelpgmail.workout.model;

public class Card {
    private int mSuit;
    private String mValue;

    public static final int SUIT_SPADES = 0;
    public static final int SUIT_CLUBS = 1;
    public static final int SUIT_HEARTS = 2;
    public static final int SUIT_DIAMONDS = 3;

    public Card(int suit, String value){
        mSuit = suit;
        mValue = value;
    }

    public int getSuit() {
        return mSuit;
    }

    public String getValue() {
        return mValue;
    }

    public void setSuit(int suit) {
        mSuit = suit;
    }

    public void setValue(String value) {
        mValue = value;
    }
}
