package seedu.duke.foodstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FoodStoreStorage {

    private static final String filepath = "Food Recommendation.txt";

    public static void saveFile(ArrayList<FoodStore> foodStores) throws IOException {
        FileWriter fileWriter = new FileWriter(filepath);
        for (FoodStore foodStore : foodStores) {
            fileWriter.write(foodStore.toString() + "\n");
        }
        fileWriter.close();
    }

    public static void loadFile(ArrayList<FoodStore> foodStores) throws FileNotFoundException {
        File file = new File(filepath);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            input = input.substring(input.lastIndexOf("]") + 1);
            String[] inputArguments = input.split(": ");
            FoodStore foodStore = new FoodStore(inputArguments[0], inputArguments[1]);
            foodStores.add(foodStore);
        }
    }

}
