package model;

public class TeamsWorkAt {
    private final int tID;
    private final String position;
    private final String companyName;

    public TeamsWorkAt(int tID, String position, String companyName) {
        this.companyName = companyName;
        this.position = position;
        this.tID = tID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int gettID() {
        return tID;
    }

    public String getPosition() {
        return position;
    }
}
