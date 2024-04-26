package main.java.com.gamingstore.model;

import java.util.Objects;

public class Fan extends Order {
    private String kindOfPowerSupply;

    public String toString() {
        return super.toString().substring(0, super.toString().length() - 1)
                + ", kindOfPowerSupply = " + kindOfPowerSupply + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fan fan = (Fan) o;
        return Objects.equals(kindOfPowerSupply, fan.kindOfPowerSupply);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), kindOfPowerSupply);
    }

    public String getKindOfPowerSupply() {
        return kindOfPowerSupply;
    }

    public void setKindOfPowerSupply(String kindOfPowerSupply) {
        this.kindOfPowerSupply = kindOfPowerSupply;
    }
}
