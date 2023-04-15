package model;
import java.util.ArrayList;


public class Ship {
    //atributes
    private String name;
    private String owner;
    private double weight;
    private double value;
    private int notSailingReason; // 0 Success, 1 weight, 2 cargoType, 3 cargo.size()
    
    //relations
    private ArrayList<Cargo> cargoHold;

    //methods
    public Ship(String name, String owner) {
        this.name = name;
        this.owner = owner;
        cargoHold = new ArrayList<Cargo>();
        weight = 0;
        for (int i = 0; i < cargoHold.size(); i++) {
            if (cargoHold.get(i) != null) {
                weight += cargoHold.get(i).getCrateWeight();
            }
        }
        value = 0;
        for (int i = 0; i < cargoHold.size(); i++) {
            if (cargoHold.get(i) != null) {
            value += cargoHold.get(i).getPrice();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }

    
    public double getValue() {
        return value;
    }

    public void setValue(double newValue) {
        this.value = newValue;
    }

    public int getNotSailingReason() {
        return notSailingReason;
    }

    public void setNotSailingReason(int notSailingReason) {
        this.notSailingReason = notSailingReason;
    }
    
    public int getCargoLength() {
        return cargoHold.size();
    }
    
    public ArrayList<Cargo> getCargoHold() {
        return cargoHold;
    }
    
    public void setCargoHold(ArrayList<Cargo> newCargoHold) {
        this.cargoHold = newCargoHold;
    }

    public void loadCargo(Cargo cargo) {
        cargoHold.add(cargo);
    }
    
    private boolean hasPerecedera() {
        boolean searching = true;
        boolean has = false;
        for (int i = 0; i < cargoHold.size() && searching; i++) {
            if (cargoHold.get(i) != null && cargoHold.get(i).getCargoType() == CargoType.PERECEDERA) {
                has = true;
            }
        }
        return has;
    }

    private boolean hasPeligrosa() {
        boolean searching = true;
        boolean has = false;
        for (int i = 0; i < cargoHold.size() && searching; i++) {
            if (cargoHold.get(i) != null && cargoHold.get(i).getCargoType() == CargoType.PELIGROSA) {
                has = true;
            }
        }
        return has;
    }

    public boolean canSail() {
        
        int actualCargo = 0;
        for (int i = 0; i < cargoHold.size(); i++) {
            if (cargoHold.get(i) != null) {
                actualCargo++;
            }
        }

        notSailingReason = 0;
        
        boolean canSail = true;
        if (weight > 28000 || weight < 12000) {
            notSailingReason = 1;
            canSail = false;
        }
        else if (hasPerecedera() && hasPeligrosa()) {
            notSailingReason = 2;
            canSail = false;
        }
        else if (actualCargo < 2) {
            notSailingReason = 3;
            canSail = false;
        }

        return canSail;
    }

    public void unload() {
        cargoHold.clear();
        value = 0;
        weight = 0;
    }

    public String toString() {
        String info = "";
        info += "Name: " + name + "\n";
        info += "Owner: " + owner + "\n";
        info += "Weight: " + weight + "\n";
        info += "Value: " + value + "\n";
        info += "Cargo Hold: " + cargoHold + "\n";
        return info;
    }
}