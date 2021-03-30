/*
package seedu.allinonenus.capcalculatorclasses.logicforcapcalculator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainLogic {

    private ModuleList moduleList;

    public MainLogic() {

    }

        while (true) {
            Scanner scan = new Scanner(System.in);
            String input;
            input = scan.nextLine();
            String[] commands = input.split(" ");

            System.out.print(moduleList.printYearAndSem(currentSem) + ":\n");
            uiText.separationLine();

            if (input.length() == 0) {
                break;
            }

            switch (commands[0]) {
            case "list":

                printModuleList();

                break;

            case "show":
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

            case "delete":
                String moduleToDelete = commands[1];
                moduleList.delete(moduleToDelete);
                System.out.print("Deleted " + moduleToDelete + "\n"
                        + "This is your new list:\n");
                printModuleList();

                break;

            case "edit":
                int index;
                String moduleToEdit = commands[1];

                System.out.print("Enter your desired grade:\n");
                String newGrade = scan.nextLine();

                index = moduleList.edit(moduleToEdit, newGrade);

                System.out.print("Edited. New data:\n" + moduleList.get(index)
                        + "This is your new list:\n");
                printModuleList();

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

                System.out.print("Added " + modules.moduleCode + "\n"
                        + "This is you new list:\n");
                printModuleList();
                break;

            case "goal":
                double goalCAP = Double.parseDouble(commands[1]);
                double suggestedGrade = moduleList.suggest(currentSem, goalCAP);

                System.out.printf("You should aim to get a CAP of %.2f for your graded modules this semester\n"
                        + "in order to get an overall CAP of %.2f\n", suggestedGrade, goalCAP);
                break;

            case "help":
                uiText.listManual();
                break;

            case "update":
                currentSem = moduleList.computeSem(commands[1]);
                if (totalSem < currentSem) {
                    totalSem = currentSem;
                }

                System.out.print("You are now viewing " + moduleList.printYearAndSem(currentSem) + "\n");
                break;

            default:
                System.out.print("Invalid PLease try again\n");

            }

            try {

                storage.writeToFile(filepath, moduleList, currentSem, totalSem);

            } catch (FileNotFoundException e) {
                storage.fileDoesntExist();
            } catch (IOException e) {
                System.out.print("File Error\n");
            }

        }
        System.out.print("Bye See ya!\n");
    }

}
*/