package tournament.data;

public abstract class Tournament {
    protected String name;
    protected String associatedGame;
    protected double prize;

    public Tournament(String name, String associatedGame, double prize) {
        this.name = name;
        this.associatedGame = associatedGame;
        this.prize = prize;
    }
    public double getPrize() {
        return prize;
    }
    public void setPrize(double prize) {
        this.prize = prize;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAssociatedGame() {
        return associatedGame;
    }
    public void setAssociatedGame(String associatedGame) {
        this.associatedGame = associatedGame;
    }

    @Override
    public String toString()
    {
        return name+" ("+associatedGame+")";
    }

}
