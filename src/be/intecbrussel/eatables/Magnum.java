package be.intecbrussel.eatables;

public class Magnum implements Eatable {
    private MagnumType type;

    public Magnum(MagnumType magnumType) {
        type = magnumType;
    }

    public Magnum() {
    }

    @Override
    public void eat() {
        System.out.println("Eating a " + type + " magnum.");
    }

    public MagnumType getMagnumType() {
        return type;
    }
}
