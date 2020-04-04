package model;

public class Position {
    private final String position;
    private final int salary;

    public Position (String position, int salary)
    {
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }
}
