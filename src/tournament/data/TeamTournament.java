package tournament.data;

public class TeamTournament extends Tournament {
    protected int playersPerTeam;

    public TeamTournament(String name, String associatedGame, double prize, int playersPerTeam)
    {
        super(name, associatedGame, prize);
        this.playersPerTeam = playersPerTeam;
    }

    @Override
    public String toString()
    {
        return "Team Tournament - "+super.toString()+" - Prize: "+prize+"€ - Players per team: " + playersPerTeam;
    }
}
