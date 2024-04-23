package main.java.com.gamingstore.component;

import main.java.com.gamingstore.Main;
import main.java.com.gamingstore.model.Client;
import main.java.com.gamingstore.model.Order;
import main.java.com.gamingstore.service.ClientService;
import main.java.com.gamingstore.service.OrderService;

public class ApplicationRunner {
    private ClientService clientService = new ClientService();
    private OrderService orderService = new OrderService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();

            System.out.print("Do you want to add an order? (Yes / No): ");
            String answer = Main.SCANNER.nextLine();

            if (client != null && answer.equals("Yes")) {
                System.out.println("Adding a new order.");

                Order order = orderService.registerNewOrder();
                client.setOrder(order);
                order.setClient(client.getFirstName() + " " + client.getLastName());
                System.out.println("Order has been added.");
            }
        }
    }
}
