package quiz.logistics;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Comparator;

@Getter
@Setter
@ToString
public class Package {

    private String location;

    private int distance;

    private int value;

    private LocalDate deliveryDate;

    public Package(String location, int distance, int value, LocalDate deliveryDate) {
        this.location = location;
        this.distance = distance;
        this.value = value;
        this.deliveryDate = deliveryDate;
    }

}
