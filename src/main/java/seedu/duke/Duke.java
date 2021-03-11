package seedu.duke;

import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        requestForModule();
        readModuleInputs();
    }

    public static void requestForModule() {
        System.out.print("Welcome to CAP Calculator!\n");
        System.out.print("Press Enter to enter another module. Enter an empty line when you are done\n");
        System.out.print("Please input your modules in the following format:\n");
        System.out.print("[Module Code] [Grade] [MCs]\n");

    }

    public static void readModuleInputs() {
        ModuleList moduleList = new ModuleList();

        while (true) {
            Scanner scan = new Scanner(System.in);
            String command;
            command = scan.nextLine();

            if (command.length() == 0) {
                break;
            }

            switch (command) {
            case "list":
                for (int i = 0; i < moduleList.size(); i++) {
                    System.out.print(moduleList.get(i).toString());
                }
                break;

            case "calculate":
                System.out.printf("%.2f is my CAP\n",moduleList.calculate());
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

                index = moduleList.edit(moduleToEdit,newGrade);

                System.out.print("Edited. New data:\n" + moduleList.get(index) + "\n");

                break;

            default:
                String[] data = command.split(" ");
                CapCalculator modules = new CapCalculator(data[0], data[1], Integer.parseInt(data[2]));

                moduleList.add(modules);

                System.out.print("Added " + modules.moduleCode + "\n");

            }

        }
        System.out.print("Bye See ya!\n");
    }


}
