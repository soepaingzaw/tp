package ModulePlanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ModulePlanner {
    protected static String moduleCode;
    protected static ArrayList<Student> Students;
    protected static int totalSlots;


    public ModulePlanner(String moduleCode, int totalSlots) {
        this.moduleCode = moduleCode;
        this.totalSlots = totalSlots;
        this.Students = new ArrayList<>();

    }

    public static String getModuleCode() {
        return moduleCode;
    }

    public static int getTotalSlots() {
        return totalSlots;
    }

    public static void getStudent() {
        for (int i = 0; i < Students.size(); i++){
            System.out.println(i+1 + ". " + Students.get(i).toString() + "\n");
        }
    }

    public static void addStudent(Student student){
        Students.add(student);
    }


    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while (!line.equals("bye")) {
                if (line.startsWith("module")) {
                    try {
                        line.substring(line.indexOf(" "));
                        line = line.replace("module", "");
                        String[] parts = line.split("/");
                        ModulePlanner t = new ModulePlanner(parts[0].trim(), Parser.parserToInteger(parts[1].trim()));
                        System.out.println(getModuleCode() + " " + getTotalSlots());
                    } catch (java.lang.StringIndexOutOfBoundsException e) {
                        Ui.showEmptyDescriptionException(line);
                    }
                }
                else if (line.startsWith("student")) {
                    try {
                        line.substring(line.indexOf(" "));
                        line = line.replace("student", "");
                        String[] parts = line.split("/");
                        Student a = new Student(parts[0].trim(), Parser.parserToInteger(parts[1].trim()), Parser.parserToBoolean(parts[2].trim()), Parser.parserToInteger(parts[3].trim()));
                        addStudent(a);
                        System.out.println(a.getName() + "," + a.getScore());
                    } catch (java.lang.StringIndexOutOfBoundsException e) {
                        Ui.showEmptyDescriptionException(line);
                    }
                }
                else if(line.equals("list")){
                    Collections.sort(Students);
                    getStudent();
                }

                line = in.nextLine();
            }


    }
}
