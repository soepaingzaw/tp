package seedu.duke;

import seedu.duke.TeamPlannerClasses.TeamManager;
import seedu.duke.TeamPlannerClasses.TeamMember;

import java.util.Scanner;

public class TeamPlanner {
    private static final String welcomeMessage = "Welcome to All-In-One-NUS team manager";
    private static final String requestTeamLeaderName = "Please enter the name of the Team lead";
    private static final String requestTeamSize = "Please enter the size of your team";
    private static final String requestTeamMembersName = "Please enter the names of your team members, one on each line";
    private static final String requestTeamLeaderPassword = "[Team Lead] Please enter a password";
    private static final String requestTeamLeaderPasswordConfirmation = "[Team Lead] Please re-enter the password";
    private static final String passwordConfirmation = "The password has been set";
    private static final String passwordDoNotMatch = "The passwords do not match";
    private static final String displayCommandsAvailable = "Here are the list of commands available : \n" +
            "1. add [member] - adds a member (requires password)\n" + "2. delete [member index] - deletes a member (requires password)\n"
            + "3. show - shows current members\n" + "4. clear - clears the current team and resets the password (requires password)\n"
            + "5. help - lists the commands available\n" + "6. quit - quits the program\n";
    private static final String requestPassword = "Please enter the password";

    private static TeamManager team = new TeamManager();

    public static void main(String[] args) {
        boolean passwordEntered = false;
        boolean programOn = true;
        boolean passwordCorrect = false;
        String password = "";
        System.out.println(welcomeMessage);
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
        System.out.println(displayCommandsAvailable);
        while(programOn) {
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            String[] commandArguments = command.split(" ");
            if(commandArguments[0].equals("add")){
                while(!passwordCorrect){
                    System.out.println(requestPassword);
                    Scanner input = new Scanner(System.in);
                    String passwordInputed = input.nextLine();
                    if(passwordInputed.equals(password)){
                        passwordCorrect = true;
                    }
                }
                String teamMemberName = "";
                for(String word:commandArguments){
                    if(word.equals("add")){
                        continue;
                    } else{
                      teamMemberName += word;
                    }
                }
                TeamMember teamMember = new TeamMember(teamMemberName,false);
                team.addMember(teamMember);
                System.out.println(team.getTeamMember(team.getMemberCount()-1) +" has been added to the team");
                passwordCorrect = false;
            } else if(commandArguments[0].equals("delete")){
                while(!passwordCorrect){
                    System.out.println(requestPassword);
                    Scanner input = new Scanner(System.in);
                    String passwordInputed = input.nextLine();
                    if(passwordInputed.equals(password)){
                        passwordCorrect = true;
                    }
                }
                try{
                    int indexOfMemberToBeDeleted = Integer.parseInt(commandArguments[1]);
                    if(indexOfMemberToBeDeleted<team.getMemberCount()){
                        System.out.println(team.getTeamMember(indexOfMemberToBeDeleted) + " will be removed");
                        team.removeMember(indexOfMemberToBeDeleted);
                    } else {
                        System.out.println("Index out of range");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for member index");
                }
                passwordCorrect = false;
            } else if(commandArguments[0].equals("show")){
                System.out.println("The team details are as follows:");
                showTeamMembers();
                passwordCorrect = false;
            } else if(commandArguments[0].equals("clear")){
                team.clearTeam();
                passwordEntered = false;
                password = "";
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
                passwordCorrect = false;
            } else if(commandArguments[0].equals("help")){
                System.out.println(displayCommandsAvailable);
            } else if(commandArguments[0].equals("quit")){
                programOn = false;
            } else {
                System.out.println("Invalid Input");
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
    }

    public static void showTeamMembers() {
        for (int i = 0; i < team.getMemberCount(); i++) {
            if ((team.getTeamMember(i)).isTeamLeader()) {
                System.out.println((i + 1) + ". [Team Leader] " + (team.getTeamMember(i)).getName());
            } else {
                System.out.println((i + 1) + ". " + (team.getTeamMember(i)).getName());
            }
        }
    }

}
