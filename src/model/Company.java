package model;
import java.util.ArrayList;

public class Company {
    //attributes
    private String name;
    private String owner;
    
    //relations
    private ArrayList<Client> clients;
    private Ship satisfaction;
    private ArrayList<Ship> ships;
    private CargoPort portRoyal;

    
    public Company(String name, String owner) {
        this.name = name;
        this.owner = owner;
        satisfaction = new Ship("Satisfaction", "Henry Morgan");
        clients = new ArrayList<Client>();
        ships = new ArrayList<Ship>();
        ships.add(satisfaction);
        portRoyal = new CargoPort("Port Royal", "Henry Morgan");
    }

    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String newOwner) {
        this.owner = newOwner;
    }

    public ArrayList<Client>  getClients() {
        return clients;
    }
    
    public void setClients(ArrayList<Client> newClients) {
        this.clients = newClients;
    }

    public Ship getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Ship newShip) {
        this.satisfaction = newShip;
    }
    
    public CargoPort getPortRoyal() {
        return portRoyal;
    }

    public void setPortRoyal(CargoPort portRoyal) {
        this.portRoyal = portRoyal;
    }

    public boolean clientExists(String id) {
        boolean exists = false;
        boolean searching = true;

        for (int i = 0; i < clients.size() && searching; i++) {
            if (clients.get(i).getId().equalsIgnoreCase(id)) {
                exists = true;
                searching = false;
            }
        }
        return exists;
    }
    
    public String addClient(String name, String id) {
        String message = "";
        
        // early return saves an identation
        if (clientExists(name)) {
            message = name + " is already registered.\n";
            return message;
        }
        
        Client newClient = new Client(name, id);
        
        clients.add(newClient);
        
        message = newClient.getName() + " registered succesfully.\n";            
        
        return message;
    }

    public String removeClient(String name) {
        String message = "";
        
        // early return saves an identation
        if (!clientExists(name)) {
            message = name + " is not registered.\n";
            return message;
        }
        
        int index = 0;
        boolean searching = true;
        
        for (int i = 0; i < clients.size() && searching; i++) {
            if (clients.get(i).getId().equalsIgnoreCase(name)) {
                index = i;
                searching = false;
            }
        }
        
        clients.remove(index);
        
        message = name + " removed succesfully.\n";
        
        return message;
    }

    public String showClients() {
        String info = "";
        for (Client client : clients) {
            info += client.getName() + "/n";
        }
        
        return info;
    }


    public String shipCanSail() {
        
        String message = "";

        if (!satisfaction.canSail()) {
            switch(satisfaction.getNotSailingReason()) {
                case 0:
                    message = satisfaction.getName() + " is sailing.\n";
                    break;
                case 1:
                    message = "Check total cargo weight.\n";
                    break;
                case 2:
                message = "Check cargo types.\n";
                    break;
                case 3:
                    message = "Check amount of cargo.\n";
                    break;
                default:
                    message = "Check everything.\n";
                    break;
            }
        }
        return message;
    }

    public String unloadShip(Ship ship) {
        ship.unload();
        return "Cargo delivered and unloaded succesfully.\n";
    }

    // I know this looks horrible and unreadable BUT IT WORKS
    public String updateClients() {
        String message = "";

        /* For each cargo in every cargoHold ArrayList from all ship objects in the ships ArrayList,
        update its owner info (shipped weight, shipped value and, if applicable, rank) by adding the weight and the price of the corresponding crate */
        for (int i = 0; i < ships.size(); i++) {
            Ship ship = ships.get(i);
            for (int j = 0; j < ship.getCargoHold().size(); j++) {
                if (ship.getCargoHold().get(j) != null) {
                    ship.getCargoHold().get(j).getOwner().updateInfo(ship.getCargoHold().get(j).getCrateWeight(), ship.getCargoHold().get(j).getPrice());
                }
            }
        }

        message = "All clients were updated successfully.\n";
        
        return message;
    }

    public String clientNameStartsWith(char letter) {
        String clientsNames = "";
        boolean searching = true;

        for (int i = 0; i < clients.size() && searching; i++) {

            Character firstNameLetter = Character.toUpperCase(clients.get(i).getName().charAt(0));
            Character comparedLetter = Character.toUpperCase(letter);

            if (clients.get(i) != null && firstNameLetter.equals(comparedLetter)) {
                clientsNames += clients.get(i).toString() + "\n";
            }
        }
        return clientsNames;
    }

    public String toString() {
        String info = "Name: " + name + "\n";
        info += "Owner: " + owner + "\n";
        info += "Clients: \n";
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i) != null) {
            info += clients.get(i).getName() + "\n";
            }
        }
        return info;
    }
}
