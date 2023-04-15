package ui;

import model.Company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import model.Cargo;
import model.Ship;
import model.Client;
import model.CargoPort;

public class ConsoleUserInterface {

    public static Scanner in = new Scanner(System.in);

    /** Reads a date as dd-MM-yyy. e.g. 23-05-1995 as a String and formats it to Calendar type
     * @param requiredDate the name of the date required. e.g. birthdate, finish date. <b>Reccomended: Establish as "date" as default to keep coherence</b>
     * @return The date entered in Calendar type
     */
    public static Calendar readDate(String requiredDate) {
        boolean run = true;
        Calendar date = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        while (run) {
            System.out.print("Enter " + requiredDate + " (dd-mm-yyyy): ");
            String dateString = in.nextLine();
            
            try {
                date.setTime(dateFormat.parse(dateString));
                run = false;
            }
            catch (Exception e) {
                System.out.println("Invalid date format.");
            }
        }
        return date;
    }

    public static String DateToString(Calendar date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateToString = dateFormat.format(date.getTime());
        return dateToString;
    }

    public static void main(String agrs[]) {
        
        Company pirata = new Company("El Pirata", "Henry Morgan");
        System.out.println(pirata.toString());

        Client me = new Client("David Dulce", "A00398802");
        System.out.println(me.toString());
        
        Cargo myCargo = new Cargo("jewelry", 10, 1000, 3, me);
        System.out.println(myCargo.toString());
        
        Ship myShip = new Ship("satisfaction", "Hnery Morgan");
        System.out.println(myShip.toString());
        
        myShip.loadCargo(myCargo);
        CargoPort port = new CargoPort("Port Royal", "Henry Morgan");
        System.out.println(port.toString());

        // registerClients();
        // loadShip();
        // sailShip();
        // searchClientByLetter();

        myShip.loadCargo(myCargo);
        
        myCargo.setCrateWeight(20);

        pirata.updateClients();
        System.out.println(myCargo.toString());
        System.out.println(me.toString());
        System.out.println(myShip.toString());

    }
    /* 
    public static void registerClients() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Register client " + (i+1) + ": ");
            System.out.print("Name: ");
            String name = in.nextLine();

            if (pirata.clientExists(name)) {
                i--;
            }
            
            System.out.print("Registration Number: ");
            String registrationNumber = in.nextLine();
            
            System.out.println(pirata.addClient(name, registrationNumber));
        }
    }

    public static void loadCargo() {
        
        System.out.print("Cargo name: ");
        String name = in.nextLine();

        System.out.print("Cargo weight (kg): ");
        double weight = in.nextDouble();
        in.nextLine();

        System.out.println("Cargo type: ");
        System.out.println("1. Peligrosa");
        System.out.println("2. Perecedera");
        System.out.println("3. No Perecedera");
        System.out.print("------> ");
        int cargoType = in.nextInt();
        in.nextLine();

        System.out.println("Owner: ");
        // for (int i = 0; i < 5; i++) {System.out.println((i+1) + ". " + pirata.getClients()[i].getName());} <- One liner to do below
        System.out.println("1. " + pirata.getClients().get(0).getName());
        System.out.println("2. " + pirata.getClients().get(1).getName());
        System.out.println("3. " + pirata.getClients().get(2).getName());
        System.out.println("4. " + pirata.getClients().get(3).getName());
        System.out.println("5. " + pirata.getClients().get(4).getName());
        System.out.print("------> ");
        int cargoOwner = in.nextInt();
        in.nextLine();


        System.out.println(pirata.addCargo(name, weight, cargoType, cargoOwner));

        System.out.println("Total cargo weight: " + pirata.getShip().getWeight());
        System.out.println("Total cargo value: " + pirata.getShip().getValue());
    }

    public static void loadShip() {
        
        System.out.print("How many cargo crates are going into the ship? ");
        int cargoNumber = in.nextInt();
        in.nextLine();

        for (int i = 0; i < cargoNumber; i++) {
            System.out.println("\nCargo #" + (i + 1));
            loadCargo();
        }
    }

    public static void sailShip() {

        System.out.println(pirata.shipCanSail());

        if (pirata.getShip().canSail()) {
            System.out.println("A                                B");
            System.out.println("A ---                            B");
            System.out.println("A -------                        B");
            System.out.println("A ------------                   B");
            System.out.println("A --------------------           B");
            System.out.println("A ----------------------------   B");
            System.out.println("A -----------------------------  B");
            System.out.println("A ------------------------------ B");
            System.out.println(pirata.getShip().getName() + " has arrived.\n");
            System.out.println(pirata.updateClients());
            System.out.println(pirata.unloadShip());
        }
    }

    public static void searchClientByLetter() {
        System.out.println("Type a letter to search: ");
        String letter = in.nextLine();
        System.out.println("Clients whose names start with " + letter.charAt(0) + ": ");
        System.out.println(pirata.clientNameStartsWith(letter.charAt(0)));
    }
    */
    
}