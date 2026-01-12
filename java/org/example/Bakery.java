package org.example;

public class Bakery extends Beverage {

    public Bakery(String name, String size, double unitPrice) {
        super(name, size, unitPrice);
    }

    @Override
    public double calculatePrice() {
        return super.calculatePrice() + 15;
    }
}
