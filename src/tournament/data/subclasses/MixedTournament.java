package tournament.data.subclasses;
import tournament.data.Tournament;

public class MixedTournament extends Tournament{
    protected String gameMode;

    public MixedTournament(String name, String gameAssociated, double prize, String gameMode)
    {
        super(name, gameAssociated, prize);
        this.gameMode = gameMode;
    }

    public String getGameMode()
    {
        return gameMode;
    }

    public String toString()
    {
        return super.toString() + " -Prize: " + prize + "€ -Game mode: " + gameMode;
    }

}
