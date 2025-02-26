package tournament.comparators;

import tournament.data.Player;

import java.util.Comparator;

public class PlayerRankingComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        return Double.compare(p1.getRanking(), p2.getRanking());
    }
}
