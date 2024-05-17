package main.java.com.gamingstore;

import main.java.com.gamingstore.comparator.OrderKindOfPayComparator;
import main.java.com.gamingstore.comparator.OrderTotalNumberComparator;
import main.java.com.gamingstore.model.Fan;
import main.java.com.gamingstore.model.Order;
import main.java.com.gamingstore.model.Triggers;

import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args) {
        totalNumberSort();
        kindOfPaySort();
    }

    private static void totalNumberSort() {
        Order[] orders = {
                new Triggers(12),
                new Triggers(1),
                new Triggers(45),
                new Triggers(23)
        };

        Arrays.sort(orders, new OrderTotalNumberComparator());

        for (Order order : orders) {
            System.out.println(order.getTotalNumber());
        }
    }

    private static void kindOfPaySort() {
        Order[] orders = {
                new Fan(Fan.CASH),
                new Fan(Fan.CARD),
                new Fan(Fan.CARD),
                new Fan(Fan.CREDIT),
                new Fan(Fan.CARD),
                new Fan(Fan.CREDIT),
                new Fan(Fan.CASH)
        };

        Arrays.sort(orders, new OrderKindOfPayComparator());

        for (Order order : orders) {
            System.out.println(order.getKindOfPay());
        }
    }
}
