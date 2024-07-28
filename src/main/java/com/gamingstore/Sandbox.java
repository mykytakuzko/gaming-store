package main.java.com.gamingstore;

import main.java.com.gamingstore.model.Client;
import main.java.com.gamingstore.model.Fan;
import main.java.com.gamingstore.model.Order;
import main.java.com.gamingstore.model.Triggers;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {
    public static void main(String[] args) {
        Order order = null;
        System.out.println(order);
    }

    private static void totalNumberSort() {
        Order[] orders = {
                new Triggers(12),
                new Fan(1),
                new Triggers(45),
                new Triggers(23)
        };

        Arrays.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getTotalNumber() - o2.getTotalNumber();
            }
        });

        for (Order order : orders) {
            System.out.println(order.getTotalNumber());
        }
    }

    private static void kindOfPaySort() {
        Order[] orders = {
                new Fan(Fan.KindOfPay.CASH),
                new Fan(Fan.KindOfPay.CARD),
                new Fan(Fan.KindOfPay.CARD),
                new Triggers(Triggers.KindOfPay.CREDIT),
                new Fan(Fan.KindOfPay.CARD),
                new Fan(Fan.KindOfPay.CREDIT),
                new Fan(Fan.KindOfPay.CASH)
        };

        Arrays.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getKindOfPay().getValue() - o2.getKindOfPay().getValue();
            }
        });

        for (Order order : orders) {
            System.out.println(order.getKindOfPay());
        }
    }

    private static void deliverySpeedSort() {
        Order[] orders = {
                new Triggers(Order.DeliverySpeed.STANDARD_PLUS),
                new Fan(Order.DeliverySpeed.STANDARD),
                new Triggers(Order.DeliverySpeed.STANDARD_PLUS),
                new Fan(Order.DeliverySpeed.FAST),
                new Fan(Order.DeliverySpeed.STANDARD_PLUS),
                new Triggers(Order.DeliverySpeed.FAST)
        };

        Arrays.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getDeliverySpeed().getValue() - o2.getDeliverySpeed().getValue();
            }
        });

        for (Order order : orders) {
            System.out.println(order.getDeliverySpeed());
        }
    }
}
