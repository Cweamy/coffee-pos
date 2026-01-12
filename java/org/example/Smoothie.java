package org.example;

public class Smoothie extends Beverage {
    public Smoothie( String name, String size, double unitPrice) {
        super(name, size, unitPrice);
    }

    @Override
    public double calculatePrice() {
        return super.calculatePrice() + 20;
    }
}
