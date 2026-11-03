public class PIZZA {
    private String toppings;
    private String discount;
    private int diameter;
    private int howMany;
    private double price;
    private double additional;
    private int cardNumber;

    public void setToppings(String toppings) {
        this.toppings = toppings;

        switch (this.toppings.toLowerCase()) {
            case "pepperoni":
                additional = 100;
                break;
            case "ham and cheese":
                additional = 150;
                break;
            case "hawaiian":
                additional = 200;
                break;
        }
    }

    public void setDiameter(int diameter) {
        this.diameter = (int)Math.round(diameter*2.54);
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getToppings() {
        return this.toppings;
    }

    public int getDiameter() {
        return this.diameter;
    }

    public double getAdditional() {
        return this.additional;
    }

    public double getPrice() {
        double price = 0;
        switch (this.toppings.toLowerCase()) {
            case "pepperoni":
                price = 100;
                additional = 100;
                break;
            case "ham and cheese":
                price = 150;
                additional = 150;
                break;
            case "hawaiian":
                price = 200;
                additional = 200;
                break;
        }

        price += 5*this.diameter;
        price *= this.howMany;

        switch (this.discount.toLowerCase()) {
            case "senior-pwd":
                price = price*0.8;
                break;
            case "vip":
                price = price*0.88;
                break;
            case "n/a":
                break;
        }

        this.price = price;

        return this.price;
    }

}


