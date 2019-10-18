package marketstoresystem;

public class PayDesk {
    //discount rate, the discount and the total purchase value;
    private static final String bronzeTier = "Bronze";
    private static final String silverTier = "Silver";
    private static final String goldTier = "Gold";
    private String tierLevel;
    private double turnover;
    private double purchase;
    private double discountRate;

    public PayDesk(String tierLevel, double turnover, double purchase) {
        this.tierLevel = tierLevel;
        this.turnover = turnover;
        this.purchase = purchase;
        this.discountRate = 0;
    }

    public static String getTierLevel(String tierLevel) {
        return tierLevel;
    }

    private static double getPurchase(double purchase) {
        return purchase;
    }

    public static double getTurnover(double turnover) {
        return turnover;
    }

    public static double getDiscountRate(String tierLevel, double turnover) {
        double discountRate = 0;
        switch (tierLevel) {
            case bronzeTier:
                Bronze bronze = new Bronze(turnover);
                discountRate = bronze.getCalculatedDiscountRate();
                break;
            case silverTier:
                Silver silver = new Silver(turnover);
                discountRate = silver.getCalculatedDiscountRate();
                break;
            case goldTier:
                Gold gold = new Gold(turnover);
                discountRate = gold.getCalculatedDiscountRate();
                break;
        }
        return discountRate;
    }

    private static double getCalculatedDiscount(String tierLevel, double turnover, double purchase) {
        return purchase * getDiscountRate(tierLevel, turnover);
    }

    private static double getTotalPayment(String tierLevel, double turnover, double purchase) {
        return getPurchase(purchase) - getCalculatedDiscount(tierLevel, turnover, purchase);
    }

    @Override
    public String toString() {
        return String.format("Purchase value: $%.2f%nDiscount rate: %.1f%%%nDiscount: $%.2f%nTotal: $%.2f%n",
                getPurchase(this.purchase), getDiscountRate(getTierLevel(this.tierLevel), getTurnover(this.turnover)) * 100,
                getCalculatedDiscount(this.tierLevel, this.turnover, this.purchase), getTotalPayment(this.tierLevel, this.turnover, this.purchase));

//Output:
//
//Purchase value: $150.00
//
//Discount rate: 0.0%
//
//Discount: $0.00
//
//Total: $150.00
    }
}
