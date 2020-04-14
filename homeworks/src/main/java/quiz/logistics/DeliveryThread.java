package quiz.logistics;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class DeliveryThread implements Runnable {

    private String location;
    private int duration;
    private LocalDate date;

    @Override
    public void run() {
        System.out.println("Delivering for " + location + " and date " + date + " in " + duration + " seconds");
        try {
            Thread.sleep(duration*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
