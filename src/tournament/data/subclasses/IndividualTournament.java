package tournament.data.subclasses;
import tournament.data.Tournament;

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
