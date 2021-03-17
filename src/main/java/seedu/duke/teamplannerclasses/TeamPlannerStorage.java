package seedu.duke.teamplannerclasses;

import seedu.duke.teamplannerclasses.TeamManager;
import seedu.duke.teamplannerclasses.TeamMember;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TeamPlannerStorage {
    public static void loadFile(TeamManager team) throws FileNotFoundException {
        File filePath = new File("team.txt");
        if (!filePath.exists()) {
            throw new FileNotFoundException();
        }
        Scanner s = new Scanner(filePath);
        if (filePath.length() != 0) {
            while (s.hasNext()) {
                String currentLine = s.nextLine();
                String[] words = currentLine.split("");
                if (words[1].equals("[M]")) {
                    String teamMemberName = "";
                    for (int i = 1; i < words.length; i++) {
                        teamMemberName += words[i];
                    }
                    TeamMember teamMember = new TeamMember(teamMemberName, false);
                    team.addMember(teamMember);
                    team.increaseMemberCount();
                } else if (words[1].equals("[L]")) {
                    String teamMemberName = "";
                    for (int i = 2; i < words.length; i++) {
                        teamMemberName += words[i];
                    }
                    TeamMember teamMember = new TeamMember(teamMemberName, true);
                    team.addMember(teamMember);
                    team.increaseMemberCount();
                } else if (words[0].equals("[P]")) {
                    String password = "";
                    for (int i = 1; i < words.length; i++) {
                        password += words[i];
                    }
                    team.setPassword(password);
                }
            }
        }
    }

    public static void saveFile(TeamManager team) throws IOException {
        File filePath = new File("team.txt");
        if (!filePath.exists()) {
            if (filePath.exists()) {
                throw new IOException();
            }
        }
        FileWriter fileWriter = new FileWriter(filePath);
        for (int i = 0; i < team.getMemberCount(); i++) {
            String teamMember = team.getTeamMember(i).toString() + "\n";
            fileWriter.write(teamMember);
        }
        String password = "[P]" + team.getPassword();
        fileWriter.write(password);
    }
}
