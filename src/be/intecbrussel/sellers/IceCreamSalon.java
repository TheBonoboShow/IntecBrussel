package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamSalon implements IceCreamSeller {
    private PriceList priceList;
    private double totalProfit;

    // added constructor because implementation was otherwise unclear
    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }

    @Override
    public Cone orderCone(Flavor[] balls) throws NoMoreIceCreamException {
        if (balls.length > 5) {
            throw new NoMoreIceCreamException("Gluttony is 1 of the 7 cardinal sins. You cannot order more than 5 scoops!");
        }
        totalProfit += (this.priceList.getBallPrice() * balls.length);
        return new Cone(balls);
    }

    @Override
    public IceRocket orderIceRocket() {
        totalProfit += this.priceList.getRocketPrice();
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(MagnumType magnumType) {
        totalProfit += (this.priceList.getMagnumStandardPrice() * magnumType.getMultiplier());
        return new Magnum(magnumType);
    }

    @Override
    public String toString() {
        return "IceCreamSalon{" +
                "priceList=" + priceList +
                ", totalProfit=" + totalProfit +
                '}';
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }
}
