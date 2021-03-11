package ModulePlanner;

public class Student {
    protected String Name;
    protected boolean graduationRequirement;
    protected int Year;
    protected int Score;
    protected int Rank;



    public Student(String Name, int Year, boolean graduationRequirement, int Rank) {
        this.Name = Name;
        this.graduationRequirement = graduationRequirement;
        this.Year = Year;
        this.Rank = Rank;
        this.Score = getYear() + getGraduationRequirementScore() - (Rank - 6);

    }

    public String getName() {
        return Name;
    }

    public boolean isGraduationRequirement() {
        return graduationRequirement;
    }

    public int getYear() {
        return Year;
    }

    public int getGraduationRequirementScore(){
        return (isGraduationRequirement() ? 0 : 3);
    }

    public int getScore(){
        return Score;
    }

}
