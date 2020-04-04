package model;

public class Game {
    private final int gameID;
    private final String gameName;

    public Game(int gameID, String gameName)
    {
        this.gameID = gameID;
        this.gameName = gameName;
    }

    public int getGameID() {
        return gameID;
    }

    public String getGameName() {
        return gameName;
    }

}
