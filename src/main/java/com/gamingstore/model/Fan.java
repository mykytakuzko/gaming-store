package main.java.com.gamingstore.model;

public class Fan extends Order {
    private String kindOfPowerSupply;

    public String getKindOfPowerSupply() {
        return kindOfPowerSupply;
    }

    public void setKindOfPowerSupply(String kindOfPowerSupply) {
        this.kindOfPowerSupply = kindOfPowerSupply;
    }
}
