package tournament.data;

public class Player extends Participant {
    protected int level;
    protected double ranking;

    public Player(String name, int level, double ranking)
    {
        super(name);
        this.level = level < 1 ? 1 : (level > 100 ? 100 : level);
        this.ranking = ranking < 0 ? 0 : ranking;
    }

    public double getRanking() {
        return ranking;
    }

    @Override
    public String toString() {
        return "Player: "+super.toString()+" - Level: "+level+" - Ranking: "+ranking;
    }
}
