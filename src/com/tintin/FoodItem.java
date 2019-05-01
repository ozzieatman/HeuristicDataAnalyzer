package com.tintin;
 public class FoodItem {


    private int item_id = 0;
    private String name = "";
    private String type = "";
    private String pallete = "";
    private String cusine = "";
    private String[] allergens;
    private String[] dietary;




    public  FoodItem(final int id, String name, String type, String pallete,
                               String cusine, String[] allergens, String[] dietary) {
        this.item_id = id;
         this.name = name;
         this.type = type;
         this.pallete = pallete;
         this.cusine = cusine;
         this.allergens = allergens;
         this.dietary =dietary;
     }

     public String getName() {
         return name;
     }

     public String getType() {
         return type;
     }

     public String getPallete() {
         return pallete;
     }

     public String getCusine() {
         return cusine;
     }

     public String[] getAllergens() {
         return allergens;
     }

     public String[] getDietary() {
         return dietary;
     }

     public int getItem_id() {
         return item_id;
     }

     private int score = 0;
     private FoodItem compliment; //Side or Main


     public int getScore() {
         return score;
     }

     public void setScore(int score) {
         this.score = this.score + score;
     }

     public FoodItem getCompliment() {
         return compliment;
     }

     public void setCompliment(FoodItem compliment) {
         this.compliment = compliment;
     }


 }
