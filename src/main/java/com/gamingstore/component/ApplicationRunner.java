package main.java.com.gamingstore.component;

public class ApplicationRunner {
    private final EntityRegister register = new EntityRegister();

    public void run() {
        if (Authenticator.auth()) {
            register.registerClients();
        }
    }
}
