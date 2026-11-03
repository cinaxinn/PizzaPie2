import javax.swing.*;
import java.util.Scanner;

public class TAKE_ORDER {
    public static void main(String[] args) {

        String[] toppings = {"", "Pepperoni", "Ham and Cheese", "Hawaiian"};
        String[] discounts = {"N/A", "Senior-PWD", "VIP"};
        String topping;
        String howMany;
        String diameter;
        String VIPCard = "";
        int confirmation = 0;
        String payment;
        double money = 0;

        PIZZA PIE = new PIZZA();

        // pizza details input
        while (true) {
            try {
                do {
                    do {
                        topping = (String) JOptionPane.showInputDialog(null, "Choose Toppings", "Pizza Program", JOptionPane.QUESTION_MESSAGE, null, toppings, toppings[0]);
                        if (topping == null) {
                            confirmation = JOptionPane.showConfirmDialog(null, "Want to CANCEL the order?", "Confirm Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (confirmation == JOptionPane.YES_OPTION) {
                                JOptionPane.showMessageDialog(null, "Thank you!", "Message", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }
                        } else if (topping.equals("")) {
                            JOptionPane.showMessageDialog(null, "Invalid option for topping!\nPlease select from the three provided", "Invalid topping!", JOptionPane.WARNING_MESSAGE);
                        }
                    } while (topping == null || topping.equals(""));
                    PIE.setToppings(topping);
                    JOptionPane.showMessageDialog(null, "You chose " + PIE.getToppings() + "\nwhich cost additional " + String.format("%.0f", PIE.getAdditional()) + "php!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    confirmation = JOptionPane.showConfirmDialog(null, "Are you sure?\nYou want " + PIE.getToppings() + "?", "Confirm Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                } while (confirmation != JOptionPane.YES_OPTION);

                do {
                    diameter = JOptionPane.showInputDialog(null, "Enter Diameter in inches", "Input", JOptionPane.QUESTION_MESSAGE);
                    if (diameter == null) {
                        confirmation = JOptionPane.showConfirmDialog(null, "Want to CANCEL the order?", "Confirm Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (confirmation == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Thank you!", "Message", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                } while (diameter == null);

                PIE.setDiameter(Integer.parseInt(diameter));

                do {
                    howMany = JOptionPane.showInputDialog(null, "Enter How Many?", "Input", JOptionPane.QUESTION_MESSAGE);
                    if (howMany == null) {
                        confirmation = JOptionPane.showConfirmDialog(null, "Want to CANCEL the order?", "Confirm Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (confirmation == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Thank you!", "Message", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                } while (howMany == null);

                PIE.setHowMany(Integer.parseInt(howMany));
                int index;
                do {
                    index = JOptionPane.showOptionDialog(null, "Choose Discount:", "Pizza Program", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, discounts, discounts[0]);
                    if (index == -1) {
                        confirmation = JOptionPane.showConfirmDialog(null, "Want to CANCEL the order?", "Confirm Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (confirmation == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Thank you!", "Message", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                } while (index == -1);

                PIE.setDiscount(discounts[index]);

                if (index != 0) {
                    do {
                        VIPCard = (JOptionPane.showInputDialog(null, "Enter " + discounts[index] + " Card Number:", "Input", JOptionPane.QUESTION_MESSAGE));
                        if (VIPCard == null) {
                            confirmation = JOptionPane.showConfirmDialog(null, "Want to CANCEL the order?", "Confirm Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (confirmation == JOptionPane.YES_OPTION) {
                                JOptionPane.showMessageDialog(null, "Thank you!", "Message", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }
                        }
                    } while (VIPCard == null);
                    PIE.setCardNumber(Integer.parseInt(VIPCard));
                }


                // output + payment details
                JOptionPane.showMessageDialog(null, "You ordered for " + PIE.getToppings() + " Pizza with the size of " + PIE.getDiameter() + " centimeters for the total price of PHP" + String.format("%.2f", PIE.getPrice()), "Message", JOptionPane.INFORMATION_MESSAGE);
                do {
                    do {
                        payment = (JOptionPane.showInputDialog(null, "Enter Amount:", "Input", JOptionPane.INFORMATION_MESSAGE));
                        if (payment == null) {
                            confirmation = JOptionPane.showConfirmDialog(null, "Want to CANCEL the order?", "Confirm Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (confirmation == JOptionPane.YES_OPTION) {
                                JOptionPane.showMessageDialog(null, "Thank you!", "Message", JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }

                        }
                    } while (payment == null);

                    money = Double.parseDouble(payment);

                    if (money < PIE.getPrice()) {
                        JOptionPane.showMessageDialog(null, "Insufficient Amount.", "Warning!", JOptionPane.WARNING_MESSAGE);
                    }
                } while (money < PIE.getPrice());
                JOptionPane.showMessageDialog(null, "Your CHANGE is Php" + String.format("%.2f", money-PIE.getPrice()), "Message", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Thank you!", "Message", JOptionPane.INFORMATION_MESSAGE);

                return;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An error has occurred, restarting the order.");
            }
        }


    }
}


