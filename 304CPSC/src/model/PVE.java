package model;

public class PVE {
    private final int gameID;
    private final int numberOfPlyaer;
    private final String difficulty;
    private final String competitiveOrCasual;

    public PVE (int gameID, int numberOfPlyaer, String difficulty, String competitiveOrCasual)
    {
        this.competitiveOrCasual = competitiveOrCasual;
        this.difficulty = difficulty;
        this.gameID = gameID;
        this.numberOfPlyaer = numberOfPlyaer;
    }

    public int getGameID() {
        return gameID;
    }

    public int getNumberOfPlyaer() {
        return numberOfPlyaer;
    }

    public String getCompetitiveOrCasual() {
        return competitiveOrCasual;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
