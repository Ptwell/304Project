package model;

public class Platform {
    private final String brand;
    private final String deviceType;
    private final String control;

    public Platform (String brand, String deviceType, String control )
    {
        this.brand = brand;
        this.deviceType = deviceType;
        this.control = control;
    }

    public String getBrand() {
        return brand;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getControl() {
        return control;
    }

}
