package ModulePlanner;

import java.util.ArrayList;
import java.util.Scanner;

public class ModulePlanner {
    protected String moduleCode;
    protected ArrayList<Student> Module;
    protected int totalSlots;

    public ModulePlanner(String moduleCode, int totalSlots) {
        this.moduleCode = moduleCode;
        this.totalSlots = totalSlots;
        this.Module = new ArrayList<>();
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public int getTotalSlots() {
        return totalSlots;
    }
}
