package com.tintin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FoodEngine {
    //Takes Suggestion
    //Applies First Principles
    //Applies Data Analysis
    //Applies Genetic Algorithm

    private FoodProfile mProfile;
    private ArrayList<FoodItem> database = new ArrayList<>();

    public FoodEngine() {

    }

    public FoodItem[] start(FoodProfile profile) {

        //Get Dataset
        FoodItem[] tempFoodItems = FoodModel.buildModel().getModel();

        //test tempFoodItems
//        for(FoodItem i : tempFoodItems) { System.out.println(i.getName());}

        collate(tempFoodItems);
        mProfile = profile;

        FoodItem[] predictions = Genetics(DataAnalysis(MetaData(tempFoodItems)));

        //Final Test
        for(int x =0; x < predictions.length; x++) {
            if(x % 2 == 0) {
                System.out.println("Set " + (x / 2));
            }
            System.out.println(predictions[x].getName());
        }


        return  predictions;

    }

    private void collate(FoodItem[] items) { // Add Elements to ArrayList
        database.addAll(Arrays.asList(items));
    }

    private FoodItem[] MetaData(FoodItem[] i) {
        //Dietary & Allergens
        String[] allergies = mProfile.getAllergies();
        String[] dietary = mProfile.getDietaryPreference();

        //Remove Allergies
        removeAllergies(allergies, i);
        removeDietaries(dietary, database.toArray(new FoodItem[database.size()]));
        System.out.println(database.size()); //TEST

        return database.toArray(new FoodItem[database.size()]);

    }

    private void removeAllergies(String[] a, FoodItem[] i) {
        ArrayList<FoodItem> allergyList = new ArrayList<>();
        //iterate through the database the number of times there are allergies; only checking allergy index
        //go through each element of the array's allergies and see if they match

       for(String allergy : a) //each allergy
           for(FoodItem item: i )
               for(String data_allergy : item.getAllergens())
                   if(allergy == data_allergy)
                       database.remove(item);
//                   System.out.println(database.size()); //TEST

    }

    private void removeDietaries(String[] d, FoodItem[] i) {
        //Test Dietary and FoodItems database exists

        for(String dietary : d)
            //each dietary restriction
            switch(dietary) {
                case "None":
                    System.out.println("None"); //TEST
                    break;
                case "Halal":
                    System.out.println("Halal"); //TEST
                    for(FoodItem f : i)
                        if(f.getDietary()[0] == "None")
                            database.remove(f);
                    break;
                case "Veg":
                    System.out.println("Veg"); //TEST
                    for(FoodItem f: i)
                        if(f.getDietary()[0] == "None" || f.getDietary()[0] == "Halal")
                            database.remove(f);
                    break;

                case "Vegan":
                    System.out.println("Vegan"); //TEST
                    for(FoodItem f: i)
                        if(f.getDietary()[0] == "None" || f.getDietary()[0] == "Halal" || f.getDietary()[0] == "Veg")
                            database.remove(f);
                    break;
            }

        //None Remove Nothing

        //Halal: Remove None

        //Veg: Remove None, Halal

        //Vegan: Remove everything but Vegan
    }



    private FoodItem[] DataAnalysis(FoodItem[] i) {
    //Preparing the initial population


    //Split Sides and Mains into two lists
        ArrayList<FoodItem> mains = new ArrayList<>();
        ArrayList<FoodItem> sides = new ArrayList<>();


        //Assigns Cusine Score & Pallete Score during list split
        for(FoodItem element : i) {
            if (element.getType() == "Main") {
                if (element.getCusine() == mProfile.getCusinePreference()) {
                    element.setScore(1);
                    if (element.getPallete() == mProfile.getPalletePreference()) {
                        element.setScore(1);
                    }
                }
                mains.add(element);
            } else {
                if (element.getCusine() == mProfile.getCusinePreference()) {
                    element.setScore(1);
                    if (element.getPallete() == mProfile.getPalletePreference()) {
                        element.setScore(1);
                    }
                }
                sides.add(element);
            }
        }

        //Add

        //TEST
//            System.out.println(mains.size() + " " + sides.size() ); //TEST
//        for(FoodItem m : mains)
//            System.out.println("Score " + m.getScore());
//        for(FoodItem s: sides)
//            System.out.println("Score " + s.getScore());

        ArrayList<FoodItem> total = new ArrayList<>(mains);
        total.addAll(sides);


        //Sorts the Scores
        return total.toArray(new FoodItem[total.size()]);

    }

    private FoodItem[] Genetics(FoodItem[] i) { //a pool of 28 creates 171 combinations
        ArrayList<FoodItem> candidates = new ArrayList<>();
        //High Score Experimental;
            //Time of Day Impact
        //Experimental add non cusine and pallete and subtract; for each point that experimental is out of 10
//        FavFoods Score is target
        //Genetics with full DB: target is DataAnalysis Set



        //Initialize Population (DONE)
        FoodItem[] population = i;


//        //Test1: iterate through all scores
//        for(FoodItem p : population)
//            System.out.println(p.getScore());

//Start Generation Iteration here
        int generation = 0;
        while(generation < 5) {


            //Loop Through All and Assess Fitness: Fitness is Score / Attributes  so 10 / 2 = 5
            for (FoodItem member : population) {
                member.setScore(fitnessScore(member.getScore()));
            }

//        System.out.println("=========");

            //Test2: Iteate through all fitness
//        for(FoodItem p : population)
//            System.out.println(p.getScore());


            //take fittest and express from 0 to 1 (noramalize)xxx
            //so 12, 5 ,5 ,5
            //Start Selection process
            ArrayList<FoodItem> mating_pool = new ArrayList<>();
            for (FoodItem member : population) {
                if (member.getScore() > 0) {
                    mating_pool.add(member);
                }
            }

            //Normalization process
            int pool_size = mating_pool.size();
            for (FoodItem alpha : mating_pool)
                alpha.setScore(alpha.getScore() * (pool_size - 1));

            //Express the mating pool, as a ratio of the total
            ArrayList<FoodItem> temp = new ArrayList<>();
            for (int e = 0; e < mating_pool.size(); e++) { //Iterate through mating pool
                for (int c = 0; c < mating_pool.get(e).getScore(); c++) {
                    temp.add(mating_pool.get(e));
                }
            }
            mating_pool.clear();
            mating_pool.addAll(temp);

            //TEST
//        System.out.println(mating_pool.size());

            //Selects two elements randomly
            int counter = 0;
            ArrayList<FoodItem> selector = new ArrayList<>();
            Random rand = new Random();
            while (counter < 2) {
                int size = mating_pool.size();
                int generator = rand.nextInt((size) - 1);
                selector.add(mating_pool.get(generator));
                counter++;
            }


//        //Test THIS PART IS KEY AS THESE ARE THE RESULTS
            for (FoodItem e : selector) {
                candidates.add(e);
//                System.out.println(e.getName());
            }


            FoodItem DNA = mutate(crossover(selector.toArray(new FoodItem[selector.size()])));
            //combine attributes + mutate them

            //Search the population for attributes with the parents DNA
            for (FoodItem p : population) {
                if (p.getCusine() == DNA.getCusine() || p.getPallete() == DNA.getPallete()) {
                    //update score
                    p.setScore(1);

                }
            }
            generation++;
        }

        return candidates.toArray(new FoodItem[candidates.size()]);

    }

    private FoodItem mutate(FoodItem gene) {

            FoodItem g = gene;
            double mutate_rate = 0.0199999;
            double r = Math.random();
            System.out.println("TEST " + r);
            if (r < mutate_rate) {
                Random random = new Random();
               int attr_selector =  random.nextInt(3);
               System.out.println("Attr Selector: " +attr_selector);
                if (attr_selector < 1) {
                    //mutate pallete
                    int mutator = random.nextInt(7 - 1);
                    System.out.println("Mutator 1 " + mutator);
                    g = new FoodItem(gene.getItem_id(), gene.getName(), gene.getType(), FoodModel.getPallete(mutator), gene.getCusine(), gene.getAllergens(), gene.getDietary());
                } else {
                    //mutate cusine
                    int mutator = random.nextInt(4 - 1);
                    System.out.println( "Mutator  2" + mutator);
                    g = new FoodItem(gene.getItem_id(), gene.getName(), gene.getType(), gene.getPallete(), FoodModel.getCusine(mutator), gene.getAllergens(), gene.getDietary());
                }
            }

            //TEST G
//            System.out.println(g.getName() + " " + g.getScore() + " " + g.getPallete() + g.getCusine());

        return g;

    }

    private FoodItem crossover(FoodItem[] parents) {

        FoodItem parentA = parents[0];
        FoodItem parentB = parents[1];

//        System.out.println(parentB.getCusine());

        Random random = new Random();
        int seed = random.nextInt(2);
        System.out.println(seed);

        FoodItem attribute;
        if(seed <= 0) {
            //cusine from A Pallete from B
            attribute = new FoodItem(101, "", "Main", parentB.getPallete(), parentA.getCusine(), parentA.getAllergens(), parentA.getDietary());
        } else {
            attribute = new FoodItem(101, "", "Side", parentA.getPallete(), parentB.getCusine(), parentA.getAllergens(), parentA.getDietary());
        }
//        System.out.println(attribute.getName() + " " + attribute.getScore() + " " + attribute.getPallete() + attribute.getCusine() );
        return attribute;

    }

    private int fitnessScore(int score) {
        //Take score and divided by attributes; so in this case 2: Pallete & Cusine
        if(score >0) {
            score = score/2;
        }
        return score;
    }

}
