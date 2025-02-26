package tournament.comparators;

import tournament.data.Player;

import java.util.Comparator;

public class PlayerRankingAndNameComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        int result;
        result = Double.compare(p1.getRanking(), p2.getRanking());
        if (result == 0)
            result = p1.getName().compareTo(p2.getName());
        return result;
    }
}