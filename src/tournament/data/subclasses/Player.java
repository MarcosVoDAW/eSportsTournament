package tournament.data.subclasses;

import tournament.data.Participant;

public class Player extends Participant {
    protected int level;
    protected float ranking;


    /*
    public Player(String name, int level, double ranking) {
        super(name);
        setLevel(level);
        setRanking(ranking);
    }
    Podemos realizar esta forma en la que llamamos a los setters de "Level" y de "Ranking" para evitar repetir código
    pero el problema es que puede NO ser aceptado en el proyecto

    Optaremos por repetir código y poner 2 if para cada atributo*/

    public Player(String name, int level, float ranking)
    {
        super(name);
        this.level = level < 1 ? 1 : level > 100 ? 100 : level;
        this.ranking = ranking < 0 ? 0 : ranking;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level < 1 ? 1 : level > 100 ? 100 : level;
    }

    public float getRanking() {
        return ranking;
    }

    public void setRanking(float ranking) {
        this.ranking = ranking < 0 ? 0 : ranking;
    }

    @Override
    public String toString() {
        return "Player: " + getName() + " - Level: " + level + " - Ranking: " + ranking;
    }
}
