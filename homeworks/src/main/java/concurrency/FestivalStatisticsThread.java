package concurrency;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ToString
@EqualsAndHashCode
public class FestivalStatisticsThread implements Runnable {

    private FestivalGate festivalGate;
    private int numberOfTickets = 0;

    private Map<String, Integer> statistica = Stream.of(
            new AbstractMap.SimpleEntry<>(TicketType.FREEPASS.name(), 0),
            new AbstractMap.SimpleEntry<>(TicketType.FULL.name(), 0),
            new AbstractMap.SimpleEntry<>(TicketType.FULLVIP.name(), 0),
            new AbstractMap.SimpleEntry<>(TicketType.ONEDAYVIP.name(), 0),
            new AbstractMap.SimpleEntry<>(TicketType.ONEDAY.name(), 0))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    FestivalStatisticsThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    void updateAndPrint(Queue<String> queue) {
        for (String item : queue) {
            int value = statistica.get(item) + 1;
            numberOfTickets += 1;
            statistica.replace(item, value);
        }
        System.out.println(numberOfTickets + " people entered");
        statistica.entrySet().stream().forEach(System.out::println);
    }

    @Override
    public void run() {

        while (numberOfTickets < 100) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //
            if (!festivalGate.getTickets().isEmpty()) {
                Queue<String> queue = festivalGate.get();
                updateAndPrint(queue);
            }
        }
    }
}

