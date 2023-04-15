package model;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Client{

    private String name;
    private String id;
    private Calendar registrationDate;
    private ClientRank rank; // Normal, Plata, Oro, Platinum
    private double shippedWeight;
    private double shippedValue;

    /** Creates a Client object.
     * @param name client's name
     * @param id
     * @param rank {@code NORMAL}, {@code PLATA}, {@code ORO}, {@code PLATINUM}
     * @param shippedWeight weight >= 0
     * @param shippedValue value >= 0
     */
    public Client(String name, String id) {
        this.name = name;
        this.id = id;
        registrationDate = Calendar.getInstance();
        rank = ClientRank.NORMAL;
        shippedWeight = 0;
        shippedValue = 0;
    }

    /**
     * @return client's name
     */
    public String getName() {
        return name;
    }

    /** Sets a given name to client
     * @param newName new client's name
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * @return client's ID
     */
    public String getId() {
        return id;
    }

    /** Sets a given ID to client
     * @param newId
     */
    public void setId(String newId) {
        this.id = newId;
    }

    /**
     * @return client's registration date
     */
    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    /** Sets a given registration date to client
     * @param newDate new registration date
     */
    public void setRegistrationDate(Calendar newDate) {
        this.registrationDate = newDate;
    }

    /**
     * @return client's rank
     */
    public ClientRank getRank() {
        return rank;
    }

    /** Sets a given rank to client
     * @param newRank new client's rank, ranks are Normal, Plata, Oro, Platnum
     */
    public void setRank(int newRank) {
        this.rank = ClientRank.getClientRankByInt(newRank);
    }

    /**
     * @return client's shippedweight
     */
    public double getShippedWeight() {
        return shippedWeight;
    }

    /** Sets a given shippedweight to client
     * @param newTotalWeight new client's shipped weight
     */
    public void setShippedWeight(double newTotalWeight) {
        this.shippedWeight = newTotalWeight;
    }

    /**
     * @return client's shipped value
     */
    public double getShippedValue() {
        return shippedValue;
    }

    /** Sets a given shipped value to client
     * @param newTotalValue new client's shipped value
     */
    public void setShippedValue(double newTotalValue) {
        this.shippedValue = newTotalValue;
    }

    public static String DateToString(Calendar date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateToString = dateFormat.format(date.getTime());
        return dateToString;
    }

    public String toString() {
        String info;
        info = "Name: " + name + "\n";
        info += "Registration Number: " + id+ "\n";
        info += "Expedition Date: " + DateToString(registrationDate) + "\n";
        info += "Rank: " + rank + "\n";
        info += "Shipped Weight: " + shippedWeight + '\n';
        info += "Shipped Value: " + shippedValue + "\n";
        return info;
    }

    /** Returns the client's updated info
     * @param newShippedWeight
     * @param newShippedValue
     * @return a string confirming the client's info updated
     */
    public String updateInfo(double newShippedWeight, double newShippedValue) {
        
        setShippedWeight(newShippedWeight + shippedWeight);
        setShippedValue(newShippedValue + shippedValue);

        String message = "Client updates succesfully\n";

        // Plata
        if (shippedWeight >= 35000) {
            setRank(1);
        }
        // Oro
        else if (shippedWeight >= 35000 || shippedValue >= 2000000) {
            setRank(2);
        }
        // Platinum
        else if (shippedValue >= 5000000) {
            setRank(3);
        }

        return message + toString();
    }
}