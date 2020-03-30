package be.intecbrussel.sellers;

public class PriceList {
    private double ballPrice;
    private double rocketPrice;
    private double magnumStandardPrice;

    public PriceList() {
    }

    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice) {
        this.ballPrice = ballPrice;
        this.rocketPrice = rocketPrice;
        this.magnumStandardPrice = magnumStandardPrice;
    }

    double getBallPrice() {
        return ballPrice;
    }

    void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }

    double getRocketPrice() {
        return rocketPrice;
    }

    void setRocketPrice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }

    double getMagnumStandardPrice() {
        return magnumStandardPrice;
    }

    void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }
}
