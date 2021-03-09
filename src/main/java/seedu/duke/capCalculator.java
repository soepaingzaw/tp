package seedu.duke;

public class capCalculator {


    protected String moduleCode;
    protected String grade;
    protected int MCs;

    public capCalculator(String moduleCode,String grade, int MCs) {
        this.moduleCode = moduleCode;
        this.grade = grade;
        this.MCs = MCs;

    }


    public String toString() {
        return "[" + moduleCode + "] " + "[" + grade + "] "
                + "[" + MCs +"]\n";
    }

}
