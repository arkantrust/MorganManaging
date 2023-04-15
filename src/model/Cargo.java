package model;

public class Cargo {
    
    //attributes
    private String name;
    private int numCrates;
    private double crateWeight;
    private CargoType cargoType; // "PELIGROSA "PERECEDERA" "NO PERECEDERA"
    private double price; // 390.000 - 250.000 - 80.000
    private double weight;

    //relations
    private Client owner;

    //methods
    /** Creates a Cargo object
     * @param name name of the cargo carried
     * @param crateWeight weight of the cargo, weight > 0
     * @param cargoType type of cargo, 1 -> {@code PELIGROSA}, 2 -> {@code PERECEDERA}, 3 -> {@code NO PERECEDERA}
     * @param owner owner of the cargo
     */
    public Cargo(String name, int numCrates, double crateWeight, int cargoType, Client owner) {
        this.name = name;
        this.numCrates = numCrates;
        this.crateWeight = crateWeight;
        this.cargoType = CargoType.getCargoTypeByInt(cargoType); // "PELIGROSA" "PERECEDERA" "NO PERECEDERA"
        price = CargoType.getPriceByCargoType(cargoType);
        weight = numCrates*crateWeight;
        this.owner = owner;
    }

    private void updateWeight() {
        this.weight = numCrates*crateWeight;
    }

    /**
     * @return name of the cargo
     */
    public String getName() {
        return name;
    }

    /** Sets a given name to the cargo
     * @param newName new name of the cargo
     */
    public void setName(String newName) {
        this.name = newName;
    }

    public int getNumCrates() {
        return numCrates;
    }

    public void setNumCrates(int numCrates) {
        this.numCrates = numCrates;
        updateWeight();
    }

    /**
     * @return weight of the cargo
     */
    public double getCrateWeight() {
        return crateWeight;
    }

    /** Sets a given weight to the cargo
     * @param newWeight new weight of the cargo
     */
    public void setCrateWeight(double newWeight) {
        this.crateWeight = newWeight;
        updateWeight();
    }

    /**Returns the type of the cargo
     * @return type of the cargo
     */
    public CargoType getCargoType() {
        return cargoType;
    }

    /** Sets a given type to the cargo
     * @param newType type to get
     * 1 -> PELIGROSA
     * 2 -> PERECEDERA
     * 3 -> NO PERECEDERA
     */
    public void setCargoType(int newType) {
        this.cargoType = CargoType.getCargoTypeByInt(newType);
    }
    
    /**
     * @return price of shipping the cargo, depends on the type "PELIGROSA", 390.000 - "PERECEDERA", 250.000 - "NO PERECEDERA", 80.000

     */
    public double getPrice() {
        return price;
    }

    /** Sets a new given price to the cargo
     * @param newPrice new price of the cargo
     */
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return owner of the cargo
     */
    public Client getOwner() {
        return owner;
    }

    /** Sets a new given owner to the cargo
     * @param newOwner new owner of the cargo
     */
    public void setOwner(Client newOwner) {
        this.owner = newOwner;
    }

    public String toString() {
        String info = "";
        info += "Name: " + name + "\n";
        info += "Number of Crates: " + numCrates + "\n";
        info += "Crate Weight: " + crateWeight + "\n";
        info += "Cargo Type: " + cargoType + "\n";
        info += "Price: " + price + "\n";
        info += "Weight: " + weight + "\n";
        info += "Owner: " + owner.getName();
        return info;
    }

    /** Applies a discount to the price of the cargo, depending on the owner's rank
     * 
     */
    public void applyDiscount() {
        if (owner.getRank() == ClientRank.PLATA && cargoType == CargoType.PERECEDERA) {
            price -= price*0.015;
        }
        else if (owner.getRank() == ClientRank.ORO && (cargoType == CargoType.PERECEDERA || cargoType == CargoType.NO_PERECEDERA)) {
            price -= price*0.035;
        }
        else if (owner.getRank() == ClientRank.PLATINUM) {
            price -= price*0.05;
        }
    }
}
