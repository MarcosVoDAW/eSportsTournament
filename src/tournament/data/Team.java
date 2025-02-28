package tournament.data;

import tournament.exceptions.FullTeamException;

public class Team extends Participant
{
    /**
     * Variable for the maximum number of players in case it has to be changed in the future
     */
    //Variable for the maximum number of players in case it has to be changed in the future
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

    /**
     *extra function to get de average ranking of the players of a team, for use it on sorting
     * @see tournament.comparators.TeamRankingComparator
     */
    //extra function
    public double getAveragePlayerRanking(){
        double sum = 0;
        for (Player player : players)
        {
            if (player != null)
                sum += player.getRanking();
        }
        return sum/playerCount;
    }

    /**
     *  generates a string with all the members of the team to implement it on the toString
     */
    @Override
    public String toString()
    {
        String playersString="";
        for (int i = 0; i < playerCount; i++) {
            if (players[i] != null)
            {
                playersString += "\n - " + players[i];
            }
        }
        return super.toString()+" - Members: "+playerCount+"/"+max_players+": "+playersString;
    }

}
