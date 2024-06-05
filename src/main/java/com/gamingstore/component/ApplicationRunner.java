package main.java.com.gamingstore.component;

import main.java.com.gamingstore.Main;
import main.java.com.gamingstore.model.Client;
import main.java.com.gamingstore.model.Order;
import main.java.com.gamingstore.service.ClientService;
import main.java.com.gamingstore.service.OrderService;

public class ApplicationRunner {
    private final ClientService clientService = new ClientService();
    private final OrderService orderService = new OrderService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) {
                System.out.print("Do you want to add an order? (Yes / No): ");
                String answer = Main.SCANNER.nextLine();

                if (answer.equals("Yes")) {
                    registerOrders(client);
                }

                System.out.println(client);
            }
        }
    }

    private void registerOrders(Client client) {
        boolean continueAddOrders = true;

        while (continueAddOrders) {
            addOrder(client);

            System.out.print("Do you want to add more orders for the current client? (y/n): ");
            String answer = Main.SCANNER.nextLine();

            if ("n".equals(answer)) {
                continueAddOrders = false;
            }
        }
    }

    private void addOrder (Client client) {
        System.out.println("Adding a new order.");

        Order order = orderService.registerNewOrder();
        if (order != null) {
            client.addOrder(order);
            order.setClient(client.getFirstName() + " " + client.getLastName());
            System.out.println("Order has been added.");
        }
    }
}
