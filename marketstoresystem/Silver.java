package marketstoresystem;

public class Silver {
    //an initial discount rate of 2%.
    // In case, the turnover is over $300, the rate is 3.5%.
    private double turnover;
    private double discountRate;

    public Silver(double turnover) {
        this.turnover = turnover;
        this.discountRate = 0.02;
    }

    public double getCalculatedDiscountRate() {

        if (this.turnover > 300) {
            this.discountRate = 0.035;
        }
        return this.discountRate;
    }



}
