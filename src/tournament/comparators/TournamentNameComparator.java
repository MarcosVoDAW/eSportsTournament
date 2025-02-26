package tournament.comparators;

import tournament.data.Tournament;

import java.util.Comparator;

public class TournamentNameComparator implements Comparator<Tournament> {
    @Override
    public int compare(Tournament t1, Tournament t2) {
        return t1.getName().compareTo(t2.getName());
    }
}
