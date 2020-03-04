package concurrency;


import lombok.*;


@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class FestivalAttendeeThread implements Runnable {

    private FestivalGate festivalGate;

    public FestivalAttendeeThread(FestivalGate festivalGate, TicketType ticketType) {
        this.festivalGate = festivalGate;
        this.ticketType = ticketType;
    }

    private TicketType ticketType = TicketType.generateRandomTicketType();

    @Override
    public void run() {
        festivalGate.put(ticketType);
        System.out.println(Thread.currentThread().getName() + " a validat biletul de tip " + ticketType);

    }
}
