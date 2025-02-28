package tournament.data;

public class Match
{
    protected Tournament associatedTournament;
    protected Participant participant1;
    protected Participant participant2;
    protected String result;

    public Match(Tournament associatedTournament, Participant participant1, Participant participant2)
    {
        this.associatedTournament = associatedTournament;
        this.participant1=participant1;
        this.participant2=participant2;
        this.result="Pending";
    }

    public Tournament getAssociatedTournament() {
        return associatedTournament;
    }

    public void setAssociatedTournament(Tournament associatedTournament) {
        this.associatedTournament = associatedTournament;
    }

    public Participant getParticipant1() {
        return participant1;
    }

    public void setParticipant1(Participant participant1) {
        this.participant1 = participant1;
    }

    public Participant getParticipant2() {
        return participant2;
    }

    public void setParticipant2(Participant participant2) {
        this.participant2 = participant2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String toString()
    {
        return "Match in "+associatedTournament+"\n - "+participant1+"\n     vs.\n - "+participant2+"\n - Result: "+result;
    }
}
