package seedu.duke.TeamPlannerClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamManagerTest {

    @Test
    void getTeamMember_oneTeamMember_expectIndexOfTeamMember() {
        teammanager team = new teammanager();
        String inputString = "inputName";
        teammember teamMember = new teammember(inputString,false);
        team.addMember(teamMember);
        String outputString = (team.getTeamMember(0)).getName();
        assertEquals(outputString,"inputName");
    }
}