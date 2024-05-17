package main.java.com.gamingstore.model;

import java.util.Objects;

public abstract class Order {
    public static final String CARD = "Card";
    public static final String CASH = "Cash";
    public static final String CREDIT = "Credit";
    private String productName;
    private int totalNumber;
    private String kindOfPay;
    private String cityForDelivery;
    private String numberOfDepartment;
    private String client;

    @Override
    public String toString() {
        return "{productName = " + productName
                + ", totalNumber = " + totalNumber
                + ", kindOfPay = " + kindOfPay
                + ", cityForDelivery = " + cityForDelivery
                + ", numberOfDepartment = " + numberOfDepartment
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(productName, order.productName) && Objects.equals(totalNumber, order.totalNumber) && Objects.equals(kindOfPay, order.kindOfPay) && Objects.equals(cityForDelivery, order.cityForDelivery) && Objects.equals(numberOfDepartment, order.numberOfDepartment) && Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, totalNumber, kindOfPay, cityForDelivery, numberOfDepartment, client);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getKindOfPay() {
        return kindOfPay;
    }

    public void setKindOfPay(String kindOfPay) {
        this.kindOfPay = kindOfPay;
    }

    public String getCityForDelivery() {
        return cityForDelivery;
    }

    public void setCityForDelivery(String cityForDelivery) {
        this.cityForDelivery = cityForDelivery;
    }

    public String getNumberOfDepartment() {
        return numberOfDepartment;
    }

    public void setNumberOfDepartment(String numberOfDepartment) {
        this.numberOfDepartment = numberOfDepartment;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
