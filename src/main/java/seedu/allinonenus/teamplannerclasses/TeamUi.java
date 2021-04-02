package seedu.allinonenus.teamplannerclasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TeamUi {
    private static final TeamConstants constants = new TeamConstants();

    public static void startUp(TeamManager team) {
        System.out.println(constants.welcomeMessage);
        boolean fileNotFoundFlag = loadFile(team);
        if (!fileNotFoundFlag) {
            initializeTeam(team);
        }
    }

    public static void initializeTeam(TeamManager team) {
        boolean passwordEntered = false;
        String password = "";
        enterTeamDetails(team);
        while (!passwordEntered) {
            System.out.println(constants.requestTeamLeaderPassword);
            Scanner in = new Scanner(System.in);
            password = in.nextLine();
            while (password.length() == 0) {
                System.out.println("The password field cannot be empty");
                password = in.nextLine();
            }
            System.out.println(constants.requestTeamLeaderPasswordConfirmation);
            if (password.equals(in.nextLine())) {
                passwordEntered = true;
                System.out.println(constants.passwordConfirmation);
            } else {
                System.out.println(constants.passwordDoNotMatch);
            }
        }
        team.setPassword(password);
        saveFile(team);
    }

    public static void enterTeamDetails(TeamManager team) {
        //Initialize the teamManager class
        System.out.println(constants.requestTeamLeaderName);
        Scanner in = new Scanner(System.in);
        String teamLeaderName = in.nextLine();
        while (teamLeaderName.length() == 0) {
            System.out.println("The team leader field cannot be empty");
            teamLeaderName = in.nextLine();
        }
        //Add leader to the teamManager class
        TeamMember teamLeader = new TeamMember(teamLeaderName, true);
        team.addMember(teamLeader);
        System.out.println(constants.requestTeamSize);
        int size = 0;
        boolean validTeamSize = false;
        while (!validTeamSize) {
            try {
                size = Integer.parseInt(in.nextLine());
                validTeamSize = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        System.out.println(constants.requestTeamMembersName);
        for (int i = 0; i < size; i++) {
            String teamMemberName = in.nextLine();
            while (teamMemberName.length() == 0) {
                System.out.println("The team member field cannot be empty");
                teamMemberName = in.nextLine();
            }
            //Add each member to the teamManager class
            TeamMember teamMember = new TeamMember(teamMemberName, false);
            team.addMember(teamMember);
        }
        System.out.println("The team details are as follows:");
        showTeamMembers(team);
    }

    public static void saveFile(TeamManager team) {
        try {
            TeamPlannerStorage.saveFile(team);
        } catch (IOException e) {
            System.out.println("Unable to save the current members as a text file");
        }
    }

    public static boolean loadFile(TeamManager team) {
        try {
            TeamPlannerStorage.loadFile(team);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("No saved file found");
            return false;
        }
    }

    public static void showTeamMembers(TeamManager team) {
        for (int i = 0; i < team.getMemberCount(); i++) {
            if ((team.getTeamMember(i)).isTeamLeader()) {
                System.out.println((i + 1) + ". [L] " + (team.getTeamMember(i)).getName());
            } else {
                System.out.println((i + 1) + ". [M] " + (team.getTeamMember(i)).getName());
            }
        }
    }

    public static void passwordValidation(TeamManager team) {
        boolean passwordCorrect = false;
        while (!passwordCorrect) {
            System.out.println(constants.requestPassword);
            Scanner input = new Scanner(System.in);
            String passwordInputed = input.nextLine();
            if (passwordInputed.equals(team.getPassword())) {
                passwordCorrect = true;
            }
        }
    }

    public static void deleteTask(TeamMember teamMember, int commandArgument) {
        try {
            teamMember.deleteTask(commandArgument);
        } catch (NumberFormatException e) {
            System.out.println("Please specify a valid index of the task to be deleted");
        }
    }

    public static void markTaskAsDone(TeamMember teamMember, int commandArgument) {
        try {
            teamMember.markTaskAsDone(commandArgument);
        } catch (NumberFormatException e) {
            System.out.println("Please specify a valid index of the task to be marked as done");
        }
    }

    public static void showTask(TeamManager team) {
        for (int i = 0; i < team.getMemberCount(); i++) {
            System.out.println((i+1) + ". " + team.getTeamMember(i));
            System.out.println("  Tasks assigned");
            for (int j = 0; j < (team.getTeamMember(i)).getTaskCount(); j++) {
                System.out.print("  " + (j + 1) + ".");
                switch(team.getTeamMember(i).getTask(j).getPriority()){
                case 1:
                    System.out.print(" [HIGH]");
                    break;
                case 2:
                    System.out.print(" [MED] ");
                    break;
                case 3:
                    System.out.print(" [LOW] ");
                    break;
                }
                System.out.print((team.getTeamMember(i)).getTask(j)+"\n");
            }
        }
    }
}
