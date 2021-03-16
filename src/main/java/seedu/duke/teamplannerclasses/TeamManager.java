package seedu.duke.teamplannerclasses;

import java.util.ArrayList;


public class TeamManager {
    private ArrayList<TeamMember> team;
    private int memberCount = 0;

    public TeamManager() {
        this.team = new ArrayList<TeamMember>();
    }

    public void addMember(TeamMember teamMember) {
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

    public TeamMember getTeamMember(int index) {
        return team.get(index);
    }

    public int getIndexOfTeamMember(String teamMemberName) {
        return team.indexOf(teamMemberName);
    }

    public void clearTeam() {
        team.clear();
        memberCount = 0;
    }

}
