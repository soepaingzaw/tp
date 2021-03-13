package seedu.duke.moduleplanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ModulePlanner {
    protected static String moduleCode;
    protected static ArrayList<Student> Students;
    protected static int totalSlots;


    public ModulePlanner(String moduleCode, int totalSlots) {
        ModulePlanner.moduleCode = moduleCode;
        ModulePlanner.totalSlots = totalSlots;
        Students = new ArrayList<>();

    }

    public static String getModuleCode() {
        return moduleCode;
    }

    public static int getTotalSlots() {
        return totalSlots;
    }

    public static void getStudent() {
        for (int i = 0; i < Students.size(); i++) {
            System.out.println(i + 1 + ". " + Students.get(i).toString() + "\n");
        }
    }

    public static void addStudent(Student student) {
        Students.add(student);
    }

    public static void findStudent(ArrayList<Student> Students, String line) {
        for (int i = 0; i < Students.size(); i++) {
            if (Students.get(i).getName().equals(line))
                System.out.println("The number of students have higher priority than " + line + ": " + i + "\n");
        }
    }

    public static void main(String[] args) {
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while (!line.equals("bye")) {
            if (line.startsWith("module")) {
                try {
                    line = line.replace("module", "");
                    String[] parts = line.split("/");
                    ModulePlanner t = new ModulePlanner(parts[0].trim(), Parser.parserToInteger(parts[1].trim()));
                    System.out.println(getModuleCode() + " " + getTotalSlots());
                } catch (java.lang.StringIndexOutOfBoundsException e) {
                    Ui.showEmptyDescriptionException(line);
                }
            } else if (line.startsWith("student")) {
                try {
                    line = line.replace("student", "");
                    String[] parts = line.split("/");
                    Student a = new Student(parts[0].trim(), Parser.parserToInteger(parts[1].trim()), Parser.parserToBoolean(parts[2].trim()), Parser.parserToInteger(parts[3].trim()));
                    addStudent(a);
                    System.out.println(a.getName() + "," + a.getScore());
                } catch (java.lang.StringIndexOutOfBoundsException e) {
                    Ui.showEmptyDescriptionException(line);
                }
            } else if (line.equals("list")) {
                Collections.sort(Students, Collections.reverseOrder());
                getStudent();
            } else if (line.startsWith("recommendation")) {
                line = line.replace("recommendation", "").trim();
                findStudent(Students, line);
            }
            line = in.nextLine();
        }
    }
}
