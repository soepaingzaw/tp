package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

import java.io.FileNotFoundException;
import java.io.IOException;


public class ChangeSemesterViewCommand extends CommandsForCapCalculator{
    public ChangeSemesterViewCommand() {
        super();

    }

    public void executeCommand(ModuleList moduleList, ModuleStorage storage, UiText uiText, String fullCommand){
        uiText.separationLine();
        //String semINFO = moduleList.printYearAndSem(currentSem);

        System.out.print("What is the semester you want to view?\n"
                + "Enter in the following format: YxSy\n");
        String newSem = uiText.readCommand();
        storage.currentSem = moduleList.computeSem(newSem);
        if (storage.currentSem > storage.totalSem) {
            System.out.print("Please update your student status before proceeding\n");
        }

        System.out.print("You are currently viewing in " + newSem + "\n");
        saveToStorage(storage,moduleList);
    }

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

    public boolean isExit(){
        return exit;
    }
}
