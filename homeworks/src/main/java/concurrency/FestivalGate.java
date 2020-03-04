package concurrency;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;

public class FestivalGate {

    private int number = -1;
    private boolean available;
    Queue<String> tickets = new ConcurrentLinkedQueue<>();

    public synchronized void put(TicketType ticketType) {
        if (available) {
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        tickets.add(ticketType.name());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        notifyAll();
    }

    public synchronized Queue<String> getTickets(){

        Queue<String> tempQueue = new ConcurrentLinkedQueue<>(tickets);
        tickets = null;

        return tempQueue;
    }
}


