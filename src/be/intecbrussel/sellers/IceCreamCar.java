package be.intecbrussel.sellers;

import be.intecbrussel.application.Stock;
import be.intecbrussel.eatables.*;

public class IceCreamCar implements IceCreamSeller {
    private PriceList pricelist;
    private Stock stock;
    private double profit;


    // added constructor because implementation was otherwise unclear
    public IceCreamCar(PriceList pricelist, Stock stock) {
        this.pricelist = pricelist;
        this.stock = stock;
    }

    @Override
    public Cone orderCone(Flavor[] balls) throws NoMoreIceCreamException {
        if (stock.getMagni() == 0 && stock.getIceRockets() == 0 && stock.getCones() == 0 && stock.getBalls() == 0)
            throw new NoMoreIceCreamException("We are sold out, please come back another time!");
        if (stock.getCones() == 0 || stock.getBalls() < balls.length) {
            throw new NoMoreIceCreamException("We currently don't have enough flavors or cones available, sorry!");
        } else if (balls.length > 5) {
            throw new NoMoreIceCreamException("Gluttony is 1 of the 7 cardinal sins. You cannot order more than 5 scoops!");
        }
        return prepareCone(balls);
    }

    private Cone prepareCone(Flavor[] balls) {
        stock.setCones(stock.getCones() - 1);
        stock.setBalls(stock.getBalls() - balls.length);
        profit += (this.pricelist.getBallPrice() * balls.length);
        return new Cone(balls);
    }

    @Override
    public IceRocket orderIceRocket() throws NoMoreIceCreamException {
        if (stock.getMagni() == 0 && stock.getIceRockets() == 0 && stock.getCones() == 0 && stock.getBalls() == 0)
            throw new NoMoreIceCreamException("We are sold out, please come back another time!");
        if (stock.getIceRockets() == 0)
            throw new NoMoreIceCreamException("We currently don't have any rockets available, I suggest trying a cone or a magnum instead!");
        return prepareRocket();
    }

    private IceRocket prepareRocket() {
        stock.setIceRockets(stock.getIceRockets() - 1);
        profit += this.pricelist.getRocketPrice();
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(MagnumType magnumType) throws NoMoreIceCreamException {
        if (stock.getMagni() == 0 && stock.getIceRockets() == 0 && stock.getCones() == 0 && stock.getBalls() == 0)
            throw new NoMoreIceCreamException("We are sold out, please come back another time!");
        if (stock.getMagni() == 0)
            throw new NoMoreIceCreamException("We currently don't have any magnum available, do try our rockets or cones!");
        return prepareMagnum(magnumType);
    }

    private Magnum prepareMagnum(MagnumType magnumType) {
        stock.setMagni(stock.getMagni() - 1);
        profit += (this.pricelist.getMagnumStandardPrice() * magnumType.getMultiplier());
        return new Magnum(magnumType);
    }

    @Override
    public double getProfit() {
        return profit;
    }
}
