package main.java.com.gamingstore.service;

import main.java.com.gamingstore.Main;
import main.java.com.gamingstore.model.Fan;
import main.java.com.gamingstore.model.Order;

public class OrderService {
    private static final String FAN_TYPE = "Fan";

    public Order registerNewOrder() {
        Order order = new Order();

        System.out.print("Fan / Triggers / Other: ");
        String type = Main.SCANNER.nextLine();

        if (FAN_TYPE.equals(type)) {
            order = buildFan();
        } else {
            order = buildOrder(type);
        }

        return order;
    }

    private Fan buildFan() {
        Order order = buildOrder(FAN_TYPE);
        Fan fan = orderToFan(order);

        System.out.print("Kind of power supply: ");
        fan.setKindOfPowerSupply(Main.SCANNER.nextLine());

        return fan;
    }

    private Fan orderToFan(Order order) {
        Fan fan = new Fan();
        fan.setProductName(order.getProductName());
        fan.setTotalNumber(order.getTotalNumber());
        fan.setKindOfPay(order.getKindOfPay());
        fan.setCityForDelivery(order.getCityForDelivery());
        fan.setNumberOfDepartment(order.getNumberOfDepartment());

        return fan;
    }

    private Order buildOrder(String type) {
        Order order = new Order();
        order.setProductName(type);

        System.out.print("Total number: ");
        order.setTotalNumber(Main.SCANNER.nextLine());

        System.out.print("Kind of pay: ");
        order.setKindOfPay(Main.SCANNER.nextLine());

        System.out.print("City for delivery: ");
        order.setCityForDelivery(Main.SCANNER.nextLine());

        System.out.print("Number of department: ");
        order.setNumberOfDepartment(Main.SCANNER.nextLine());

        return order;
    }
}
