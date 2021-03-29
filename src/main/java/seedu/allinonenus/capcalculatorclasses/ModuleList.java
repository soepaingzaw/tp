package seedu.allinonenus.capcalculatorclasses;

import java.util.ArrayList;

public class ModuleList {
    protected ArrayList<ModuleData> moduleList = new ArrayList<>();

    public ModuleList() {

    }

    public ModuleList(ArrayList<ModuleData> moduleList) {
        this.moduleList = moduleList;
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


    public int totalMcs(int startSem, int endSem) {
        boolean isNotSUmod;
        boolean isNotPassFailMod;
        String score;
        int summationOfMCs = 0;
        for (int i = 0; i < moduleList.size(); i++) {
            if (moduleList.get(i).sem >= startSem && moduleList.get(i).sem <= endSem) {

                score = moduleList.get(i).grade;

                isNotSUmod = !score.equals("S") && !score.equals("U");
                isNotPassFailMod = !score.equals("CS") && !score.equals("CU");

                if (isNotPassFailMod && isNotSUmod) {
                    summationOfMCs += moduleList.get(i).mcs;
                }
            }

        }
        return summationOfMCs;
    }

    public double totalMcsTimesGrade(int beginSem, int finalSem) {
        double summationOfMCsTimesGrade = 0.0;
        String score;
        for (int j = 0; j < moduleList.size(); j++) {
            if (moduleList.get(j).sem >= beginSem && moduleList.get(j).sem <= finalSem) {
                score = moduleList.get(j).grade;
                summationOfMCsTimesGrade += gradesToPoints(score) * moduleList.get(j).mcs;
            }
        }
        return summationOfMCsTimesGrade;
    }

    public double calculate(int start,int end) {
        return totalMcsTimesGrade(start,end)/totalMcs(start,end);

    }




    public double suggest(int currentSem, double desiredGrade) {

        return (desiredGrade * (totalMcs(1,currentSem))-totalMcsTimesGrade(1,currentSem-1))
                /totalMcs(currentSem,currentSem);
    }



    public double gradesToPoints(String letterGrade) {
        double points;

        switch (letterGrade) {
        case "A+":
        case "A":
            points = 5.0;
            break;
        case "A-":
            points = 4.5;
            break;
        case "B+":
            points = 4.0;
            break;
        case "B":
            points = 3.5;
            break;
        case "B-":
            points = 3.0;
            break;
        case "C+":
            points = 2.5;
            break;
        case "C":
            points = 2.0;
            break;
        case "D+":
            points = 1.5;
            break;
        case "D":
            points = 1.0;
            break;
        default:
            points = 0.0;
            break;
        }

        return points;
    }

    public int computeSem(String yearAndSem) {

        int year;
        int sem;

        year = Character.getNumericValue(yearAndSem.charAt(1));
        sem = Character.getNumericValue(yearAndSem.charAt(3));

        return year * 2 - (2 - sem);

    }

    public String printYearAndSem(int sem) {
        int year = (sem + 1) / 2;
        int semester = 2 - sem % 2;

        return "Year " + year + " Semester " + semester;

    }

    public String printString() {
        StringBuilder list = new StringBuilder();

        for (ModuleData moduleData : moduleList) {
            list.append(moduleData.fileFormat());
        }
        return list.toString();
    }


}
