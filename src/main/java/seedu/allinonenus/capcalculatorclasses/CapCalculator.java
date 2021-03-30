package seedu.allinonenus.capcalculatorclasses;

import seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator.CommandsForCapCalculator;

import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.parserforcapcalculator.ParserForCapCalculator;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

import java.io.FileNotFoundException;


public class CapCalculator {

    private UiText uiText;
    //private static final String filepath = "ModuleStorage.txt";
    //private static ModuleStorage storage = new ModuleStorage(filepath);
   // private MainLogic mainLogic;
    private final ModuleStorage storage;

    private ModuleList moduleList;
    private ParserForCapCalculator parser;

    public CapCalculator() {
        uiText = new UiText();
        parser = new ParserForCapCalculator();
        uiText.greetUser();
        storage = new ModuleStorage();
        try {
            moduleList = new ModuleList(storage.load());

        } catch (FileNotFoundException e) {
            //prepareStorageforNewUser();
            uiText.listManual();

        }

    }
/*
    public void prepareStorageforNewUser() {
        uiText.explainStepsForNewUser();
        moduleList = new ModuleList();
        currentSem = moduleList.computeSem(uiText.readCommand());
        totalSem = currentSem;

    }
*/
    public void run() {
        String fullCommand = null;
        boolean Exit = false;

        while(!Exit) {
            fullCommand = uiText.readCommand();
            uiText.separationLine();
            CommandsForCapCalculator command = parser.parse(fullCommand);
            command.executeCommand(moduleList, storage, uiText,fullCommand);
            Exit = command.isExit();
        }

    }

}
