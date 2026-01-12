package org.example;

public class Beverage {

    private String name;
    private String size;
    private double unitPrice;

    protected SweetLevel sweetLevel;
    protected Topping topping;

    public Beverage(String name, String size, double basePrice) {
        this.name = name;
        this.size = size;
        this.unitPrice = basePrice;
    }

    public void setSweetLevel(SweetLevel sweetLevel) {
        this.sweetLevel = sweetLevel;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public double calculatePrice() {
        double finalPrice = unitPrice;

        if (size.equals("MEDIUM")) finalPrice += 10;
        else if (size.equals("LARGE")) finalPrice += 20;

        if (topping != null) {
            finalPrice += topping.getPrice();
        }

        return finalPrice;
    }

    public String getName() { return name; }
    public String getSize() { return size; }
    public SweetLevel getSweetLevel() { return sweetLevel; }
    public Topping getTopping() { return topping; }
}
