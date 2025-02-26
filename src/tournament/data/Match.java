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

    public void setResult(String result)
    {
        this.result=result;
    }

    public String toString()
    {
        return "Match in "+associatedTournament+" - "+participant1+" vs. "+participant2+" - Result: "+result;
    }
}
