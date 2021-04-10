package seedu.allinonenus.capcalculatorclasses.parserforcapcalculator;

import seedu.allinonenus.capcalculatorclasses.commandsforcapcalculator.*;

public class ParserForCapCalculator {

    public ParserForCapCalculator() {

    }

    public CommandsForCapCalculator parse(String line) {
        String[] moduleInfo = line.split(" ");
        CommandsForCapCalculator newCommands = null;

        switch (moduleInfo[0]) {
        case "list":
            newCommands = new PrintModuleListCommand();
            break;
        case "show":
            newCommands = new ShowAllModulesCommand();
            break;

        case "delete":
            newCommands = new DeleteModuleCommand();
            break;

        case "edit":
            newCommands = new EditModuleCommand();
            break;
        case "view":
            newCommands = new ChangeSemesterViewCommand();
            break;

        case "add":
            newCommands = new AddNewModuleCommand();
            break;

        case "goal":
            newCommands = new SuggestGoalCommand();
            break;

        case "help":
            newCommands = new DisplayHelpCommand();
            break;

        case "update":
            newCommands = new UpdateStudentSemesterCommand();
            break;

        case "exit":
            newCommands = new ExitCapCalculatorCommand();
            break;

        default:

        }


        return newCommands;
    }

}
