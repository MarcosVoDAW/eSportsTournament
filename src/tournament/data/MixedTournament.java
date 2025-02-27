package tournament.data;

public class MixedTournament extends Tournament{
    protected String gameMode;

    public MixedTournament(String name, String associatedGame, double prize, String gameMode)
    {
        super(name, associatedGame, prize);
        if(!(gameMode.equals("1v1") || gameMode.equals("5v5")))
        {
            throw new IllegalArgumentException("Incorrect option");
        }
        this.gameMode = gameMode;
    }

    public String getGameMode()
    {
        return gameMode;
    }
    public void setGameMode(String gameMode)
    {
        if(!(gameMode.equals("1v1") || gameMode.equals("5v5")))
        {
            throw new IllegalArgumentException("Incorrect option");
        }
        this.gameMode = gameMode;
    }

    @Override
    public String toString()
    {
        return "Mixed Tournament - "+super.toString()+" - Prize: "+prize+"€ - Game mode: " + gameMode;
    }

}
