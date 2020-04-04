package model;

public class Consume {
    private final String name;
    private final int SIN;
    private final int gameID;

    public Consume(String name, int SIN, int gameID)
    {
        this.gameID =gameID;
        this.SIN = SIN;
        this. name = name;
    }

    public String getName() {
        return name;
    }

    public int getSIN() {
        return SIN;
    }

    public int getGameID() {
        return gameID;
    }
}
