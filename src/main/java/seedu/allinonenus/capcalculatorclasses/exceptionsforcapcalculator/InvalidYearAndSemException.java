package seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator;

public class InvalidYearAndSemException extends Exception {
    public InvalidYearAndSemException() {
        super("_______________________________________________\n"
                + "Incorrect input! Please enter the correct inputs again:\n");
    }

}
