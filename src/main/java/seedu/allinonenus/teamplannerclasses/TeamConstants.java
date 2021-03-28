package seedu.allinonenus.teamplannerclasses;

public class TeamConstants {
    public static final String welcomeMessage = "Welcome to All-In-One-NUS team manager";
    public static final String requestTeamLeaderName = "Please enter the name of the Team lead (No spaces)";
    public static final String requestTeamSize = "Please enter the size of your team";
    public static final String requestTeamMembersName = "Please enter the names of your team members,"
            + "one per line (No spaces)";
    public static final String requestTeamLeaderPassword = "[Team Lead] Please enter a password (No spaces)";
    public static final String requestTeamLeaderPasswordConfirmation = "[Team Lead] Please re-enter the password";
    public static final String passwordConfirmation = "The password has been set";
    public static final String passwordDoNotMatch = "The passwords do not match";
    public static final String displayCommandsAvailable = "Here are the list of commands available : \n"
            + "1. add member [member] - adds a member (requires password)\n"
            + "2. delete member [member] - deletes a member (requires password)\n"
            + "3. show members - shows current members\n"
            + "4. clear members - clears the current team and resets the password (requires password)\n"
            + "5. help - lists the commands available\n"
            + "6. add task [member] [task] [priority level(HIGH/MED/LOW)]\n"
            + "7. delete task [member] [task index]\n"
            + "8. mark done [member] [task index]\n"
            + "9. show tasks\n"
            + "10. quit - quits the program\n";
    public static final String requestPassword = "Please enter the password";
}
