package seedu.allinonenus.teamplannerclasses;

import java.util.Scanner;

public class TeamParser {
    private static final TeamConstants constants = new TeamConstants();
    private static final TeamUi ui = new TeamUi();

    public static boolean mainParser(TeamManager team) {
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        String[] commandArguments = command.split(" ");
        try {
            if (commandArguments[0].equals("add") && commandArguments[1].equals("member")) {
                if (commandArguments.length == 2) {
                    System.out.println("Missing parameter in the input. Please specify a member to add");
                    return true;
                }
                ui.passwordValidation(team);
                String teamMemberName = "";
                for (String word : commandArguments) {
                    if (word.equals("add") || word.equals("member")) {
                        continue;
                    } else {
                        teamMemberName += word + " ";
                    }
                }
                teamMemberName = teamMemberName.stripTrailing();
                TeamMember teamMember = new TeamMember(teamMemberName, false);
                team.addMember(teamMember);
                System.out.println(team.getTeamMember(team.getMemberCount() - 1)
                        + " has been added to the team");
                ui.saveFile(team);
            } else if (commandArguments[0].equals("delete") && commandArguments[1].equals("member")) {
                if (commandArguments.length == 2) {
                    System.out.println("Missing parameter in the input. Please specify a member to delete");
                    return true;
                }
                String teamMemberName = command.replace("delete member ", "");
                teamMemberName = teamMemberName.trim();
                int memberIndex = team.getIndexOfTeamMember(teamMemberName);
                if (memberIndex == -1) {
                    System.out.println("Please specify a valid team member to be deleted");
                    return true;
                } else {
                    System.out.println(team.getTeamMember(memberIndex) + " will be removed");
                    team.removeMember(memberIndex);
                }
                ui.saveFile(team);
            } else if (commandArguments[0].equals("show") && commandArguments[1].equals("members")) {
                System.out.println("The team details are as follows:");
                ui.showTeamMembers(team);
            } else if (commandArguments[0].equals("clear") && commandArguments[1].equals("members")) {
                ui.passwordValidation(team);
                team.clearTeam();
                ui.saveFile(team);
                ui.initializeTeam(team);
                ui.saveFile(team);
            } else if (commandArguments[0].equals("help")) {
                System.out.println(constants.displayCommandsAvailable);
            } else if (commandArguments[0].equals("add") && commandArguments[1].equals("task")) {
                if (commandArguments.length < 5) {
                    System.out.println("Missing parameters in the input");
                    return true;
                }
                int priorityLevel = 0;
                if (commandArguments[commandArguments.length - 1].equals("HIGH")) {
                    priorityLevel = 1;
                } else if (commandArguments[commandArguments.length - 1].equals("MED")) {
                    priorityLevel = 2;
                } else if (commandArguments[commandArguments.length - 1].equals("LOW")) {
                    priorityLevel = 3;
                } else {
                    System.out.println("Unrecognized priority level input");
                    return true;
                }
                String taskDescription = "";
                for (int i = 3; i < commandArguments.length - 1; i++) {
                    taskDescription += commandArguments[i] + " ";
                }
                taskDescription = taskDescription.stripTrailing();
                Task task = new Task(taskDescription, priorityLevel, false);
                int memberIndex = team.getIndexOfTeamMember(commandArguments[2]);
                if (memberIndex == -1) {
                    System.out.println("Please specify a valid team member to add a task to");
                    return true;
                }
                (team.getTeamMember(memberIndex)).addTask(task);
                System.out.println(commandArguments[3] + " has been assigned to " + (team.getTeamMember(memberIndex))
                        + " with a priority level of " + commandArguments[commandArguments.length - 1]);
            } else if (commandArguments[0].equals("delete") && commandArguments[1].equals("task")) {
                if (commandArguments.length < 4) {
                    System.out.println("Missing parameters in the input");
                    return true;
                }
                String teamMemberName = command.replace("delete member ", "");
                teamMemberName = teamMemberName.trim();
                int memberIndex = team.getIndexOfTeamMember(teamMemberName);
                if (memberIndex == -1) {
                    System.out.println("Please specify a valid team member to add a task to");
                    return true;
                }
                TeamMember teamMember = team.getTeamMember(memberIndex);
                ui.deleteTask(teamMember, commandArguments[2]);
            } else if (commandArguments[0].equals("mark") && commandArguments[1].equals("done")) {
                if (commandArguments.length < 4) {
                    System.out.println("Missing parameters in the input");
                    return true;
                }
                TeamMember teamMember = (team.getTeamMember(team.getIndexOfTeamMember(commandArguments[2])));
                ui.markTaskAsDone(teamMember, commandArguments[2]);
            } else if (commandArguments[0].equals("show") && commandArguments[1].equals("tasks")) {
                ui.showTask(team);
            } else if (commandArguments[0].equals("quit")) {
                return false;
            } else {
                throw new TeamPlannerException("invalid_input");
            }
        } catch (TeamPlannerException e) {
            System.out.println("Invalid input");
            System.out.println(constants.displayCommandsAvailable);
        }
        return true;
    }
}
