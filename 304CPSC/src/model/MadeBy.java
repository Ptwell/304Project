package model;

public class MadeBy
{
    private final String companyName;
    private final int gameID;
    public MadeBy(String companyName, int gameID)
    {
        this.companyName = companyName;
        this.gameID = gameID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getGameID() {
        return gameID;
    }
}
