package main.java.com.gamingstore.comparator;

import main.java.com.gamingstore.model.Order;

import java.util.Comparator;

public class OrderKindOfPayComparator implements Comparator<Order> {
    @Override
    public int compare(Order order1, Order order2) {
        return convertKindOfPay(order1.getKindOfPay()) - convertKindOfPay(order2.getKindOfPay());
    }

    private static int convertKindOfPay(String kindOfPay) {
        return switch (kindOfPay) {
            case Order.CARD -> 1;
            case Order.CASH -> 2;
            case Order.CREDIT -> 3;
            default -> 0;
        };
    }
}
