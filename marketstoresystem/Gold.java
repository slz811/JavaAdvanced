package marketstoresystem;

public class Gold {
    //an initial discount rate of 2%.
// The discount rate grows 1% for each $100 from the turnover, capping at 10%.
    private double turnover;
    private double discountRate;


    public Gold(double turnover) {
        this.turnover = turnover;
        this.discountRate = 0.02;
    }

    public double getCalculatedDiscountRate() {
        if (this.turnover >= 100 && this.turnover < 800) {
            this.discountRate += this.turnover / 100 * 0.01;
        } else if (this.turnover >= 800) {
            this.discountRate = 0.10;
        }
        return this.discountRate;
    }


}
