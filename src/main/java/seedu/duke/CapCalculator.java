package seedu.duke;

import seedu.duke.capcalculatorclasses.ModuleList;
import seedu.duke.capcalculatorclasses.ModuleData;
import seedu.duke.capcalculatorclasses.ModuleStorage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class CapCalculator {

    private static final String filepath = "ModuleStorage.txt";
    private static ModuleStorage storage = new ModuleStorage(filepath);
    ModuleList moduleList;


    public static void requestForModule() {
        System.out.print("Welcome to CAP Calculator!\n");
        System.out.print("Press Enter to enter another module. Enter an empty line when you are done\n");
        System.out.print("Please input your modules in the following format:\n");
        System.out.print("[Module Code] [Grade] [MCs]\n");

    }


    public void readModuleInputs() {

        while (true) {
            Scanner scan = new Scanner(System.in);
            String command;
            command = scan.nextLine();

            if (command.length() == 0) {
                break;
            }

            switch (command) {
            case "list":
                System.out.print("[MODULES] [GRADEs] [MCs]\n");
                for (int i = 0; i < moduleList.size(); i++) {
                    System.out.printf("[%-7s]   [%-2s]    [%1d]%n",
                            moduleList.get(i).moduleCode, moduleList.get(i).grade, moduleList.get(i).mcs);
                }
                break;

            case "calculate":
                System.out.printf("%.2f is my CAP\n", moduleList.calculate());
                break;

            case "delete":
                System.out.print("Which module do you want to delete? Enter the module code:\n");
                String moduleToDelete = scan.nextLine();
                moduleList.delete(moduleToDelete);
                System.out.print("Deleted " + moduleToDelete + "\n");
                break;

            case "edit":
                int index;
                System.out.print("Which module do you want to edit? Enter the module code:\n");
                String moduleToEdit = scan.nextLine();

                System.out.print("Enter your desired grade:\n");
                String newGrade = scan.nextLine();

                index = moduleList.edit(moduleToEdit, newGrade);

                System.out.print("Edited. New data:\n" + moduleList.get(index) + "\n");

                break;


            default:
                String[] data = command.split(" ");
                ModuleData modules = new ModuleData(data[0], data[1], Integer.parseInt(data[2]));

                moduleList.add(modules);

                System.out.print("Added " + modules.moduleCode + "\n");


            }

            try {

                storage.writeToFile(filepath, moduleList);

            } catch (FileNotFoundException e) {
                storage.fileDoesntExist();
            } catch (IOException e) {
                System.out.print("File Error\n");
            }

        }
        System.out.print("Bye See ya!\n");
    }

    public CapCalculator() {
        requestForModule();
        storage = new ModuleStorage(filepath);
        try {
            moduleList = new ModuleList(storage.load());
        } catch (FileNotFoundException e) {
            System.out.print("Creating new storage for you\n");
            moduleList = new ModuleList();
        }

    }

    public void run() {
        readModuleInputs();

    }

    public static void main(String[] args) {

        new CapCalculator().run();
    }

}
