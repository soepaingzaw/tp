package seedu.duke.moduleplanner;

public class Ui {

    /***
     * Shows an error message when the task type is not recognised.
     */

    public static void showException() {
        System.out.println("____________________________________________________________\n");
        System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
        System.out.println("____________________________________________________________\n");
    }

    /***
     * Shows an error message when the description of the task is empty.
     * @param line Task type.
     */
    public static void showEmptyDescriptionException(String line) {
        System.out.println("____________________________________________________________\n");
        System.out.println("☹ OOPS!!! The description of a " + line + " cannot be empty.\n");
        System.out.println("____________________________________________________________\n");
    }
}
