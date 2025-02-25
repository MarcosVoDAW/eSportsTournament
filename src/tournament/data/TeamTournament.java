package tournament.data;

public class TeamTournament extends Tournament {
    protected int playersPerTeam;

    public TeamTournament(String name, String gameAssociated, double prize, int playersPerTeam)
    {
        super(name, gameAssociated, prize);
        this.playersPerTeam = playersPerTeam;
    }

    public int getPlayersPerTeam()
    {
        return playersPerTeam;
    }
    public void setPlayersPerTeam(int playersPerTeam)
    {
        this.playersPerTeam = playersPerTeam;
    }

    @Override
    public String toString()
    {
        return super.toString() + " -Prize: " + prize + "€ -Players per team: " + playersPerTeam;
    }
}
