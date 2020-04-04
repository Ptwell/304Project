package model;

public class Account {
    private final String username;
    private final String password;
    private final String email;
    private final String personName;
    private final int SIN;

    public Account(String username, String password, String email, String personName, int SIN)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.personName = personName;
        this.SIN = SIN;
    }

    public String getUsername() {
        return username;
    }

    public int getSIN() {
        return SIN;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPersonName() {
        return personName;
    }

}
