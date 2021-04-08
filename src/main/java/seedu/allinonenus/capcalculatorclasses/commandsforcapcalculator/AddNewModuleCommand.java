package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AddNewModuleCommand extends CommandsForCapCalculator {

    private final static Logger logr = Logger.getLogger(AddNewModuleCommand.class.getName());

    public AddNewModuleCommand() {
        super();
    }

    /**
     * @param moduleList
     * @param storage
     * @param uiText
     * @param fullCommand
     */
    public void executeCommand(ModuleList moduleList, ModuleStorage storage, UiText uiText, String fullCommand) {

        logr.log(Level.FINE, "Add Command Log\n");

        String[] moduleInfo = fullCommand.split(" ");
        int currentSem = storage.getSem();
        ModuleData modules = new ModuleData(moduleInfo[1], moduleInfo[2], Integer.parseInt(moduleInfo[3]), currentSem);
        moduleList.add(modules);
        uiText.confirmModuleUpdate(modules.moduleCode);
        saveToStorage(storage, moduleList);
        uiText.separationLine();
    }

    /**
     * @param storage
     * @param moduleList
     */
    public void saveToStorage(ModuleStorage storage, ModuleList moduleList) {
        int currentSem = storage.currentSem;
        int totalSem = storage.totalSem;
        try {
            storage.writeToFile(moduleList, currentSem, totalSem);
        } catch (FileNotFoundException e) {
            storage.fileDoesntExist();
        } catch (IOException e) {
            System.out.print("File Error\n");
        }
    }


    public boolean isExit() {
        return exit;
    }
}
