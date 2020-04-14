package test.colectii;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Trade implements Comparable<Trade> {

    long id;
    float value;
    LocalDateTime timestamp;

    public Trade(long id, float value, LocalDateTime timestamp) {
        this.id = id;
        this.value = value;
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(Trade o) {
        if(o.timestamp.isEqual(this.timestamp)){
            return 0;
        } else if(this.timestamp.isAfter(o.timestamp)){
            return 1;
        }
        else {
            return -1;
        }
    }
}
