package model;

public class DLC {
    private final String dlcName;
    private final int gameID;
    private final int price;

    public DLC(String dlcName, int gameID, int price)
    {
        this.dlcName = dlcName;
        this.gameID = gameID;
        this.price = price;
    }

    public int getGameID() {
        return gameID;
    }

    public int getPrice() {
        return price;
    }

    public String getDlcName() {
        return dlcName;
    }
}
