package com.tintin;

import java.util.ArrayList;

abstract public class FoodProfile {


    private String timeOfOrder;
    private String cusinePreference;
    private String palletePreference;
    private String[] dietaryPreference;
    private String[] allergiesPreference;
    private int[] favouriteDishes;

    private FoodItem[] favoriteFoodItems;

    protected void init(String time, String cusine, String pallete, String[] diet, String[] allergies, int[] fav) {
        timeOfOrder = time;
        cusinePreference = cusine;
        palletePreference = pallete;
        dietaryPreference = diet;
        allergiesPreference = allergies;
        favouriteDishes = fav;

        favoriteFoodItems = FoodModel.searchID(fav);

    }




    public String getTimeOfOrder() {
        return timeOfOrder;
    }


    public String getCusinePreference() {
        return cusinePreference;
    }



    public String getPalletePreference() {
        return palletePreference;
    }



    public String[] getDietaryPreference() {
        return dietaryPreference;
    }



    public String[] getAllergies() {
        return allergiesPreference;
    }




    public int[] getFavouriteDishes() {
        return favouriteDishes;
    }


    public FoodItem[] getFavoriteFoodItems() {
        return favoriteFoodItems;
    }
}
