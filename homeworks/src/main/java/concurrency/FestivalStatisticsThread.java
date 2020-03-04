package concurrency;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@ToString
@EqualsAndHashCode
public class FestivalStatisticsThread implements Runnable {

    private FestivalGate festivalGate;

    private List<String> updatedList = new ArrayList<>();

    private Map<String, Integer> statistica = Stream.of(
            new AbstractMap.SimpleEntry<String, Integer>(TicketType.FREEPASS.name(), 0),
            new AbstractMap.SimpleEntry<String, Integer>(TicketType.FULL.name(), 0),
            new AbstractMap.SimpleEntry<String, Integer>(TicketType.FULLVIP.name(), 0),
            new AbstractMap.SimpleEntry<String, Integer>(TicketType.ONEDAYVIP.name(), 0),
            new AbstractMap.SimpleEntry<String, Integer>(TicketType.ONEDAY.name(), 0))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    public FestivalStatisticsThread(FestivalGate festivalGate) {
        this.festivalGate = festivalGate;
    }

    public void updateAndPrint(Queue<String> queue) {
        for (String item : queue) {
            int value = statistica.get(item) + 1;
            statistica.replace(item, value);
        }

        statistica.entrySet().stream().forEach(System.out::println);
    }

    @Override
    public void run() {

        for (; ; ) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!festivalGate.getTickets().isEmpty()) {
                Queue<String> queue = festivalGate.getTickets();
                updateAndPrint(queue);
            }

        }
    }
}

