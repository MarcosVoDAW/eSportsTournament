package tournament.data;

public class IndividualTournament extends Tournament
{
    public IndividualTournament(String name, String gameAssociated, double prize)
    {
        super(name, gameAssociated, prize);
    }
    @Override
    public String toString()
    {
        return super.toString() + " -Prize: " + prize + "€";
    }

}
