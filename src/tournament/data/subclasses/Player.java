package tournament.data.subclasses;

import tournament.data.Participant;

public class Player extends Participant {
    protected int level;
    protected double ranking;

    public Player(String name, int level, double ranking) {
        super(name);
        setLevel(level);
        setRanking(ranking);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            this.level = 1;
        } else if (level > 100) {
            this.level = 100;
        } else {
            this.level = level;
        }
    }

    public double getRanking() {
        return ranking;
    }

    public void setRanking(double ranking) {
        if (ranking < 0) {
            this.ranking = 0;
        }
        else {
            this.ranking = ranking;
        }
    }

    @Override
    public String toString() {
        return "Player: " + getName() + " - Level: " + level + " - Ranking: " + ranking;
    }
}
