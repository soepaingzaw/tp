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
            uiText.promptForCommand();
            moduleList = new ModuleList();
            String studentYearAndSem = uiText.readCommand();
            storage.currentSem = moduleList.computeSem(studentYearAndSem);
            storage.totalSem = storage.currentSem;
            uiText.separationLine();
            uiText.listManual();

        }

    }

    public void run() {
        String fullCommand;
        boolean Exit = false;

        while (!Exit) {
            int sem = storage.totalSem;
            int currSem = storage.currentSem;
            String studentProfile = moduleList.printYearAndSem(sem);
            String currentSemView = moduleList.printYearAndSem(currSem);
            uiText.printStudentProfile(studentProfile);
            uiText.currentSemView(currentSemView);
            uiText.promptForCommand();
            fullCommand = uiText.readCommand();
            uiText.separationLine();
            try {
                CommandsForCapCalculator command = parser.parse(fullCommand);
                command.executeCommand(moduleList, storage, uiText, fullCommand);
                Exit = command.isExit();
            } catch (NullPointerException e) {
                uiText.getHelp();
            }

        }

    }

}
