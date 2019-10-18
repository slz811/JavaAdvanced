package marketstoresystem;

public class Bronze {
    //no discount rate if the turnover for the previous month < $100.
    // If it is between $100 and $300, the discount rate is 1%.
    // And if it is above $300, the rate is 2.5%.
    private double turnover;
    private double discountRate;

    public Bronze(double turnover) {
        this.turnover = turnover;
        this.discountRate = 0;

    }

    public double getCalculatedDiscountRate() {
        if (this.turnover >= 100 && this.turnover < 300) {
            this.discountRate = 0.01;
        } else if (this.turnover >= 300) {
            this.discountRate = 0.025;
        }
        return this.discountRate;
    }


}
