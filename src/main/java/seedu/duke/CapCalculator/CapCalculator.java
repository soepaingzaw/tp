package seedu.duke.CapCalculator;

public class CapCalculator {


    protected String moduleCode;
    protected String grade;
    protected int MCs;

    public CapCalculator(String moduleCode, String grade, int MCs) {
        this.moduleCode = moduleCode;
        this.grade = grade;
        this.MCs = MCs;

    }

    public void gradeChange(String newGrade) {
        this.grade = newGrade;
    }


    public String toString() {
        return "[" + moduleCode + "] " + "[" + grade + "] "
                + "[" + MCs + "]\n";
    }


}
