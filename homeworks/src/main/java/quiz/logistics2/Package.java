package quiz.logistics2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return Objects.equals(location, aPackage.location) &&
                Objects.equals(deliveryDate, aPackage.deliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, deliveryDate);
    }
}
