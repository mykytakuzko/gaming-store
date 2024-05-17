package main.java.com.gamingstore.comparator;

import main.java.com.gamingstore.model.Order;

import java.util.Comparator;

public class OrderTotalNumberComparator implements Comparator<Order> {
    @Override
    public int compare(Order order1, Order order2) {
        return order1.getTotalNumber() - order2.getTotalNumber();
    }
}
