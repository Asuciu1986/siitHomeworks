package io.skibiathlon;

import lombok.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CSVParse {

    private String filePath;

    private BiathlonSkiersResults biathlonSkiersResults = new BiathlonSkiersResults();

    public void parseCSV() throws IOException {

        String line = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while ((line = bufferedReader.readLine()) != null) {

                String[] attributes = line.split(",");
                String[] minutesSeconds = attributes[3].split(":");


                BiathlonSkier biathlonSkier = new BiathlonSkier();
                biathlonSkier.setNumber(Integer.parseInt(attributes[0]));
                biathlonSkier.setName(attributes[1]);
                biathlonSkier.setCountryCode(attributes[2]);
                biathlonSkier.setInitialTime(LocalTime.of(0, Integer.parseInt(minutesSeconds[0]), Integer.parseInt(minutesSeconds[1])));
                for (int i = 4; i < 7; i++) {
                    biathlonSkier.getShootings().add(attributes[i]);
                }

                biathlonSkier.calculateNumberOfZero();
                biathlonSkier.calculateStandingTime();

                biathlonSkiersResults.addSkier(biathlonSkier);

            }

//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        }
    }
}
