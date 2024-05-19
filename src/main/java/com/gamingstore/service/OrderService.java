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
        String kindOfPay = Main.SCANNER.nextLine();
        order.setKindOfPay(Order.KindOfPay.valueOf(kindOfPay));

        System.out.print("City for delivery: ");
        order.setCityForDelivery(Main.SCANNER.nextLine());

        System.out.print("Number of department: ");
        order.setNumberOfDepartment(Main.SCANNER.nextLine());

        System.out.print("Delivery speed: ");
        String deliverySpeed = Main.SCANNER.nextLine();
        order.setDeliverySpeed(Order.DeliverySpeed.valueOf(deliverySpeed));

        if (type.equals(FAN_TYPE)) {
            System.out.print("Kind of power supply: ");
            ((Fan) order).setKindOfPowerSupply(Main.SCANNER.nextLine());
        }

        return order;
    }
}
