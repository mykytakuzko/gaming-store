package main.java.com.gamingstore.component;

import main.java.com.gamingstore.Main;
import main.java.com.gamingstore.model.Client;
import main.java.com.gamingstore.model.Order;
import main.java.com.gamingstore.service.ClientService;
import main.java.com.gamingstore.service.OrderService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRegister {
    private final ClientService clientService = new ClientService();
    private final OrderService orderService = new OrderService();

    public void registerClients() {
        List<Client> clients = new ArrayList<>();

        String message = "Do you want to register more clients? (y/n): ";
        do {
            Client client = addClient();
            if (client != null) {
                clients.add(client);
            }
        } while (verifyRepeating(message));

        Map<Client.Location, List<Client>> clientsByLocation = groupClients(clients);
        printClients(clientsByLocation);
    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for (Map.Entry<Client.Location, List<Client>> clients : clientsByLocation.entrySet()) {
            String content = "\nLocation: " + clients.getKey()
                    + "\nClients (" + clients.getValue().size() + "):"
                    + "\n\t" + clients.getValue();

            System.out.println(content);
        }
    }

    private Map<Client.Location, List<Client>> groupClients(List<Client> clients) {
        List<Client> fromKyiv = new ArrayList<>();
        List<Client> fromLviv = new ArrayList<>();
        List<Client> fromOdesa = new ArrayList<>();
        List<Client> unknownLocation = new ArrayList<>();

        for (Client client : clients) {
            switch (client.getLocation()) {
                case KYIV -> fromKyiv.add(client);
                case LVIV -> fromLviv.add(client);
                case ODESA -> fromOdesa.add(client);
                case UNKNOWN -> unknownLocation.add(client);
            }
        }

        Map<Client.Location, List<Client>> clientsByLocation = new HashMap<>();
        clientsByLocation.put(Client.Location.KYIV, fromKyiv);
        clientsByLocation.put(Client.Location.LVIV, fromLviv);
        clientsByLocation.put(Client.Location.ODESA, fromOdesa);
        clientsByLocation.put(Client.Location.UNKNOWN, unknownLocation);

        return clientsByLocation;
    }

    private Client addClient() {
        Client client = clientService.registerNewClient();

        if (client != null) {
            System.out.print("Do you want to add an order? (Yes / No): ");
            String answer = Main.SCANNER.nextLine();

            if (answer.equals("Yes")) {
                registerOrders(client);
            }

            System.out.println(client);
        }

        return client;
    }

    private void registerOrders(Client client) {
        String message = "Do you want to add more orders for the current client? (y/n): ";

        do {
            addOrder(client);
        } while (verifyRepeating(message));
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

    private boolean verifyRepeating(String message) {
        System.out.println(message);

        String answer = Main.SCANNER.nextLine();
        if ("y".equals(answer)) {
            return true;
        } else if("n".equals(answer)) {
            return false;
        } else {
            System.out.println("Incorrect answer. Please try again.");
            return verifyRepeating(message);
        }
    }
}
