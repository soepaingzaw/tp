package seedu.allinonenus.foodstore;

public class FoodStoreParser {

    private static final String INVALID_ADD_MESSAGE = "Please enter the command in the correct format: " +
            "add [Store name] d/[Store description]";
    private static final String OUT_OF_BOUNDS_MESSAGE = "Sorry, the number you inputted is out of bounds." +
            "Please use the list command to check the store index.";
    private static final String INVALID_HALAL_MESSAGE = "Please enter the command in the correct format: " +
            "halal [Store index]";
    private static final String INVALID_FIND_MESSAGE = "Please enter the command in the correct format: " +
            "find [keyword]";

    public FoodStore parseAddCommand(String input, int locationIndex) throws FoodExceptions {
        input = input.replace("add ", "");
        input = input.trim();
        boolean hasStoreName = !input.isEmpty();
        boolean hasDescription = input.contains("d/");
        boolean validInput = hasDescription && hasStoreName;
        if (!validInput) {
            throw new FoodExceptions(INVALID_ADD_MESSAGE);
        } else {
            String[] inputArguments = input.split("d/");
            String storeName = inputArguments[0];
            String storeDescription = inputArguments[1];
            switch (locationIndex) {
            case 1:
                return new FrontierStore(storeName,storeDescription);
            case 2:
                return new DeckStore(storeName,storeDescription);
            case 3:
                return new UTownStore(storeName,storeDescription);
            case 4:
                return new TechnoStore(storeName,storeDescription);
            }
        }
        return null;
    }

    public int parseDeleteCommand(String input, int listSize) throws FoodExceptions {
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

    public int parseHalalCommand(String input, int listSize) throws FoodExceptions {
        input = input.replace("halal ", "");
        input = input.trim();
        boolean isEmpty = input.isEmpty();
        if (isEmpty) {
            throw new FoodExceptions(INVALID_HALAL_MESSAGE);
        } else {
            int index = Integer.parseInt(input) - 1;
            boolean validIndex = index < listSize;
            if (!validIndex) {
                throw new FoodExceptions(OUT_OF_BOUNDS_MESSAGE);
            }
            else {
                return index;
            }
        }
    }

    public String parseFindCommand(String input) throws FoodExceptions {
        input = input.replace("find ", "");
        input = input.trim();
        boolean isEmpty = input.isEmpty();
        if (isEmpty) {
            throw new FoodExceptions(INVALID_FIND_MESSAGE);
        } else {
            return input;
        }
    }

}
