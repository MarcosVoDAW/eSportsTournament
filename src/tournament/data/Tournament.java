package tournament.data;

public abstract class Tournament {
    protected String name;
    protected String gameAssociated;
    protected double prize;

    public Tournament(String name, String gameAssociated, double prize) {
        this.name = name;
        this.gameAssociated = gameAssociated;
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
    public String getGameAssociated() {
        return gameAssociated;
    }
    public void setGameAssociated(String gameAssociated) {
        this.gameAssociated = gameAssociated;
    }

    public String toString()
    {
        return name + " (" + gameAssociated + ")" ;
    }

}
