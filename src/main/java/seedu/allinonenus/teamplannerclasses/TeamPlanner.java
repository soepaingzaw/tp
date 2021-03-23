package seedu.allinonenus.teamplannerclasses;

import seedu.allinonenus.teamplannerclasses.TeamManager;
import seedu.allinonenus.teamplannerclasses.TeamMember;
import seedu.allinonenus.teamplannerclasses.TeamPlannerException;
import seedu.allinonenus.teamplannerclasses.TeamPlannerStorage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TeamPlanner {
    private static final String welcomeMessage = "Welcome to All-In-One-NUS team manager";
    private static final String requestTeamLeaderName = "Please enter the name of the Team lead";
    private static final String requestTeamSize = "Please enter the size of your team";
    private static final String requestTeamMembersName = "Please enter the names of your team members, one per line";
    private static final String requestTeamLeaderPassword = "[Team Lead] Please enter a password";
    private static final String requestTeamLeaderPasswordConfirmation = "[Team Lead] Please re-enter the password";
    private static final String passwordConfirmation = "The password has been set";
    private static final String passwordDoNotMatch = "The passwords do not match";
    private static final String displayCommandsAvailable = "Here are the list of commands available : \n"
            + "1. add member [member] - adds a member (requires password)\n"
            + "2. delete member [member index] - deletes a member (requires password)\n"
            + "3. show members - shows current members\n"
            + "4. clear members - clears the current team and resets the password (requires password)\n"
            + "5. show commands - lists the commands available\n"
            + "6. quit - quits the program\n";
    private static final String requestPassword = "Please enter the password";

    private static TeamManager team = new TeamManager();

    public static void teamPlanner() {
        boolean passwordEntered = false;
        String password = "";
        System.out.println(welcomeMessage);
        boolean fileNotFoundFlag = true;
        try {
            TeamPlannerStorage.loadFile(team);
            fileNotFoundFlag = false;
        } catch (FileNotFoundException e) {
            System.out.println("No saved file found");
        }
        if (fileNotFoundFlag) {
            keyInMembersDetails();
            while (!passwordEntered) {
                System.out.println(requestTeamLeaderPassword);
                Scanner in = new Scanner(System.in);
                password = in.nextLine();
                System.out.println(requestTeamLeaderPasswordConfirmation);
                if (password.equals(in.nextLine())) {
                    passwordEntered = true;
                    System.out.println(passwordConfirmation);
                } else {
                    System.out.println(passwordDoNotMatch);
                }
            }
            team.setPassword(password);
        }
        boolean programOn = true;
        System.out.println(displayCommandsAvailable);
        while (programOn) {
            boolean passwordCorrect = false;
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            String[] commandArguments = command.split(" ");
            try {
                if (commandArguments[0].equals("add") && commandArguments[1].equals("member")) {
                    if (commandArguments.length == 2) {
                        System.out.println("Missing parameter in the input. Please specify a member to add");
                        continue;
                    }
                    while (!passwordCorrect) {
                        System.out.println(requestPassword);
                        Scanner input = new Scanner(System.in);
                        String passwordInputed = input.nextLine();
                        if (passwordInputed.equals(password)) {
                            passwordCorrect = true;
                        }
                    }
                    String teamMemberName = "";
                    for (String word : commandArguments) {
                        if (word.equals("add") || word.equals("member")) {
                            continue;
                        } else {
                            teamMemberName += word;
                        }
                    }
                    TeamMember teamMember = new TeamMember(teamMemberName, false);
                    team.addMember(teamMember);
                    System.out.println("[M]" + team.getTeamMember(team.getMemberCount() - 1)
                            + " has been added to the team");
                    try {
                        TeamPlannerStorage.saveFile(team);
                    } catch (IOException e) {
                        System.out.println("Unable to save the current members as a text file");
                    }
                } else if (commandArguments[0].equals("delete") && commandArguments[1].equals("member")) {
                    if (commandArguments.length == 2) {
                        System.out.println("Missing parameter in the input. Please specify a member to delete");
                        continue;
                    }
                    while (!passwordCorrect) {
                        System.out.println(requestPassword);
                        Scanner input = new Scanner(System.in);
                        String passwordInputed = input.nextLine();
                        if (passwordInputed.equals(password)) {
                            passwordCorrect = true;
                        }
                    }
                    try {
                        int indexOfMemberToBeDeleted = Integer.parseInt(commandArguments[2]);
                        if (indexOfMemberToBeDeleted < team.getMemberCount()) {
                            System.out.println(team.getTeamMember(indexOfMemberToBeDeleted) + " will be removed");
                            team.removeMember(indexOfMemberToBeDeleted);
                        } else {
                            System.out.println("Index out of range");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input for member index");
                    }
                    try {
                        TeamPlannerStorage.saveFile(team);
                    } catch (IOException e) {
                        System.out.println("Unable to save the current members as a text file");
                    }
                } else if (commandArguments[0].equals("show") && commandArguments[1].equals("members")) {
                    System.out.println("The team details are as follows:");
                    showTeamMembers();
                } else if (commandArguments[0].equals("clear") && commandArguments[1].equals("members")) {
                    while (!passwordCorrect) {
                        System.out.println(requestPassword);
                        Scanner input = new Scanner(System.in);
                        String passwordInputed = input.nextLine();
                        if (passwordInputed.equals(password)) {
                            passwordCorrect = true;
                        }
                    }
                    team.clearTeam();
                    try {
                        TeamPlannerStorage.saveFile(team);
                    } catch (IOException e) {
                        System.out.println("Unable to save the current members as a text file");
                    }
                    password = "";
                    team.setPassword(password);
                    System.out.println(welcomeMessage);
                    keyInMembersDetails();
                    while (!passwordEntered) {
                        System.out.println(requestTeamLeaderPassword);
                        Scanner teamInput = new Scanner(System.in);
                        password = teamInput.nextLine();
                        System.out.println(requestTeamLeaderPasswordConfirmation);
                        if (password.equals(in.nextLine())) {
                            passwordEntered = true;
                            System.out.println(passwordConfirmation);
                        } else {
                            System.out.println(passwordDoNotMatch);
                        }
                    }
                    team.setPassword(password);
                } else if (commandArguments[0].equals("help")) {
                    System.out.println(displayCommandsAvailable);
                } else if (commandArguments[0].equals("quit")) {
                    programOn = false;
                } else {
                    throw new TeamPlannerException("invalid_input");
                }
            } catch (TeamPlannerException e) {
                System.out.println("Invalid input");
                System.out.println(displayCommandsAvailable);
            }
        }
    }

    public static void keyInMembersDetails() {
        //Initialize the teamManager class
        System.out.println(requestTeamLeaderName);
        Scanner in = new Scanner(System.in);
        String teamLeaderInputed = in.nextLine();
        //Add leader to the teamManager class
        TeamMember teamLeader = new TeamMember(teamLeaderInputed, true);
        team.addMember(teamLeader);
        System.out.println(requestTeamSize);
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
        System.out.println(requestTeamMembersName);
        for (int i = 0; i < size; i++) {
            String teamMemberInputed = in.nextLine();
            //Add each member to the teamManager class
            TeamMember teamMember = new TeamMember(teamMemberInputed, false);
            team.addMember(teamMember);
        }
        System.out.println("The team details are as follows:");
        showTeamMembers();
        try {
            TeamPlannerStorage.saveFile(team);
        } catch (IOException e) {
            System.out.println("Unable to save the current members as a text file");
        }
    }

    public static void showTeamMembers() {
        for (int i = 0; i < team.getMemberCount(); i++) {
            if ((team.getTeamMember(i)).isTeamLeader()) {
                System.out.println((i + 1) + ". [L] " + (team.getTeamMember(i)).getName());
            } else {
                System.out.println((i + 1) + ". [M]" + (team.getTeamMember(i)).getName());
            }
        }
    }

    public void run() {
        teamPlanner();
    }


}
