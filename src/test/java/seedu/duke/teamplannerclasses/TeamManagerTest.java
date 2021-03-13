package seedu.duke.teamplannerclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamManagerTest {

    @Test
    void getTeamMember_oneTeamMember_expectIndexOfTeamMember() {
        TeamManager team = new TeamManager();
        String inputString = "inputName";
        TeamMember teamMember = new TeamMember(inputString,false);
        team.addMember(teamMember);
        String outputString = (team.getTeamMember(0)).getName();
        assertEquals(outputString,"inputName");
    }
}