package main.java.com.gamingstore.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Order {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private String productName;
    private int totalNumber;
    private KindOfPay kindOfPay;
    private String cityForDelivery;
    private String numberOfDepartment;
    private DeliverySpeed deliverySpeed;
    private String client;
    private final LocalDateTime registrationDate = LocalDateTime.now();

    @Override
    public String toString() {
        return "{productName = " + productName
                + ", totalNumber = " + totalNumber
                + ", kindOfPay = " + kindOfPay
                + ", cityForDelivery = " + cityForDelivery
                + ", numberOfDepartment = " + numberOfDepartment
                + ", deliverySpeed = " + deliverySpeed
                + ", registrationDate = " + registrationDate.format(FORMATTER)
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return totalNumber == order.totalNumber && Objects.equals(productName, order.productName)
                && kindOfPay == order.kindOfPay
                && Objects.equals(cityForDelivery, order.cityForDelivery)
                && Objects.equals(numberOfDepartment, order.numberOfDepartment)
                && deliverySpeed == order.deliverySpeed
                && Objects.equals(client, order.client)
                && Objects.equals(registrationDate, order.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, totalNumber, kindOfPay, cityForDelivery, numberOfDepartment, deliverySpeed
                , client, registrationDate);
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

    public KindOfPay getKindOfPay() {
        return kindOfPay;
    }

    public void setKindOfPay(KindOfPay kindOfPay) {
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

    public DeliverySpeed getDeliverySpeed() {
        return deliverySpeed;
    }

    public void setDeliverySpeed(DeliverySpeed deliverySpeed) {
        this.deliverySpeed = deliverySpeed;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public enum KindOfPay {
        CARD(1),
        CASH(2),
        CREDIT(3),
        UNKNOWN(0);

        private final int value;

        KindOfPay(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum DeliverySpeed {
        FAST(1),
        STANDARD_PLUS(2),
        STANDARD(3),
        UNKNOWN(0);

        private final int value;

        DeliverySpeed(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
