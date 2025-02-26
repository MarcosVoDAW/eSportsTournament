package tournament.data;

public class IndividualTournament extends Tournament
{
    public IndividualTournament(String name, String associatedGame, double prize)
    {
        super(name, associatedGame, prize);
    }

    @Override
    public String toString()
    {
        return "Individual Tournament - "+super.toString()+" - Prize: "+prize +"€";
    }

}
