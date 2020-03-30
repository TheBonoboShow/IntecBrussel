package be.intecbrussel.application;

import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Flavor;
import be.intecbrussel.eatables.MagnumType;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.NoMoreIceCreamException;
import be.intecbrussel.sellers.PriceList;

public class IceCreamAppV2 {

    // Array updated with orders
    private static Eatable[] addToArray(Eatable[] orderedIceCreams, Eatable iceCream) {
        Eatable[] temp = new Eatable[orderedIceCreams.length + 1];
        for (int i = 0; i < orderedIceCreams.length; i++) {
            temp[i] = orderedIceCreams[i];
        }
        temp[orderedIceCreams.length] = iceCream;
        return temp;
    }

    public static void main(String[] args) throws NoMoreIceCreamException {
        Stock stock = new Stock(3, 5, 15, 5);
        PriceList pricelist = new PriceList(1.5, 2.2, 3.0);
        IceCreamSeller car = new IceCreamCar(pricelist, stock);
        Eatable[] orderedIceCreams = new Eatable[0];

        // ordering some ice creams and putting them in an array
        // NO clue why my 3rd rocket ice cream amounts to a rounding error
        orderedIceCreams = addToArray(orderedIceCreams, car.orderMagnum(MagnumType.BLACKCHOCOLATE));
        orderedIceCreams = addToArray(orderedIceCreams, car.orderIceRocket());
        orderedIceCreams = addToArray(orderedIceCreams, car.orderCone(new Flavor[]{Flavor.BANANA, Flavor.PISTACHE}));
        orderedIceCreams = addToArray(orderedIceCreams, car.orderCone(new Flavor[]{Flavor.STRACIATELLA, Flavor.LEMON, Flavor.STRAWBERRY, Flavor.MOKKA}));
        orderedIceCreams = addToArray(orderedIceCreams, car.orderCone(new Flavor[]{Flavor.LEMON, Flavor.STRAWBERRY, Flavor.CHOCOLATE, Flavor.VANILLA, Flavor.CHOCOLATE}));
        orderedIceCreams = addToArray(orderedIceCreams, car.orderIceRocket());
        orderedIceCreams = addToArray(orderedIceCreams, car.orderMagnum(MagnumType.WHITECHOCOLATE));
        orderedIceCreams = addToArray(orderedIceCreams, car.orderIceRocket());
        // orderedIceCreams = addToArray(orderedIceCreams, car.orderIceRocket());
        orderedIceCreams = addToArray(orderedIceCreams, car.orderMagnum(MagnumType.MILKCHOCOLATE));
        orderedIceCreams = addToArray(orderedIceCreams, car.orderMagnum(MagnumType.ROMANTICSTRAWBERRIES));
        // addToArray(orderedIceCreams, salon.orderCone
        // (new Flavor[]{Flavor.LEMON, Flavor.STRAWBERRY, Flavor.MOKKA, Flavor.VANILLA, Flavor.CHOCOLATE, Flavor.MOKKA}));
        for (Eatable a : orderedIceCreams) {
            a.eat();
        }
        System.out.println("\nYour profit is: " + car.getProfit() + "€");
    }
}
