package seedu.duke.moduleplanner;

public class Ui {

    public static void showException() {
        System.out.println("____________________________________________________________\n");
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
        System.out.println("____________________________________________________________\n");
    }

    public static void showEmptyDescriptionException(String line) {
        System.out.println("____________________________________________________________\n");
        System.out.println("☹ OOPS!!! The description of a " + line + " cannot be empty.\n");
        System.out.println("____________________________________________________________\n");
    }
}
