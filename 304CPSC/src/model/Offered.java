package model;

public class Offered {
    private final int gameID;
    private final String distributorName;
    private final int priceGiven;
    private final String publisher;

    public Offered(int gameID, String distributorName, int priceGiven, String publisher)
    {
        this.distributorName = distributorName;
        this.gameID = gameID;
        this.priceGiven = priceGiven;
        this. publisher = publisher;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public int getGameID() {
        return gameID;
    }

    public int getPriceGiven() {
        return priceGiven;
    }

    public String getPublisher() {
        return publisher;
    }
}
