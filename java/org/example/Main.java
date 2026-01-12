package org.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        // ===== Main Menu =====
        String[] menuOptions = {
                "1. Coffee",
                "2. Tea",
                "3. Smoothie",
                "4. Bakery"
        };

        String selectedChoice = (String) JOptionPane.showInputDialog(
                null,
                "Please select the category:",
                "847 CAFE",
                JOptionPane.PLAIN_MESSAGE,
                null,
                menuOptions,
                menuOptions[0]
        );
        if (selectedChoice == null) return;

        // ===== Size =====
        String[] sizeOptions = {"SMALL", "MEDIUM", "LARGE"};
        String size = (String) JOptionPane.showInputDialog(
                null,
                "Select size:",
                "Size",
                JOptionPane.QUESTION_MESSAGE,
                null,
                sizeOptions,
                sizeOptions[0]
        );
        if (size == null) return;

        Beverage order = null;

        // ================= COFFEE =================
        if (selectedChoice.startsWith("1")) {

            String[] coffeeMenu = {"Americano", "Latte", "Cappuccino"};
            String coffeeName = (String) JOptionPane.showInputDialog(
                    null,
                    "Select coffee:",
                    "Coffee Menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    coffeeMenu,
                    coffeeMenu[0]
            );
            if (coffeeName == null) return;

            String[] roastLevels = {"Light", "Medium", "Dark"};
            String roast = (String) JOptionPane.showInputDialog(
                    null,
                    "Select roast level:",
                    "Roast Level",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    roastLevels,
                    roastLevels[1]
            );
            if (roast == null) return;

            Coffee coffee = new Coffee(coffeeName, size, 50, roast);

            // Sweet level
            coffee.setSweetLevel(selectSweetLevel());

            // Coffee topping
            coffee.setTopping(selectCoffeeTopping());

            order = coffee;
        }

        // ================= TEA =================
        else if (selectedChoice.startsWith("2")) {

            Tea tea = new Tea("Matcha Latte", size, 60);

            tea.setSweetLevel(selectSweetLevel());
            tea.setTopping(selectTeaTopping());

            order = tea;
        }

        // ================= SMOOTHIE =================
        else if (selectedChoice.startsWith("3")) {

            String fruit = JOptionPane.showInputDialog(
                    null,
                    "Select fruit:\n(Orange / Banana / Watermelon)",
                    "Smoothie",
                    JOptionPane.QUESTION_MESSAGE
            );
            if (fruit == null || fruit.isEmpty()) return;

            Smoothie smoothie = new Smoothie(fruit + " Smoothie", size, 80);

            smoothie.setSweetLevel(selectSweetLevel());
            smoothie.setTopping(selectSmoothieTopping());

            order = smoothie;
        }

        // ================= BAKERY =================
        else if (selectedChoice.startsWith("4")) {

            String[] bakeryMenu = {"Croissant", "Muffin", "Cheesecake"};
            String bakeryName = (String) JOptionPane.showInputDialog(
                    null,
                    "Select bakery:",
                    "Bakery Menu",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    bakeryMenu,
                    bakeryMenu[0]
            );
            if (bakeryName == null) return;

            order = new Bakery(bakeryName, size, 40);
        }

        // ================= SUMMARY =================
        if (order != null) {
            String msg = "Order Summary\n";
            msg += "------------------------\n";
            msg += "Item  : " + order.getName() + "\n";
            msg += "Size  : " + order.getSize() + "\n";

            if (order.getSweetLevel() != null) {
                msg += "Sweet : " + order.getSweetLevel().getLevel() + "\n";
            }

            if (order.getTopping() != null) {
                msg += "Topping : " + order.getTopping().getName() + "\n";
            }

            if (order instanceof Coffee) {
                msg += "Roast : " + ((Coffee) order).getRoastLevel() + "\n";
            }

            msg += "------------------------\n";
            msg += "Total : " + order.calculatePrice() + " Baht";

            JOptionPane.showMessageDialog(
                    null,
                    msg,
                    "Order",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // ===== Sweet Level =====
    private static SweetLevel selectSweetLevel() {
        String[] levels = {
                "0% (No Sugar)",
                "25%",
                "50%",
                "75%",
                "100%"
        };

        String level = (String) JOptionPane.showInputDialog(
                null,
                "Select sweetness:",
                "Sweet Level",
                JOptionPane.QUESTION_MESSAGE,
                null,
                levels,
                levels[2]
        );
        if (level == null) return null;

        return new SweetLevel(level);
    }

    // ===== Coffee Topping =====
    private static Topping selectCoffeeTopping() {
        String[] options = {
                "No Topping",
                "Extra Shot (+15)",
                "Whipped Cream (+10)",
                "Chocolate Syrup (+10)"
        };

        String choice = (String) JOptionPane.showInputDialog(
                null,
                "Select coffee topping:",
                "Topping",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == null || choice.equals("No Topping")) return null;
        if (choice.contains("15")) return new CoffeeTopping("Extra Shot", 15);
        return new CoffeeTopping(choice.replace(" (+10)", ""), 10);
    }

    // ===== Tea Topping =====
    private static Topping selectTeaTopping() {
        String[] options = {
                "No Topping",
                "Pearl (+15)",
                "Grass Jelly (+10)",
                "Milk Foam (+10)"
        };

        String choice = (String) JOptionPane.showInputDialog(
                null,
                "Select tea topping:",
                "Topping",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == null || choice.equals("No Topping")) return null;
        if (choice.contains("15")) return new TeaTopping("Pearl", 15);
        return new TeaTopping(choice.replace(" (+10)", ""), 10);
    }

    // ===== Smoothie Topping =====
    private static Topping selectSmoothieTopping() {
        String[] options = {
                "No Topping",
                "Boba (+15)",
                "Jelly (+10)",
                "Chia Seed (+10)"
        };

        String choice = (String) JOptionPane.showInputDialog(
                null,
                "Select smoothie topping:",
                "Topping",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == null || choice.equals("No Topping")) return null;
        if (choice.contains("15")) return new SmoothieTopping("Boba", 15);
        return new SmoothieTopping(choice.replace(" (+10)", ""), 10);
    }
}
