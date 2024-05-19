package main.java.com.gamingstore.model;

public class Triggers extends Order {
    public Triggers() {}
    public Triggers(int totalNumber) {
        setTotalNumber(totalNumber);
    }
    public Triggers(DeliverySpeed deliverySpeed) {
        setDeliverySpeed(deliverySpeed);
    }
    public Triggers(KindOfPay kindOfPay) {
        setKindOfPay(kindOfPay);
    }
}
