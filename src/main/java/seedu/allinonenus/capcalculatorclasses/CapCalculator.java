package seedu.allinonenus.capcalculatorclasses;

import seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator.CommandsForCapCalculator;
import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.parserforcapcalculator.ParserForCapCalculator;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class CapCalculator {

    private final UiText uiText;
    private final ModuleStorage storage;

    private ModuleList moduleList;
    private final ParserForCapCalculator parser;

    public CapCalculator() {
        uiText = new UiText();
        parser = new ParserForCapCalculator();
        uiText.greetUser();
        uiText.separationLine();
        storage = new ModuleStorage();
        try {
            moduleList = new ModuleList(storage.load());

        } catch (NoSuchElementException | FileNotFoundException e) {
            uiText.explainStepsForNewUser();
            moduleList = new ModuleList();
            String studentYearAndSem = uiText.readCommand();
            storage.currentSem = moduleList.computeSem(studentYearAndSem);
            storage.totalSem = storage.currentSem;
            uiText.listManual();

        }

    }

    public void run() {
        String fullCommand;
        boolean Exit = false;

        while (!Exit) {
            int sem = storage.currentSem;
            String studentProfile = moduleList.printYearAndSem(sem);
            uiText.printStudentProfile(studentProfile);
            uiText.promptForCommand();
            fullCommand = uiText.readCommand();
            uiText.separationLine();
            CommandsForCapCalculator command = parser.parse(fullCommand);
            command.executeCommand(moduleList, storage, uiText, fullCommand);
            Exit = command.isExit();
        }

    }

}
