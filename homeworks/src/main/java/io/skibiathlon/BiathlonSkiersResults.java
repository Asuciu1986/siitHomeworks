package io.skibiathlon;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BiathlonSkiersResults {

    private List<BiathlonSkier> skiers = new ArrayList<>();

    public void addSkier(BiathlonSkier biathlonSkier){
        skiers.add(biathlonSkier);
        System.out.println("Skier added");
    }

    public List<BiathlonSkier> topThree(){
        skiers.sort(BiathlonSkier.comparator);
        return skiers.subList(0,3);
    }

    public List<BiathlonSkier> topTwo(){
        skiers.sort(BiathlonSkier.comparator);
        return skiers.subList(0,2);
    }
}
