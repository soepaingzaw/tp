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
                String teamMemberName = commandArguments[2].trim();
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
                ui.passwordValidation(team);
                String teamMemberName = commandArguments[2].trim();
                int memberIndex = team.getIndexOfTeamMember(teamMemberName);
                if (memberIndex == -1) {
                    System.out.println("Please specify a valid team member to be deleted");
                    return true;
                } else {
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
                System.out.println("Member to add task to:");
                String teamMemberName = in.nextLine();
                teamMemberName = teamMemberName.trim();
                int memberIndex = team.getIndexOfTeamMember(teamMemberName);
                if (memberIndex == -1) {
                    System.out.println("Please specify a valid team member to add a task to");
                    return true;
                }
                System.out.println("Task to be added:");
                String taskDescription = in.nextLine();
                taskDescription = taskDescription.trim();
                System.out.println("Priority level of the task:");
                String priorityLevelInput = in.nextLine();
                int priorityLevel = 0;
                if (priorityLevelInput.equals("HIGH")) {
                    priorityLevel = 1;
                } else if (priorityLevelInput.equals("MED")) {
                    priorityLevel = 2;
                } else if (priorityLevelInput.equals("LOW")) {
                    priorityLevel = 3;
                } else {
                    System.out.println("Unrecognized priority level input");
                    return true;
                }
                Task task = new Task(taskDescription, priorityLevel, false);
                (team.getTeamMember(memberIndex)).addTask(task);
                System.out.println(taskDescription + " has been assigned to " + (team.getTeamMember(memberIndex))
                        + " with a priority level of " + priorityLevel);
                ui.saveFile(team);
            } else if (commandArguments[0].equals("delete") && commandArguments[1].equals("task")) {
                System.out.println("Member to delete task from:");
                String teamMemberName = in.nextLine();
                teamMemberName = teamMemberName.trim();
                int memberIndex = team.getIndexOfTeamMember(teamMemberName);
                if (memberIndex == -1) {
                    System.out.println("Please specify a valid team member to add a task to");
                    return true;
                }
                TeamMember teamMember = team.getTeamMember(memberIndex);
                System.out.println("Index of task to be deleted:");
                int taskIndex = -1;
                try {
                    taskIndex = Integer.parseInt(in.nextLine()) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for index of task");
                }
                if (taskIndex == -1) {
                    return true;
                }
                try {
                    ui.deleteTask(teamMember, taskIndex);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Please enter a valid task index");
                }
                ui.saveFile(team);
            } else if (commandArguments[0].equals("mark") && commandArguments[1].equals("done")) {
                System.out.println("Member the task is assigned to:");
                String teamMemberName = in.nextLine();
                teamMemberName = teamMemberName.trim();
                int memberIndex = team.getIndexOfTeamMember(teamMemberName);
                if (memberIndex == -1) {
                    System.out.println("Please specify a valid team member to add a task to");
                    return true;
                }
                TeamMember teamMember = (team.getTeamMember(memberIndex));
                System.out.println("Index of task to be marked as done:");
                int taskIndex = -1;
                try {
                    taskIndex = Integer.parseInt(in.nextLine()) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for index of task");
                }
                if (taskIndex == -1) {
                    return true;
                }
                try {
                    ui.markTaskAsDone(teamMember, taskIndex);
                    System.out.println(teamMember.getTask(taskIndex) + " has been marked as done for " + teamMember);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid input for index of task");
                }
                ui.saveFile(team);
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
