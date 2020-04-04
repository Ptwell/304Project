package model;

public class profileHas {
    private final int profileID;
    private final int gameTime;
    private final String dateCreated;
    private final String name;
    private final String username;

    public profileHas(int profileID, int gameTime, String dateCreated, String name, String username){
        this.dateCreated = dateCreated;
        this.gameTime = gameTime;
        this.name =name;
        this.profileID = profileID;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public int getGameTime() {
        return gameTime;
    }

    public int getProfileID() {
        return profileID;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getUsername() {
        return username;
    }
}
