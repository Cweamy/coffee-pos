package org.example;

public class Coffee extends Beverage {
    private String roastLevel;

    public Coffee(String name, String size, double price, String roastLevel) {
        super(name, size, price);
        this.roastLevel = roastLevel;
    }

    public String getRoastLevel() {
        return roastLevel;
    }
}
