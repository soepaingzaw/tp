package seedu.allinonenus.capcalculatorclasses;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ModuleStorage {

    public String storageFilePath;
    public int currentSem;
    public int totalSem;

    public ModuleStorage(String storageFilePath) {

        this.storageFilePath = storageFilePath;

    }

    public ArrayList<ModuleData> load() throws FileNotFoundException {

        ArrayList<ModuleData> moduleList = new ArrayList<>();
        ModuleData modules;
        File f = new File(storageFilePath);
        Scanner scan = new Scanner(f);
        currentSem = Integer.parseInt(scan.nextLine());
        totalSem = Integer.parseInt(scan.nextLine());

        while (scan.hasNext()) {
            String textString = scan.nextLine();
            String[] textData = textString.split("\\|");
            modules = new ModuleData(textData[0], textData[1], Integer.parseInt(textData[2]),Integer.parseInt(textData[3]));
            moduleList.add(modules);

        }

        return moduleList;
    }

    public int getSem() {
        return currentSem;
    }

    public int getTotalSem() {
        return totalSem;
    }


    public void writeToFile(String storageFilePath, ModuleList moduleList,int sem,int total) throws IOException {
        FileWriter fw = new FileWriter(storageFilePath);
        fw.write(sem + "\n" + total + "\n");
        fw.write(moduleList.printString());
        fw.close();
    }

    public void fileDoesntExist() {
        System.out.print("File is not present. Creating a new file for you\n");
    }

}



