package be.intecbrussel.eatables;

public enum MagnumType {

    MILKCHOCOLATE(1.0), WHITECHOCOLATE(1.25), BLACKCHOCOLATE(1.0), ALPINENUTS(1.5), ROMANTICSTRAWBERRIES(2.0);

    private double multiplier;

    MagnumType(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}
