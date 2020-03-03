package io.skibiathlon;


import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class BiathlonSkier {

    private int number;

    private String name;

    private String countryCode;

    private LocalTime initialTime;

    private LocalTime standingTime;

    private List<String> shootings = new ArrayList<>();

    private int numberOfZero = 0;

    public static Comparator<BiathlonSkier> comparator = new Comparator<BiathlonSkier>() {
        @Override
        public int compare(BiathlonSkier o1, BiathlonSkier o2) {
            if(o1.getStandingTime().isAfter(o2.getStandingTime())){
                return 1;
            } else if(o1.getStandingTime().equals(o2.getStandingTime())){
                return 0;
            } else {
                return -1;
            }
        }
    };

    public BiathlonSkier(int number, String name, String countryCode, LocalTime initialTime, List<String> shootings) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.initialTime = initialTime;
        this.shootings = shootings;
    }

    public void calculateNumberOfZero(){

        for (String shooting:shootings
             ) {
           String[] splitted = shooting.split("");
            for (String s: splitted
                 ) {
                if(s.equals("o")){
                    numberOfZero+=1;
                }
            }
        }
    }

    public void calculateStandingTime(){

        standingTime = initialTime.plusSeconds(10*numberOfZero);
    }

    @Override
    public String toString() {
        return "BiathlonSkier{" +
                "name='" + name + '\'' +
                ", initialTime=" + initialTime +
                ", standingTime=" + standingTime +
                '}';
    }
}
