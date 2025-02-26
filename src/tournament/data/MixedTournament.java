package tournament.data;

public class MixedTournament extends Tournament{
    protected String gameMode;

    // (can be "1v1" or "5v5")
    // HAY QUE TENER ESO EN CUENTA A LA HORA DE METER EL DATO?
    public MixedTournament(String name, String associatedGame, double prize, String gameMode)
    {
        super(name, associatedGame, prize);
        this.gameMode = gameMode;
    }

    public String getGameMode()
    {
        return gameMode;
    }
    public void setGameMode(String gameMode)
    {
        this.gameMode = gameMode;
    }

    @Override
    public String toString()
    {
        return "Mixed Tournament - "+super.toString()+" - Prize: "+prize+"€ - Game mode: " + gameMode;
    }

}
