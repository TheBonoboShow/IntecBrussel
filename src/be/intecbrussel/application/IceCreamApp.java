package be.intecbrussel.application;

import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Flavor;
import be.intecbrussel.eatables.MagnumType;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.NoMoreIceCreamException;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {
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
        PriceList pricelist = new PriceList(1.2, 1.5, 2.0);
        IceCreamSeller salon = new IceCreamSalon(pricelist);
        Eatable[] orderedIceCreams = new Eatable[0];

        // ordering some ice creams and putting them in an array
        orderedIceCreams = addToArray(orderedIceCreams, salon.orderMagnum(MagnumType.BLACKCHOCOLATE));
        orderedIceCreams = addToArray(orderedIceCreams, salon.orderIceRocket());
        orderedIceCreams = addToArray(orderedIceCreams, salon.orderCone(new Flavor[]{Flavor.BANANA, Flavor.PISTACHE}));
        orderedIceCreams = addToArray(orderedIceCreams, salon.orderCone(new Flavor[]{Flavor.STRACIATELLA, Flavor.LEMON, Flavor.STRAWBERRY, Flavor.MOKKA}));
        orderedIceCreams = addToArray(orderedIceCreams, salon.orderCone(new Flavor[]{Flavor.LEMON, Flavor.STRAWBERRY, Flavor.CHOCOLATE, Flavor.VANILLA, Flavor.CHOCOLATE}));
        orderedIceCreams = addToArray(orderedIceCreams, salon.orderIceRocket());
        orderedIceCreams = addToArray(orderedIceCreams, salon.orderIceRocket());
        orderedIceCreams = addToArray(orderedIceCreams, salon.orderMagnum(MagnumType.ALPINENUTS));
        orderedIceCreams = addToArray(orderedIceCreams, salon.orderMagnum(MagnumType.MILKCHOCOLATE));
        orderedIceCreams = addToArray(orderedIceCreams, salon.orderMagnum(MagnumType.ROMANTICSTRAWBERRIES));
        // addToArray(orderedIceCreams, salon.orderCone
        // (new Flavor[]{Flavor.LEMON, Flavor.STRAWBERRY, Flavor.MOKKA, Flavor.VANILLA, Flavor.CHOCOLATE, Flavor.MOKKA}));
        for (Eatable a : orderedIceCreams) {
            a.eat();
        }
        System.out.println("\nYour profit is: " + salon.getProfit() + "€");
    }


}
