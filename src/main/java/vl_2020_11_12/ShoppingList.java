package vl_2020_11_12;

import java.util.HashMap;

public class ShoppingList {
    private HashMap<String, Integer> shoppingList;

    public static void main(String[] args) {
        ShoppingList app = new ShoppingList();
        app.fillInitial();
        app.printAll();
    }

    public ShoppingList() {
        shoppingList = new HashMap<>();
    }

    public void fillInitial() {
        shoppingList.put("Oregano", 10);
        shoppingList.put("Koreander", 0);
        shoppingList.put("Mehl", 4);
        shoppingList.put("Wasabi à la Wabi-Sabi", 1);
        shoppingList.put("Bunte Smarties", 42);
    }

    public void printAll() {
        for (String key : shoppingList.keySet()) {
            Integer amount = shoppingList.get(key);
            if(amount == 0) {
                System.out.println("Kein " + key + ", wer mag schon sowas.");
            } else {
                System.out.printf("Kaufe " + amount + " Stück von " + key + "\n");
            }
        }
    }
}
