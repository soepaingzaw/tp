package seedu.allinonenus.capcalculatorclasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class CapCalculator {

    private static final String filepath = "ModuleStorage.txt";
    private static ModuleStorage storage = new ModuleStorage(filepath);
    static int currentSem, totalSem;
    ModuleList moduleList;

    public void readModuleInputs() {

        while (true) {
            Scanner scan = new Scanner(System.in);
            String input;
            input = scan.nextLine();
            String [] commands = input.split(" ");

            System.out.print("You are currently viewing: " + moduleList.printYearAndSem(currentSem) + "\n");


            if (input.length() == 0) {
                break;
            }

            switch (commands[0]) {
            case "list":
                System.out.print("Modules for " + moduleList.printYearAndSem(currentSem) + "\n");
                System.out.print("[MODULES] [GRADEs] [MCs]\n");
                for (int i = 0; i < moduleList.size(); i++) {

                    if (moduleList.get(i).sem == currentSem) {

                        System.out.printf("[%-7s]   [%-2s]    [%1d]%n",
                                moduleList.get(i).moduleCode, moduleList.get(i).grade, moduleList.get(i).mcs);
                    }
                }
                break;

            case "show all":
                int currentSemIndex = 1;
                while (currentSemIndex <= totalSem) {

                    System.out.print("Modules for " + moduleList.printYearAndSem(currentSemIndex) + ":\n");
                    System.out.print("[MODULES] [GRADEs] [MCs]\n");
                    for (int i = 0; i < moduleList.size(); i++) {

                        if (moduleList.get(i).sem == currentSemIndex) {

                            System.out.printf("[%-7s]   [%-2s]    [%1d]%n",
                                    moduleList.get(i).moduleCode, moduleList.get(i).grade, moduleList.get(i).mcs);
                        }

                    }
                    System.out.print("\n");

                    currentSemIndex++;
                }
                break;

            case "calculate":
                System.out.printf("My CAP is %.2f\n", moduleList.calculate());
                break;

            case "delete":
                String moduleToDelete = commands[1];
                moduleList.delete(moduleToDelete);
                System.out.print("Deleted " + moduleToDelete + "\n");
                break;

            case "edit":
                int index;
                String moduleToEdit = commands[1];

                System.out.print("Enter your desired grade:\n");
                String newGrade = scan.nextLine();

                index = moduleList.edit(moduleToEdit, newGrade);

                System.out.print("Edited. New data:\n" + moduleList.get(index) + "\n");

                break;
            case "view":
                System.out.print("What is the semester you want to view?\n"
                        + "Enter in the following format: YxSy\n");
                String newSem = scan.nextLine();
                currentSem = moduleList.computeSem(newSem);
                if (currentSem > totalSem) {
                    totalSem = currentSem;
                }

                System.out.print("You are currently viewing in " + newSem + "\n");

                break;

            case "add":
                ModuleData modules = new ModuleData(commands[1], commands[2], Integer.parseInt(commands[3]), currentSem);
                moduleList.add(modules);

                System.out.print("Added " + modules.moduleCode + "\n");
                break;

            case "help":
                listManual();
                break;

            default:
               System.out.print("Invalid PLease try again\n");

            }

            try {

                storage.writeToFile(filepath, moduleList,currentSem);

            } catch (FileNotFoundException e) {
                storage.fileDoesntExist();
            } catch (IOException e) {
                System.out.print("File Error\n");
            }

        }
        System.out.print("Bye See ya!\n");
    }

    public CapCalculator() {
        //assert false : "Cap Calculator assertion";
        greetUser();
        storage = new ModuleStorage(filepath);
        try {
            moduleList = new ModuleList(storage.load());
            currentSem = storage.getSem();
        } catch (FileNotFoundException e) {
            prepareStorageforNewUser();
        }

    }

    public void prepareStorageforNewUser() {
        System.out.print("Please enter your year and semester\n"
                + "E.g. if you are in your second year and it is currently your"
                + "first semester type: Y2S1\n");

        Scanner scan = new Scanner(System.in);

        moduleList = new ModuleList();
        currentSem = moduleList.computeSem(scan.nextLine());
        totalSem = currentSem;
    }

    public void greetUser() {
        System.out.print("Welcome to All-In-One-NUS Cap Calculator\n");

    }

    public void listManual() {
        System.out.print("Here are the list of commands available :\n"
                + "_______________________________________________\n"
                + "1. [add] - adds your module data\n"
                + "   Format: add [Module Code] [Grade] [MCs]\n"
                + "   e.g. add CS1231 A- 4\n"
                + "_______________________________________________\n"
                + "2. [delete] - delete specified module data\n"
                + "   Format: delete [Module Code]\n"
                + "   e.g. delete CS1231\n"
                + "_______________________________________________\n"
                + "3. [list] - lists your current semester's module data\n"
                + "   Format: list\n"
                + "_______________________________________________\n"
                + "4. [edit] - make edits to your module data\n"
                + "   Format: 1. edit [Module code]\n"
                + "           2. [new grade]\n"
                + "_______________________________________________\n"
                + "5. [calculate] - calculates your current semester's CAP\n"
                + "   Format: calculate\n"
                + "_______________________________________________\n"
                + "6. [help] - lists out all options available\n"
                + "_______________________________________________\n");

    }

    public void run() {
        listManual();
        readModuleInputs();

    }

}
