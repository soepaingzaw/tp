package seedu.duke.moduleplanner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ModulePlanner {
    protected static String moduleCode;
    protected static ArrayList<Student> students;
    protected static int totalSlots;


    public ModulePlanner(String moduleCode, int totalSlots) {
        ModulePlanner.moduleCode = moduleCode;
        ModulePlanner.totalSlots = totalSlots;
        students = new ArrayList<>();

    }

    public static String getModuleCode() {
        return moduleCode;
    }

    public static int getTotalSlots() {
        return totalSlots;
    }

    public static void getStudent() {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(i + 1 + ". " + students.get(i).toString() + "\n");
        }
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void findStudent(ArrayList<Student> students, String line) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(line)) {
                System.out.println("The number of students have higher priority than " + line + ": " + i + "\n");
                System.out.println("Chances for " + line + ": " + getChances(i + 1, getTotalSlots()) + "\n");
            }
        }
    }

    public static Priority getChances(int position, int slots) {
        if (position < slots / 2) {
            return Priority.HIGH;
        } else if (position < slots && slots / 2 < position) {
            return Priority.MEDIUM;
        } else {
            return Priority.LOW;
        }
    }

    public static void main(String[] args) throws IOException {
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
                    Storage.createFile();
                    Storage.readFile(students);
                } catch (StringIndexOutOfBoundsException | FileNotFoundException e) {
                    Ui.showEmptyDescriptionException(line);
                }
            } else if (line.startsWith("student")) {
                try {
                    line = line.replace("student", "");
                    String[] parts = line.split("/");
                    Student a = new Student(parts[0].trim(),
                            Parser.parserToInteger(parts[1].trim()),
                            Parser.parserToBoolean(parts[2].trim()),
                            Parser.parserToInteger(parts[3].trim()));
                    addStudent(a);
                    System.out.println(a.getName() + "has been added.");
                } catch (java.lang.StringIndexOutOfBoundsException e) {
                    Ui.showEmptyDescriptionException(line);
                }
            } else if (line.equals("list")) {
                Collections.sort(students, Collections.reverseOrder());
                getStudent();
            } else if (line.startsWith("recommendation")) {
                line = line.replace("recommendation", "").trim();
                findStudent(students, line);
            }
            line = in.nextLine();
        }
        Storage.writeFile(students);
    }
}
