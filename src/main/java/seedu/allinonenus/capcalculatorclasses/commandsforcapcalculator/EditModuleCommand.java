package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

public class EditModuleCommand extends CommandsForCapCalculator{

        public EditModuleCommand() {
            super();
        }

        public void executeCommand(ModuleList moduleList, ModuleStorage storage, UiText uiText, String fullCommand){
            //moduleList.add()
        }

        public boolean isExit(){
            return exit;
        }
}
