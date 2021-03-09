package seedu.duke;

import java.util.ArrayList;

public class ModuleList {
    protected ArrayList<CapCalculator> moduleList = new ArrayList<>();

    public ModuleList(ArrayList<CapCalculator> moduleList) {
        this.moduleList = moduleList;

    }

    public ModuleList() {

    }

    public void add(CapCalculator moduleData) {
        moduleList.add(moduleData);
    }

    public int size() {
        return moduleList.size();
    }

    public CapCalculator get(int index) {
        return moduleList.get(index);
    }




}
