package seedu.duke.CapCalculatorClasses;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ModuleStorage {

    public String storageFilePath;

    public ModuleStorage(String storageFilePath) {

        this.storageFilePath = storageFilePath;

    }
   /*
    public static void loadFromFile(String filepath) throws FileNotFoundException {
        File f = new File(filepath);
        Scanner scan = new Scanner(f);

        while (scan.hasNext()) {
            String textString = scan.nextLine();
            char taskType = textString.charAt(3);
            char doneOrNot = textString.charAt(6);
            int indexOfOpenBracket = textString.indexOf('(');
            int indexOfCloseBracket = textString.indexOf(')');

            switch (taskType) {

            case 'T':
                tasks.add(new Todo(textString.substring(9)));
                break;
            case 'E':
                tasks.add(new Event(textString.substring(9, indexOfOpenBracket),
                        textString.substring(indexOfOpenBracket + 4, indexOfCloseBracket)));
                break;
            case 'D':
                tasks.add(new Deadline(textString.substring(9, indexOfOpenBracket),
                        textString.substring(indexOfOpenBracket + 4, indexOfCloseBracket)));
                break;
            default:
                break;
            }

            if (doneOrNot == '\u2713') {
                tasks.get(index).markAsDone();
            }
            index++;
        }
    }
    */

    public void writeToFile(String storageFilePath,ModuleList moduleList) throws IOException {
        FileWriter fw = new FileWriter(storageFilePath);
        fw.write(moduleList.toString());
        fw.close();
    }

    public void fileDoesntExist() {
        System.out.print("File is not present. Creating a new file for you\n");
    }

}



