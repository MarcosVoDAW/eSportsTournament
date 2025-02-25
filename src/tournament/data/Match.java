package tournament.data;

public class Match
{
    Tournament tournament;
    Participant participant1;
    Participant participant2;
    String result;

    public Match(Tournament tournament,Participant participant1,Participant participant2,String result)
    {
        this.tournament=tournament;
        this.participant1=participant1;
        this.participant2=participant2;
        this.result=result;
    }

    public void setResult(String result)
    {
        this.result=result;
    }

    public String toString()
    {
        return "Match in " + tournament + " - " + participant1 + " vs. " + participant2 + " - Result: " + result;
    }
}
