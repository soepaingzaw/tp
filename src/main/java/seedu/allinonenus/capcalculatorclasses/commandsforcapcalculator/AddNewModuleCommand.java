package seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.InvalidGradeException;
import seedu.allinonenus.capcalculatorclasses.exceptionsforcapcalculator.WrongModuleFormatException;
import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;
import seedu.allinonenus.capcalculatorclasses.storageforcapcalculator.ModuleStorage;
import seedu.allinonenus.capcalculatorclasses.uiforcapcalculator.UiText;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddNewModuleCommand extends CommandsForCapCalculator {

    public AddNewModuleCommand() {
        super();
    }

    /**
     * @param moduleList
     * @param storage
     * @param uiText
     * @param fullCommand
     */
    public void executeCommand(ModuleList moduleList, ModuleStorage storage, UiText uiText, String fullCommand)
            throws WrongModuleFormatException, InvalidGradeException {

        String[] moduleInfo = fullCommand.split(" ");
        int currentSem = storage.getSem();
        ModuleData modules = new ModuleData(moduleInfo[1], moduleInfo[2], Integer.parseInt(moduleInfo[3]), currentSem);
        checkGradeFormat(moduleList, moduleInfo[2]);
        if (/*!checkForModuleFormat(moduleInfo[1]) || */!checkMcFormat(Integer.parseInt(moduleInfo[3]))) {
            throw new WrongModuleFormatException();
        }


        if (checkIfModuleExists(moduleList, moduleInfo[1], currentSem)) {
            moduleList.add(modules);
            uiText.confirmModuleUpdate(modules.moduleCode);
            saveToStorage(storage, moduleList);
        } else {
            uiText.moduleAlreadyExists();
        }
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

    public boolean checkIfModuleExists(ModuleList list, String module, int sem) {
        for (int i = 0; i < list.size(); i++) {
            String checkMod = list.get(i).moduleCode;
            int checkSem = list.get(i).sem;
            if (checkMod.equals(module) && checkSem == sem) {
                return false;
            }
        }
        return true;
    }

    public boolean checkForModuleFormat(String mod) {
        boolean modCorrect = true;

        int count = 0;
        int numLetters = 0;
        int numNumerals = 0;


        if (Character.isLetter(mod.charAt(count))) {

            while (Character.isLetter(mod.charAt(count))) {
                count++;

                if (count > 3) {
                    modCorrect = false;

                }
            }


            numLetters = count;

            while (Character.isDigit(mod.charAt(count))) {
                count++;

                if (count - numLetters > 4) {
                    modCorrect = false;

                }
                System.out.print(count - numLetters + "\n");

            }

            if(modCorrect){
                System.out.print("Here\n");
            }

            numNumerals = count - numLetters;

        } else {

            modCorrect = false;
        }


        if (numLetters < 2 || numNumerals != 4) {

            modCorrect =  false;
        }



        return modCorrect;

    }

    public boolean checkMcFormat(int mcs) {
        boolean mcsCorrect = true;

        if (mcs < 2 || mcs > 12) {
            mcsCorrect = false;
        }

        return mcsCorrect;
    }

    public void checkGradeFormat(ModuleList list, String grade) throws InvalidGradeException {
        list.gradesToPoints(grade);
    }

    public boolean isExit() {
        return exit;
    }
}
