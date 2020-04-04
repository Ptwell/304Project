package model;

public class Company {
    private final String companyName;
    private final String location;

    public Company(String companyName, String location)
    {
        this.companyName = companyName;
        this.location = location;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }
}
