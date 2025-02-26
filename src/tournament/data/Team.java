package tournament.data;

import tournament.exceptions.FullTeamException;

public class Team extends Participant
{
    //Variable para el máximo de jugadores por si hay que cambiarlo a futuro en algún cambio
    protected final int max_players = 5;
    protected Player[] players;
    protected int playerCount;

    public Team(String name)
    {
        super(name);
        this.players = new Player[max_players];
        this.playerCount = 0;
    }
    public Player[] getPlayers()
    {
        return players;
    }
    public void setPlayers(Player[]players)
    {
        this.players = players;
    }
    public void addPlayer(Player player) throws FullTeamException
    {
        if(playerCount>= max_players)
        {
            throw new FullTeamException("The team is full");
        }
        players[playerCount] = player;
        playerCount++;
    }
    @Override
    public String toString()
    {
        String playersString="";
        for (Player player : players)
        {
            playersString += "- "+player + "\n";
        }
        return super.toString()+" - Members: "+playerCount+"/"+max_players+": "+playersString;
    }

}
