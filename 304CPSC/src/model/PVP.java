package model;

public class PVP {
    private final int gameID;
    private final int numberOfPlayer;

    public PVP(int gameID, int numberOfPlayer)
    {
        this.gameID = gameID;
        this.numberOfPlayer = numberOfPlayer;
    }

    public int getGameID() {
        return gameID;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }
}
