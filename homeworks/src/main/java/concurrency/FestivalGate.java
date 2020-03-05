package concurrency;

import lombok.Getter;
import lombok.Setter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Setter
@Getter
public class FestivalGate {

    private int number = -1;
    private boolean available = true;
    private Queue<String> tickets = new ConcurrentLinkedQueue<>();

    public synchronized void put(TicketType ticketType) {
        if (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tickets.add(ticketType.name());
        System.out.println(Thread.currentThread().getName() + " a validat biletul de tip " + ticketType);
        //System.out.println(tickets);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        available = true;
        notifyAll();
    }

    public Queue<String> get() {

        System.out.println("GET TICKETS INVOKED");

        Queue<String> tempQueue = new ConcurrentLinkedQueue<>(tickets);
        for (String s : tickets
        ) {
            tickets.remove(s);
        }
        //System.out.println(tickets);
        //System.out.println(tempQueue);
        return tempQueue;

    }
}


