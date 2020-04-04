package model;

public class Person {
    private final String name;
    private final int SIN;
    private final String email;

    public Person(String name, String email, int SIN)
    {
        this.email = email;
        this.name = name;
        this.SIN = SIN;
    }

    public int getSIN() {
        return SIN;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
