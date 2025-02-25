package tournament.data;

import tournament.data.subclasses.Player;

public class Team extends Participant
{
    Player[]players;
    int playerCount;
    public Team(String name,Player[]players,int playerCount)
    {
        super(name);
        this.players=new Player[5];
        this.playerCount=playerCount;
    }
    public Player[] getPlayers()
    {
        return players;
    }
    public void setPlayers(Player[]players)
    {
        this.players=players;
    }
    public void addPlayer(Player p)
    {
        if(playerCount>2 && playerCount<5)
        {

        }

    }
    @Override
    public String toString()
    {
        return "Members: " +players + " -Player: " +getName() ;
    }

}
