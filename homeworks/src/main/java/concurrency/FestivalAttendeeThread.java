package concurrency;

import lombok.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class FestivalAttendeeThread implements Runnable {

    private FestivalGate festivalGate;
    private TicketType ticketType = TicketType.generateRandomTicketType();

    FestivalAttendeeThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    @Override
    public void run() {
        festivalGate.put(ticketType);
    }
}

