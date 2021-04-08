package seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator;

public class EmptyLineException extends Exception{
    public EmptyLineException() {
        super("Empty line entered please rety:\n");
    }
}
