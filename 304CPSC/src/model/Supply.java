package model;

public class Supply {
    private final String username;
    private final String companyName;

    public Supply(String username, String companyName)
    {
        this.companyName = companyName;
        this.username = username;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getUsername() {
        return username;
    }
}
