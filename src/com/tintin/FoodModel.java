package com.tintin;


import java.util.ArrayList;

public class FoodModel {
    //Holds the Model Data for the FoodItems



    static private int id = 0;
    private static FoodModel mInstance = null;

    public static int getId() {
        incrementId();
        return id;
    }

    private static void incrementId() {
        id=id+1;
    }


    final private int assortment_size = 90;
    final private String[] type = {"Main", "Side"};
    static final private String[] pallete = {"Spicy", "Sweet" , "Sour" , "Fruity" , "Salty" , "Earthy" , "Bitter" ,  "Umami" ,};
   static  final private String[] cusine = {"Indian", "Chinese" , "Western" , "Middle-Eastern" , "Fast-Food"};
    final private String[] allergens = {"None","Nuts" , "Dairy", "Shellfish", "Gluten Free", "Soy"};
    final private String[] dietary = {"None", "Veg", "Vegan", "Halal"};

    private FoodItem[] model;

    static public FoodModel buildModel() {
        if(mInstance == null) {
            mInstance = new FoodModel();
        }
        return mInstance;
    }

    private FoodModel() {
            model = new FoodItem[]{
                    //Indian Mains
                    new FoodItem(0, names[0], type[0], pallete[1], cusine[0], new String[]{allergens[1], allergens[2]}, new String[]{dietary[0]}),
                    new FoodItem(1, names[1], type[0], pallete[0], cusine[0], new String[]{allergens[4]}, new String[]{dietary[0]}),
                    new FoodItem(2, names[2], type[0], pallete[1], cusine[0], new String[]{allergens[1], allergens[2]}, new String[]{dietary[0]}),
                    new FoodItem(3, names[3], type[0], pallete[0], cusine[0], new String[]{allergens[0]}, new String[]{dietary[0]}),
                    new FoodItem(4, names[4], type[0], pallete[1], cusine[0], new String[]{allergens[1] , allergens[2]}, new String[]{dietary[0]}),

                    //Indian Veg Mains
                    new FoodItem(5, names[5], type[0], pallete[1], cusine[0], new String[]{allergens[0]}, new String[]{dietary[1]}),
                    new FoodItem(6, names[6], type[0], pallete[4], cusine[0], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(7, names[7], type[0], pallete[2], cusine[0], new String[]{allergens[0]}, new String[]{dietary[1]}),
                    new FoodItem(8, names[8], type[0], pallete[5], cusine[0], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(9, names[9], type[0], pallete[7], cusine[0], new String[]{allergens[0]}, new String[]{dietary[2]}),

                    //Indian Sides
                    new FoodItem(10, names[10], type[1], pallete[5], cusine[0], new String[]{allergens[0], allergens[4]}, new String[]{dietary[2]}),
                    new FoodItem(11, names[11], type[1], pallete[5], cusine[0], new String[]{allergens[2], allergens[4]}, new String[]{dietary[1]}),
                    new FoodItem(12, names[12], type[1], pallete[5], cusine[0], new String[]{allergens[2], allergens[4]}, new String[]{dietary[1]}),
                    new FoodItem(13, names[13], type[1], pallete[5], cusine[0], new String[]{allergens[2], allergens[4]}, new String[]{dietary[1]}),
                    new FoodItem(14, names[14], type[1], pallete[5], cusine[0], new String[]{allergens[2], allergens[4]}, new String[]{dietary[1]}),

                    //BBQ Mains
                    new FoodItem(15, names[15], type[0], pallete[0], cusine[2], new String[]{allergens[0]}, new String[]{dietary[3]}),
                    new FoodItem(16, names[16], type[0], pallete[0], cusine[2], new String[]{allergens[0]}, new String[]{dietary[3]}),
                    new FoodItem(17, names[17], type[0], pallete[0], cusine[2], new String[]{allergens[0]}, new String[]{dietary[3]}),
                    new FoodItem(18, names[18], type[0], pallete[1], cusine[2], new String[]{allergens[0]}, new String[]{dietary[0]}),
                    new FoodItem(19, names[19], type[0], pallete[2], cusine[2], new String[]{allergens[0]}, new String[]{dietary[0]}),

                    //BBQ Sides
                    new FoodItem(20, names[20], type[1], pallete[7], cusine[2], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(21, names[21], type[1], pallete[1], cusine[2], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(22, names[22], type[1], pallete[4], cusine[2], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(23, names[23], type[1], pallete[7], cusine[2], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(24, names[24], type[1], pallete[7], cusine[2], new String[]{allergens[0]}, new String[]{dietary[2]}),

                    //Misc Sides
                    new FoodItem(25, names[25], type[1], pallete[5], cusine[2], new String[]{allergens[4]}, new String[]{dietary[2]}),
                    new FoodItem(26, names[26], type[1], pallete[6], cusine[2], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(27, names[27], type[1], pallete[5], cusine[2], new String[]{allergens[0]}, new String[]{dietary[1]}),
                    new FoodItem(28, names[28], type[1], pallete[3], cusine[2], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(29, names[29], type[1], pallete[5], cusine[2], new String[]{allergens[0]}, new String[]{dietary[2]}),

                    //Burgers
                    new FoodItem(30, names[30], type[0], pallete[7], cusine[2], new String[]{allergens[4]}, new String[]{dietary[0]}),
                    new FoodItem(31, names[31], type[0], pallete[4], cusine[2], new String[]{allergens[4]}, new String[]{dietary[3]}),
                    new FoodItem(32, names[32], type[0], pallete[0], cusine[2], new String[]{allergens[4]}, new String[]{dietary[3]}),
                    new FoodItem(33, names[33], type[0], pallete[5], cusine[2], new String[]{allergens[4], allergens[5]}, new String[]{dietary[1]}),
                    new FoodItem(34, names[34], type[0], pallete[5], cusine[2], new String[]{allergens[4], allergens[5]}, new String[]{dietary[2]}),

                    //Wraps
                    new FoodItem(35, names[35], type[0], pallete[0], cusine[3], new String[]{allergens[4]}, new String[]{dietary[3]}),
                    new FoodItem(36, names[36], type[0], pallete[6], cusine[3], new String[]{allergens[4]}, new String[]{dietary[1]}),
                    new FoodItem(37, names[37], type[0], pallete[7], cusine[3], new String[]{allergens[4]}, new String[]{dietary[3]}),
                    new FoodItem(38, names[38], type[0], pallete[3], cusine[3], new String[]{allergens[4]}, new String[]{dietary[0]}),
                    new FoodItem(39, names[39], type[0], pallete[1], cusine[3], new String[]{allergens[4]}, new String[]{dietary[0]}),

                    //Pizza
                    new FoodItem(40, names[40], type[0], pallete[1], cusine[2], new String[]{allergens[4]}, new String[]{dietary[0]}),
                    new FoodItem(41, names[41], type[0], pallete[0], cusine[2], new String[]{allergens[4]}, new String[]{dietary[0]}),
                    new FoodItem(42, names[42], type[0], pallete[5], cusine[2], new String[]{allergens[4]}, new String[]{dietary[2]}),
                    new FoodItem(43, names[43], type[0], pallete[0], cusine[2], new String[]{allergens[4]}, new String[]{dietary[3]}),
                    new FoodItem(44, names[44], type[0], pallete[4], cusine[2], new String[]{allergens[4]}, new String[]{dietary[1]}),

                    //Chinese Mains
                    new FoodItem(45, names[45], type[0], pallete[7], cusine[1], new String[]{allergens[0]}, new String[]{dietary[1]}),
                    new FoodItem(46, names[46], type[0], pallete[0], cusine[1], new String[]{allergens[0]}, new String[]{dietary[0]}),
                    new FoodItem(47, names[47], type[0], pallete[1], cusine[1], new String[]{allergens[0]}, new String[]{dietary[0]}),
                    new FoodItem(48, names[48], type[0], pallete[7], cusine[1], new String[]{allergens[0]}, new String[]{dietary[0]}),
                    new FoodItem(49, names[49], type[0], pallete[5], cusine[1], new String[]{allergens[5]}, new String[]{dietary[2]}),

                    //Chinese Sides
                    new FoodItem(50, names[50], type[1], pallete[7], cusine[1], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(51, names[51], type[1], pallete[5], cusine[1], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(52, names[52], type[1], pallete[6], cusine[1], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(53, names[53], type[1], pallete[7], cusine[1], new String[]{allergens[0]}, new String[]{dietary[1]}),
                    new FoodItem(54, names[54], type[1], pallete[7], cusine[1], new String[]{allergens[4]}, new String[]{dietary[2]}),

                    //Chinese Veg
                    new FoodItem(55, names[55], type[0], pallete[4], cusine[1], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(56, names[56], type[0], pallete[7], cusine[1], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(57, names[57], type[1], pallete[5], cusine[1], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(58, names[58], type[1], pallete[7], cusine[1], new String[]{allergens[5]}, new String[]{dietary[2]}),
                    new FoodItem(59, names[59], type[0], pallete[4], cusine[1], new String[]{allergens[4]}, new String[]{dietary[2]}),

                    //Indian tandoor
                    new FoodItem(60, names[60], type[0], pallete[4], cusine[0], new String[]{allergens[0]}, new String[]{dietary[3]}),
                    new FoodItem(61, names[61], type[0], pallete[0], cusine[0], new String[]{allergens[0]}, new String[]{dietary[3]}),
                    new FoodItem(62, names[62], type[0], pallete[0], cusine[0], new String[]{allergens[0]}, new String[]{dietary[3]}),
                    new FoodItem(63, names[63], type[0], pallete[5], cusine[0], new String[]{allergens[0]}, new String[]{dietary[3]}),
                    new FoodItem(64, names[64], type[0], pallete[0], cusine[0], new String[]{allergens[0]}, new String[]{dietary[3]}),

                    //Indian tandoor veg
                    new FoodItem(65, names[65], type[1], pallete[0], cusine[0], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(66, names[66], type[1], pallete[1], cusine[0], new String[]{allergens[0]}, new String[]{dietary[1]}),
                    new FoodItem(67, names[67], type[1], pallete[0], cusine[0], new String[]{allergens[0]}, new String[]{dietary[1]}),
                    new FoodItem(68, names[68], type[1], pallete[6], cusine[0], new String[]{allergens[0]}, new String[]{dietary[2]}),
                    new FoodItem(69, names[69], type[1], pallete[5], cusine[0], new String[]{allergens[0]}, new String[]{dietary[2]}),

                    //Desserts
                    new FoodItem(70, names[70], type[1], pallete[1], cusine[2], new String[]{allergens[2]}, new String[]{dietary[1]}),
                    new FoodItem(71, names[71], type[1], pallete[1], cusine[2], new String[]{allergens[2]}, new String[]{dietary[1]}),
                    new FoodItem(72, names[72], type[1], pallete[1], cusine[2], new String[]{allergens[2]}, new String[]{dietary[1]}),
                    new FoodItem(73, names[73], type[1], pallete[1], cusine[2], new String[]{allergens[2]}, new String[]{dietary[1]}),
                    new FoodItem(74, names[74], type[1], pallete[1], cusine[2], new String[]{allergens[2], allergens[1]}, new String[]{dietary[1]}),

                    //Fast Food Sides
                    new FoodItem(75, names[75], type[1], pallete[7], cusine[2], new String[]{allergens[1]}, new String[]{dietary[2]}),
                    new FoodItem(76, names[76], type[1], pallete[7], cusine[2], new String[]{allergens[1]}, new String[]{dietary[0]}),
                    new FoodItem(77, names[77], type[1], pallete[7], cusine[2], new String[]{allergens[1]}, new String[]{dietary[1]}),
                    new FoodItem(78, names[78], type[1], pallete[7], cusine[2], new String[]{allergens[1]}, new String[]{dietary[0]}),
                    new FoodItem(79, names[79], type[1], pallete[7], cusine[2], new String[]{allergens[1]}, new String[]{dietary[1]}),

                    //Fast Food Mains
                    new FoodItem(80, names[80], type[0], pallete[7], cusine[2], new String[]{allergens[1]}, new String[]{dietary[0]}),
                    new FoodItem(81, names[81], type[0], pallete[7], cusine[2], new String[]{allergens[1]}, new String[]{dietary[0]}),
                    new FoodItem(82, names[82], type[0], pallete[7], cusine[2], new String[]{allergens[1]}, new String[]{dietary[0]}),
                    new FoodItem(83, names[83], type[0], pallete[7], cusine[2], new String[]{allergens[1]}, new String[]{dietary[2]}),
                    new FoodItem(84, names[84], type[0], pallete[7], cusine[2], new String[]{allergens[1]}, new String[]{dietary[2]}),

                    //Classics
                    new FoodItem(85, names[85], type[0], pallete[4], cusine[1], new String[]{allergens[3]}, new String[]{dietary[0]}),
                    new FoodItem(86, names[86], type[0], pallete[0], cusine[3], new String[]{allergens[0]}, new String[]{dietary[3]}),
                    new FoodItem(87, names[87], type[0], pallete[0], cusine[3], new String[]{allergens[0]}, new String[]{dietary[3]}),
                    new FoodItem(88, names[88], type[0], pallete[5], cusine[2], new String[]{allergens[4]}, new String[]{dietary[0]}),
                    new FoodItem(89, names[89], type[0], pallete[0], cusine[3], new String[]{allergens[0]}, new String[]{dietary[0]})

            };
    }

    final private String[] names =
            {
                    "Chicken Korma", "Lamb Vindaloo", "Butter Chicken", "Lamb Roganjosh" , "Chicken Tikka Masala" , //Indian Mains 0
                    "Paneer Makhani" , "Tarka Dal" , "Dal Makhani" , "Bhindi Masala" , "Veg Biryani" , //Indian Veg Mains 5
                    "Plain Rice", "Plain Naan","Roti","Paratha", "Butter Naan" , // Sides 9
                    "Peri Full Chicken","Peri Wings","Peri Half Chicken","BBQ Chicken","Sweet & Sour Chicken", //BBQ Mains
                    "Normal Chips","Sweet Potatoe","Peri-Peri Salted Chips","Coldslaw","Corn on Cob", //BBQ Sides
                    "Garlic Bread","Olive Mix","Halloumi","Salad","Mashed Potato", //Misc Sides
                    "Cheese Burger","Chicken Burger","Spicy Lamb Burger","Veg Burger","Vegan Burger", //Burgers
                    "Chicken Wrap","Veg Wrap","Lamb Wrap","Peri Wrap","BBQ Wrap", //Wraps
                    "Hot & Spicy","All Meats","Green Feast","Tandoori Hot","Magarita", // Pizza
                    "Wanton Noodle Soup","Hot & Spicy Pork","Sweet and Sour Pork","Duck Stirfry","Corn Soup", //Chinese Main
                    "Crackers","Steamed Rice","Veg Stir Fry","Egg Fried Rice ","Chow Mein", //Chinese Sides
                    "Mixed Veg StirFry","Mixed Veg Soup","Veg Fried Rice","Tofu","Vegan ChowMein", // Chinese Veg
                    "Chicken Tikka","Lamb Kofta","Mixed Grill","Lamb Chops","Kebab Set", //Indian Tandoor
                    "Chilli Mushroom","Paneer Tikka","Chilli Paneer","Mixed Veg Grill","Veg Momo's", //Indian tandoor Veg
                    "Chocolate Mouse","White Choc Mouse","Waffle","Ice Cream Assortment","Milkhshake Peanut", // Desserts
                    "McDonalds Fries","McDonalds Chicken Strips","BK Cheese Bites","BK Nuggets","BK Fries", // Fast Food sides
                    "Big Mac","Whopper","KFC Bucket","Veg Burger BK","Veg Burker MCDonalds", //Fast Food mains
                    "Sushi Set","Chicken Donner","Lamb Donner","Fish Wrap","Randomm", // Classics 90
            };


    public static FoodItem[] searchID(int ... ints) {
        ArrayList<FoodItem> items = new ArrayList<>();
        for(int s = 0; s < ints.length; s++) {
            for (int i = 0; i < buildModel().assortment_size; i++) {
                if (ints[s] == buildModel().getModel()[i].getItem_id()) {
                    items.add(buildModel().getModel()[i]);
                }
            }
        }
        return items.toArray(new FoodItem[items.size()]);
    }

    public FoodItem[] getModel() {
        return model;
    }


    public static String getCusine(int index) {
        return cusine[index];

    }

    public static String getPallete(int index) {
        return pallete[index];
    }
}




