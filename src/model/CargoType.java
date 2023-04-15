package model;
import java.util.Hashtable;

public enum CargoType {
    PELIGROSA, PERECEDERA, NO_PERECEDERA;

    private static Hashtable<Integer, CargoType> typesXInt = new Hashtable<>();
    
    
    public static CargoType getCargoTypeByInt(int type) {
        typesXInt.put(1, PELIGROSA);
        typesXInt.put(2, PERECEDERA);
        typesXInt.put(3, NO_PERECEDERA);

        CargoType cargoType = typesXInt.get(type);

        return cargoType;
    }

    public static double getPriceByCargoType(int cargoType) {
        double price = 0;

        if (cargoType == 1) {
            price = 390000;
        }
        else if (cargoType == 2) {
            price = 250000;
        }
        else if (cargoType == 3) {
            price = 80000;
        }

        return price;
    }


}
