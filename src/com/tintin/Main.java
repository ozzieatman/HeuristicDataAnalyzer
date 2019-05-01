package com.tintin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FoodEngine engine = new FoodEngine();
        FoodProfile foodProfile = new TestFoodProfile();
        FoodItem[] suggestions = engine.start(foodProfile); //Give list of suggestion
        FoodItem[] profilePreferences = foodProfile.getFavoriteFoodItems();

        //test
//        for(int i =0; i<profilePreferences.length; i++) {
//            System.out.println(profilePreferences[i].getName());
//        }

//        FoodSimulations simulation = new FoodSimulations(suggestions, profilePreferences);

    }
}
