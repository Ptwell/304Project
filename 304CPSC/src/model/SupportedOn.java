package model;

public class SupportedOn {
    private final String brand;
    private final String hardwareDeviceType;
    private int gameID;

    public SupportedOn(String brand, String hardwareDeviceType, int gameID){
        this.brand =brand;
        this.gameID = gameID;
        this. hardwareDeviceType = hardwareDeviceType;
    }

    public int getGameID() {
        return gameID;
    }

    public String getBrand() {
        return brand;
    }

    public String getHardwareDeviceType() {
        return hardwareDeviceType;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }
}
