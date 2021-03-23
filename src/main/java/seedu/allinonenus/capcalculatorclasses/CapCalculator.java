package seedu.allinonenus.capcalculatorclasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class CapCalculator {

    private static final String filepath = "ModuleStorage.txt";
    private static ModuleStorage storage = new ModuleStorage(filepath);
    static int currentSem, totalSem;
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
                System.out.print("Modules for " + moduleList.printYearAndSem(currentSem) +"\n");
                System.out.print("[MODULES] [GRADEs] [MCs]\n");
                for (int i = 0; i < moduleList.size(); i++) {

                    if(moduleList.get(i).sem == currentSem) {

                        System.out.printf("[%-7s]   [%-2s]    [%1d]%n",
                                moduleList.get(i).moduleCode, moduleList.get(i).grade, moduleList.get(i).mcs);
                    }
                }
                break;

            case "show all":
                int currentSemIndex=1;
                while(currentSemIndex<=totalSem) {

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
            case "change":
                System.out.print("What is the current semester you want to view?\n");
                String newSem = scan.nextLine();
                currentSem = moduleList.computeSem(newSem);
                if (currentSem>totalSem) {
                    totalSem = currentSem;
                }

                break;


            default:
                String[] data = command.split(" ");
                ModuleData modules = new ModuleData(data[0], data[1], Integer.parseInt(data[2]),currentSem);

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
        //assert false : "Cap Calculator assertion";
        requestForModule();
        storage = new ModuleStorage(filepath);
        try {
            moduleList = new ModuleList(storage.load());
        } catch (FileNotFoundException e) {
            System.out.print("Creating new storage for you\n");
            System.out.print("Please enter your year and semester\n"
                + "(E.g. if you are in your second year and it is currently your"
                   + "first semester type: Y2S1\n" );

            Scanner scan = new Scanner(System.in);

            moduleList = new ModuleList();
            currentSem = moduleList.computeSem(scan.nextLine());
            totalSem = currentSem;
        }

    }

    public void run() {
        readModuleInputs();

    }

}
