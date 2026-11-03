public class BILL_ORDER {

    public static double OUT(PIZZA order) {
        System.out.println("You ordered for " + order.getToppings() + " Pizza with the size of " + order.getDiameter() + " centimeter" + " for PHP" + (int)order.getPrice() + ".");
        return order.getPrice();
    }




}
