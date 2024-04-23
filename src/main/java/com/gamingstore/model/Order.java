package main.java.com.gamingstore.model;

public class Order {
    private String productName;
    private String totalNumber;
    private String kindOfPay;
    private String cityForDelivery;
    private String numberOfDepartment;
    private String client;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(String totalNumber) {
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
