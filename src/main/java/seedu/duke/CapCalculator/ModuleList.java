package seedu.duke.CapCalculator;

import java.util.ArrayList;

public class ModuleList {
    protected ArrayList<CapCalculator> moduleList = new ArrayList<>();

    /*
        public ModuleList(ArrayList<CapCalculator> moduleList) {
            this.moduleList = moduleList;

        }
    */
    public ModuleList() {

    }

    public void add(CapCalculator moduleData) {
        moduleList.add(moduleData);
    }

    public int size() {
        return moduleList.size();
    }

    public void remove(CapCalculator moduleData) {
        moduleList.remove(moduleData);
    }

    public CapCalculator get(int index) {
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
        double CAP = 0;
        int summationOfMCs = 0;
        double summationOfGradeTimesMCs = 0.0;
        boolean isNotSUmod;
        boolean isNotPassFailMod;
        String score;

        for (int i = 0; i < moduleList.size(); i++) {
            score = moduleList.get(i).grade;
            summationOfGradeTimesMCs += gradesToPoints(score) * moduleList.get(i).MCs;

            isNotSUmod = !score.equals("S") && !score.equals("U");
            isNotPassFailMod = !score.equals("CS") && !score.equals("CU");

            if (isNotPassFailMod && isNotSUmod) {
                summationOfMCs += moduleList.get(i).MCs;
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

        case "F":
        case "S":
        case "U":
        case "CS":
        case "CU":
            Points = 0.0;
            break;

        default:
            Points = 0.0;
            break;

        }


        return Points;
    }


}
