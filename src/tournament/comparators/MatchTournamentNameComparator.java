package tournament.comparators;

import tournament.data.Match;

import java.util.Comparator;

public class MatchTournamentNameComparator implements Comparator<Match> {
    @Override
    public int compare(Match m1, Match m2) {
        return (m1.getAssociatedTournament().getName()).compareTo(m2.getAssociatedTournament().getName());
    }
}
