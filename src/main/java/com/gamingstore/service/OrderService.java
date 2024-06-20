package main.java.com.gamingstore.service;

import main.java.com.gamingstore.Main;
import main.java.com.gamingstore.model.Fan;
import main.java.com.gamingstore.model.Order;
import main.java.com.gamingstore.model.Triggers;

public class OrderService {
    private static final String FAN_TYPE = "Fan";
    private static final String TRIGGERS_TYPE = "Triggers";

    public Order registerNewOrder() {
        Order order = null;

        System.out.print("Type (Fan / Triggers): ");
        String type = Main.SCANNER.nextLine();

        if (FAN_TYPE.equals(type) || TRIGGERS_TYPE.equals(type)) {
            order = buildOrder(type);
        } else {
            System.out.println("Unknown type: " + type);
        }

        return order;
    }

    private Order buildOrder(String type) {
        Order order = type.equals(TRIGGERS_TYPE) ? new Triggers() : new Fan();
        order.setProductName(type);

        System.out.print("Total number: ");
        order.setTotalNumber(Main.SCANNER.nextInt());
        Main.SCANNER.nextLine();

        System.out.print("Kind of pay (CARD / CASH / CREDIT): ");

        Order.KindOfPay kindOfPay;
        String kindOfPayInput = Main.SCANNER.nextLine();

        try {
            kindOfPay = Order.KindOfPay.valueOf(kindOfPayInput);
        } catch (IllegalArgumentException e) {
            kindOfPay = Order.KindOfPay.UNKNOWN;
            System.out.println("Unable to parse value: '" + kindOfPayInput
                    + "'. Using default value: " + Order.KindOfPay.UNKNOWN);
        }

        order.setKindOfPay(kindOfPay);

        System.out.print("City for delivery: ");
        order.setCityForDelivery(Main.SCANNER.nextLine());

        System.out.print("Number of department: ");
        order.setNumberOfDepartment(Main.SCANNER.nextLine());

        System.out.print("Delivery speed: ");

        Order.DeliverySpeed deliverySpeed;
        String deliverySpeedInput = Main.SCANNER.nextLine();

        try {
            deliverySpeed = Order.DeliverySpeed.valueOf(deliverySpeedInput);
        } catch (IllegalArgumentException e) {
            deliverySpeed = Order.DeliverySpeed.UNKNOWN;
            System.out.println("Unable to parse value: '" + deliverySpeedInput
                    + "'. Using default value: " + Order.DeliverySpeed.UNKNOWN);
        }

        order.setDeliverySpeed(deliverySpeed);

        if (type.equals(FAN_TYPE)) {
            System.out.print("Kind of power supply: ");
            ((Fan) order).setKindOfPowerSupply(Main.SCANNER.nextLine());
        }

        return order;
    }
}
