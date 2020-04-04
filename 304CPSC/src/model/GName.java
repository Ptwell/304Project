package model;

public class GName {
    private final String gameName;
    private final int gameYear;
    private final String genre;
    public GName(String gameName, int gameYear, String genre)
    {
        this.gameName = gameName;
        this.gameYear = gameYear;
        this.genre = genre;
    }

    public String getGameName() {
        return gameName;
    }

    public int getGameYear() {
        return gameYear;
    }

    public String getGenre() {
        return genre;
    }
}
