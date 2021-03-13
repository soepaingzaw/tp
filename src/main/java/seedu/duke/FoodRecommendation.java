package seedu.duke;

import seedu.duke.foodstore.FoodStore;

import java.util.ArrayList;
import java.util.List;

public class FoodRecommendation {

    private static final String FIND_ERROR_MESSAGE =
            "Sorry, We are unable to find any food stores that fit the description";
    private static final String WELCOME_MESSAGE = "Welcome to Food Recommendation Bot!\n"
            + "Enter help to find out all available commands";
    private static final String AVAILABLE_COMMANDS = "Here are the list of commands: \n"
            + "1. add [store name] [store description] - Adds a new food store\n"
            + "2. list - Prints out all the food stores\n"
            + "3. delete [store index] - Deletes the store with that index";

    private final List<FoodStore> foodStoreList = new ArrayList<>();

    public FoodRecommendation() {

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
            System.out.println(FIND_ERROR_MESSAGE);
        }
    }

    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printAvailableCommands() {
        System.out.println(AVAILABLE_COMMANDS);
    }

    public void run() {
        printWelcomeMessage();
        printAvailableCommands();
    }
}
