package seedu.duke.foodstore;

import seedu.duke.foodstore.FoodStore;
import seedu.duke.foodstore.FoodExceptions;

public class FoodStoreParser {

    private static final String INVALID_ADD_MESSAGE = "Please enter the add command in correct format.";

    public static FoodStore parseAddCommand(String input) throws FoodExceptions{
        input = input.replace("add", "");
        input = input.trim();
        boolean hasStoreName = !input.isEmpty();
        boolean hasDescription = input.contains("d/ ");
        boolean validInput = hasDescription && hasStoreName;
        if (!validInput) {
            throw new FoodExceptions(INVALID_ADD_MESSAGE);
        } else {
            String[] inputArguments = input.split("d/ ");
            return new FoodStore(inputArguments[0], inputArguments[1]);
        }
    }
}
