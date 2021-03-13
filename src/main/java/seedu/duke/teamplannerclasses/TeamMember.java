package seedu.duke.teamplannerclasses;

public class TeamMember {
    protected String name;
    protected boolean isTeamLeader;

    public TeamMember(String name, boolean isTeamLeader) {
        this.name = name;
        this.isTeamLeader = isTeamLeader;
    }

    public String getName() {
        return name;
    }

    public boolean isTeamLeader() {
        return isTeamLeader;
    }

    @Override
    public String toString() {
        return name;
    }
}