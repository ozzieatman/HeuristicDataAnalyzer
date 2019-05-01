package com.tintin;

public class FoodSimulations {


    public FoodSimulations(FoodItem[] suggestions, FoodItem[] profilePreferences) {
    }

    public void start(FoodItem[] suggestions, FoodItem[] profilePreferences) {
        for (FoodItem suggestion : suggestions) {
            for (FoodItem profilePreference : profilePreferences) {
                if (suggestion.getItem_id() == profilePreference.getItem_id()) {
                    System.out.println("Matched Suggestion " + suggestion.getName() + " with " + profilePreference.getName());
                    return;
                }
                System.out.println("No Match, Suggestion:  " + suggestion.getName() + " with " + profilePreference.getName());
            }
        }
    }

}
