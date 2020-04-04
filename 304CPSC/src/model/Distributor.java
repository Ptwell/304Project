package model;

public class Distributor {
    private final String distributorName;
    private final String paymentMethod;

    public Distributor(String distributorName, String paymentMethod)
    {
        this.distributorName = distributorName;
        this.paymentMethod = paymentMethod;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
}
