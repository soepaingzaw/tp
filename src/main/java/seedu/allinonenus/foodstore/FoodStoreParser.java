package seedu.allinonenus.foodstore;

public class FoodStoreParser {

    private static final String INVALID_ADD_MESSAGE = "Please enter the add command in correct format.";
    private static final String OUT_OF_BOUNDS_MESSAGE = "Sorry, the number you inputted is out of bounds.";

    public static FoodStore parseAddCommand(String input) throws FoodExceptions {
        input = input.replace("add ", "");
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

    public static int parseDeleteCommand(String input, int listSize) throws FoodExceptions {
        input = input.replace("delete ", "");
        input = input.trim();
        int index = Integer.parseInt(input) - 1;
        boolean isEmpty = input.isEmpty();
        boolean validIndex = index < listSize;
        boolean validInput = !isEmpty && validIndex;
        if (!validInput) {
            throw new FoodExceptions(OUT_OF_BOUNDS_MESSAGE);
        } else {
            return index;
        }
    }
}
