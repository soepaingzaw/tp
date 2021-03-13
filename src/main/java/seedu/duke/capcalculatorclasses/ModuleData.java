package seedu.duke.capcalculatorclasses;

public class ModuleData {


    public String moduleCode;
    public String grade;
    public int mcs;

    public ModuleData(String moduleCode, String grade, int mcs) {
        this.moduleCode = moduleCode;
        this.grade = grade;
        this.mcs = mcs;

    }

    public void gradeChange(String newGrade) {
        this.grade = newGrade;
    }


    public String toString() {
        return "[" + moduleCode + "] " + "[" + grade + "] "
                + "[" + mcs + "]\n";
    }

    public String fileFormat() {
        return moduleCode + "|" + grade + "|" + mcs + "\n";
    }


}
