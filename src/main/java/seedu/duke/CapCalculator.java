package seedu.duke;

public class CapCalculator {


    protected String moduleCode;
    protected String grade;
    protected int MCs;

    public CapCalculator(String moduleCode,String grade, int MCs) {
        this.moduleCode = moduleCode;
        this.grade = grade;
        this.MCs = MCs;

    }

    public double calculate(ModuleList moduleList) {
        double CAP = 0;
        String score;
        for(int i=0;i< moduleList.size();i++) {
            score = moduleList.get(i).grade;
            CAP += gradesToPoints(score);

        }

        CAP /= moduleList.size();

        return CAP;
    }

    public String toString() {
        return "[" + moduleCode + "] " + "[" + grade + "] "
                + "[" + MCs +"]\n";
    }

    public double gradesToPoints(String letterGrade) {
        double Points = 0.0;

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
            Points = 0.0;
            break;
        default:
            Points = 2.0;
            break;

        }


        return Points;
    }

}
