package concurrency;

import java.util.Random;

public enum TicketType {
    FULL, FULLVIP, FREEPASS, ONEDAY, ONEDAYVIP;

    public static TicketType generateRandomTicketType(){
        TicketType[] values = TicketType.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
}
