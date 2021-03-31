package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;


public abstract class CommandsForCapCalculator {
    protected boolean exit;

    public CommandsForCapCalculator() {
        this.exit = false;

    }

    public abstract void executeCommand(ModuleList moduleList, ModuleStorage storage, UiText uiText, String fullCommand);

    public abstract boolean isExit();


}
