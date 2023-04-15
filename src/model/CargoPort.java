package model;
import java.util.ArrayList;

public class CargoPort {
    //attributes
    private String name;
    private String owner;

    //relations
    private ArrayList<Cargo> warehouse;
    private ArrayList<Cargo> loadingZone;
    private ArrayList<Ship> dock;

    //methods
    public CargoPort(String name, String owner) {
        this.name = name; // "Port Royal" Trivia: According to wikipedia, Morgan had his base on Port Royal, Jamaica
        this.owner = owner;

        warehouse = new ArrayList<Cargo>();
        loadingZone = new ArrayList<Cargo>();
        dock = new ArrayList<Ship>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ArrayList<Cargo> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(ArrayList<Cargo> warehouse) {
        this.warehouse = warehouse;
    }

    public ArrayList<Cargo> getLoadingZone() {
        return loadingZone;
    }

    public void setLoadingZone(ArrayList<Cargo> loadingZone) {
        this.loadingZone = loadingZone;
    }

    public ArrayList<Ship> getDock() {
        return dock;
    }

    public void setDock(ArrayList<Ship> dock) {
        this.dock = dock;
    }

    public void clearWarehouse() {
        warehouse.clear();
    }

    public void clearLoadingZone() {
        loadingZone.clear();
    }

    public void clearDock() {
        dock.clear();
    }

    public String selectCargoType(int selection) {
        
        String cargoType;

        switch (selection) {
            case 1:
                cargoType = "PELIGROSA";
                break;
            case 2:
                cargoType = "PERECEDERA";
                break;
            case 3:
                cargoType = "NO PERECEDERA";
                break;
            default:
            cargoType = null;
        }
        return cargoType;
    }

    public String addCargo(Ship cargoFreight, String name, int numCrates, double crateWeight, int cargoType, Client owner) {

        String message = "";
        
        Cargo newCargo = new Cargo(name, numCrates, crateWeight, cargoType, owner);
        
        // partial search in cargoHold to find the first empty spot for cargo
        boolean searching = true;
        for (int i = 0; i < cargoFreight.getCargoHold().size() && searching; i++) {
            if (cargoFreight.getCargoHold().get(i) == null) {
                cargoFreight.getCargoHold().set(i, newCargo);
                searching = false;
            }
        }
        message = name + " loaded succesfully.\n";

        return message;
    }

    public String toString() {
        String info = "";
        info += "Name: " + name + "\n";
        info += "Owner: " + owner + "\n";
        info += "Warehouse: " + warehouse + "\n";
        info += "Loading Zone: " + loadingZone + "\n";
        info += "Dock: " + dock + "\n";
        return info;
    }
    
}
