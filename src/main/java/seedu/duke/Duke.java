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
            String line;
            line = scan.nextLine();
            if (line.length() == 0) {
                break;
            } else if (line.equals("list")) {
                for (int i = 0; i < moduleList.size(); i++) {
                    System.out.print(moduleList.get(i).toString());
                }
            } else {
                String[] data = line.split(" ");
                CapCalculator modules = new CapCalculator(data[0], data[1], Integer.parseInt(data[2]));

                moduleList.add(modules);

            }

        }
        System.out.print("Bye See ya!\n");
    }


}
