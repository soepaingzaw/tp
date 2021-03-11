package seedu.duke;

import seedu.duke.foodstore.FoodStore;

import java.util.ArrayList;
import java.util.List;

public class FoodRecommendation {

    private static final String UNABLE_TO_FIND_MESSAGE = "Sorry, We are unable to find any food stores that fit the description";

    private final List<FoodStore> foodStoreList = new ArrayList<>();

    public FoodRecommendation(){

    }

    public void add(FoodStore toAdd) {
        foodStoreList.add(toAdd);
    }

    public void printStore(FoodStore toPrint) {
        System.out.println(toPrint.toString());
    }

    public void printList() {
        for (FoodStore foodStore : foodStoreList) {
            printStore(foodStore);
        }
    }

    public void delete(FoodStore toRemove) {
        foodStoreList.remove(toRemove);
    }

    public void clearList() {
        foodStoreList.clear();
    }

    public void find(FoodStore toFind) {
        if (foodStoreList.contains(toFind)) {
            printStore(toFind);
        } else {
            System.out.println(UNABLE_TO_FIND_MESSAGE);
        }
    }
}
