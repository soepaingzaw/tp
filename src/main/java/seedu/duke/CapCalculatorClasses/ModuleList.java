package seedu.duke.CapCalculatorClasses;

import java.util.ArrayList;

public class ModuleList {
    protected ArrayList<ModuleData> moduleList = new ArrayList<>();

    public ModuleList() {

    }

    public void add(ModuleData moduleData) {
        moduleList.add(moduleData);
    }

    public int size() {
        return moduleList.size();
    }

    public ModuleData get(int index) {
        return moduleList.get(index);
    }

    public void delete(String moduleName) {

        for (int i = 0; i < moduleList.size(); i++) {
            String moduleToRemove = moduleList.get(i).moduleCode;
            if (moduleToRemove.equals(moduleName)) {
                moduleList.remove(moduleList.get(i));
            }
        }

    }

    public int edit(String moduleName, String newGrade) {
        int i;
        for (i = 0; i < moduleList.size(); i++) {
            String moduleToEdit = moduleList.get(i).moduleCode;
            if (moduleToEdit.equals(moduleName)) {
                moduleList.get(i).gradeChange(newGrade);
                break;
            }
        }
        return i;

    }

    public double calculate() {
        double CAP;
        int summationOfMCs = 0;
        double summationOfGradeTimesMCs = 0.0;
        boolean isNotSUmod;
        boolean isNotPassFailMod;
        String score;

        for (ModuleData capCalculator : moduleList) {
            score = capCalculator.grade;
            summationOfGradeTimesMCs += gradesToPoints(score) * capCalculator.MCs;

            isNotSUmod = !score.equals("S") && !score.equals("U");
            isNotPassFailMod = !score.equals("CS") && !score.equals("CU");

            if (isNotPassFailMod && isNotSUmod) {
                summationOfMCs += capCalculator.MCs;
            }
        }

        CAP = summationOfGradeTimesMCs / summationOfMCs;

        return CAP;
    }

    public double gradesToPoints(String letterGrade) {
        double Points;

        switch (letterGrade) {
        case "A+":
        case "A":
            Points = 5.0;
            break;
        case "A-":
            Points = 4.5;
            break;
        case "B+":
            Points = 4.0;
            break;
        case "B":
            Points = 3.5;
            break;
        case "B-":
            Points = 3.0;
            break;
        case "C+":
            Points = 2.5;
            break;
        case "C":
            Points = 2.0;
            break;
        case "D+":
            Points = 1.5;
            break;
        case "D":
            Points = 1.0;
            break;
        default:
            Points = 0.0;
            break;
        }

        return Points;
    }

    public String toString() {

        return moduleList.toString();
    }


}
