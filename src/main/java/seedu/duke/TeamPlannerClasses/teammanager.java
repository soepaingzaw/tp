package seedu.duke.TeamPlannerClasses;

import java.util.ArrayList;


public class teammanager {
    private ArrayList<teammember> team;
    private int memberCount = 0;

    public teammanager() {
        this.team = new ArrayList<teammember>();
    }

    public void addMember(teammember teamMember) {
        team.add(teamMember);
        memberCount++;
    }

    public void removeMember(int memberNum) {
        if (memberNum < memberCount && memberCount >= 0) {
            System.out.println(team.get(memberNum) + " has been removed");
            team.remove(memberNum);
            memberCount--;
        } else {
            System.out.println("Index out of range");
        }
    }

    public int getMemberCount() {
        return memberCount;
    }

    public teammember getTeamMember(int index) {
        return team.get(index);
    }

    public void clearTeam() {
        team.clear();
    }

}
