package seedu.allinonenus.capcalculatorclasses.uiforcapcalculator;

import java.util.Scanner;

public class UiText {

    public static final int SEPARATOR_LENGTH = 72;
    private static final String SEPARATOR = "-".repeat(SEPARATOR_LENGTH);
    private final Scanner in;

    public UiText() {
        in = new Scanner(System.in);

    }

    public String readCommand() {
        return in.nextLine();
    }

    public void greetUser() {
        System.out.print("Welcome to All-In-One-NUS Cap Calculator\n");
        System.out.print("Type \"help\" should you require assistance\n");
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
                + "   e.g. edit CS1231\n"
                + "        A+\n"
                + "_______________________________________________\n"
                + "5. [calculate] - calculates your current semester's CAP\n"
                + "   Format: calculate\n"
                + "_______________________________________________\n"
                + "6. [help] - lists out all options available\n"
                + "_______________________________________________\n");

    }

    public void separationLine() {
        System.out.print(SEPARATOR + "\n");
    }

    public void explainStepsForNewUser() {

        System.out.print("Please enter your year and semester\n"
                + "For instance, if you are a year 2 semester 1 student, "
                + "type: Y2S1\n");
    }

    public void printExitMessage() {
        System.out.print("Exiting CAP Calculator\n\n");
        separationLine();
    }

    public void printModuleDataHeading() {
        System.out.print("[MODULES] [GRADEs] [MCs]\n");
    }

    public void warnUserOfEmptySemester() {
        System.out.print("There are no modules added in this semester yet\n");
    }

    public void printModuleData(String moduleCode, String grade, int mcs) {
        System.out.printf("[%-7s]   [%-2s]    [%1d]%n", moduleCode, grade, mcs);
    }

    public void printCurrentSemCap(double currCap) {
        System.out.printf("CAP for this semester is %.2f\n", currCap);
    }

    public void printOverallCap(double overallCap) {
        System.out.printf("Overall CAP is: %.2f\n", overallCap);
    }

    public void confirmModuleUpdate(String moduleCode) {
        System.out.print("Added " + moduleCode + "\n");
    }

    public void printStudentProfile(String semInfo) {
        System.out.print("Profile: " + semInfo + " student\n");
    }

    public void promptForCommand() {
        System.out.print("Please enter command: ");
    }

    public void currentSemView(String sem) {
        System.out.print("You are viewing " + sem + "\n");
    }

}
