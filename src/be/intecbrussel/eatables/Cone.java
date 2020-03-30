package be.intecbrussel.eatables;

public class Cone implements Eatable {
    private Flavor[] balls;

    public Cone(Flavor[] flavors) {
        balls = flavors;
    }

    public Cone() {
    }

    @Override
    public void eat() {
        System.out.print("Eating a cone with the following flavors: ");
        for (int i = 0; i < balls.length; i++) {
            if (i == 0 && balls.length == 1) System.out.println(balls[i] + ".");
            else if (i == balls.length - 1) System.out.println("and " + balls[i] + ".");
            else if (i == balls.length - 2) System.out.print(balls[i] + " ");
            else System.out.print(balls[i] + ", ");
        }
    }
}
