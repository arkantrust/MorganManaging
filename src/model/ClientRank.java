package model;
import java.util.Hashtable;

public enum ClientRank {
    NORMAL, PLATA, ORO, PLATINUM;

    private static Hashtable<Integer, ClientRank> ranksXInt = new Hashtable<>();
    
    
    public static ClientRank getClientRankByInt(int intRank) {
        ranksXInt.put(0, NORMAL);
        ranksXInt.put(1, PLATA);
        ranksXInt.put(2, ORO);
        ranksXInt.put(3, PLATINUM);

        ClientRank rank = ranksXInt.get(intRank);

        return rank;
    }
}
