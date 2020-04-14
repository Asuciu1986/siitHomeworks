package quiz.logistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class PackageMain {

    public static void main(String[] args) throws FileNotFoundException {
        int totalPackagesValue = 0;
        int totalRevenues = 0;

        File file = new File("src/main/java/quiz/logistics2/packages.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        List<Package> allPackages = bufferedReader.lines()
                .map(l -> l.split(","))
                .map(objArray -> new Package(objArray[0],
                        Integer.parseInt(objArray[1]),
                        Integer.parseInt(objArray[2]),
                        LocalDate.parse(objArray[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .sorted(Comparator.comparing(Package::getDeliveryDate).thenComparing(Package::getLocation))
                .collect(Collectors.toList());

        Map<String, Map<LocalDate, List<Package>>> packageGroups;
        packageGroups = allPackages.stream()
                .collect(Collectors.groupingBy(Package::getLocation, Collectors.groupingBy(Package::getDeliveryDate)));

        packageGroups = Collections.synchronizedMap(packageGroups);

        for (Map.Entry<String, Map<LocalDate, List<Package>>> location : packageGroups.entrySet()
        ) {

            for (Map.Entry<LocalDate, List<Package>> date : location.getValue().entrySet()
            ) {
                int groupPackagesValue = 0;
                int groupRevenueValue = 0;
                int duration = 0;

                for (Package pack: date.getValue()
                     ) {
                    groupPackagesValue += pack.getValue();
                    groupRevenueValue += pack.getDistance();
                    duration = pack.getDistance();
                }
                //System.out.println(groupPackagesValue + " : " + groupRevenueValue);
                DeliveryThread deliveryThread = new DeliveryThread(location.getKey(),duration,date.getKey());
                Thread thread = new Thread(deliveryThread);
                thread.start();
                totalPackagesValue += groupPackagesValue;
                totalRevenues += groupRevenueValue;
            }
        }
        System.out.println(totalPackagesValue);
        System.out.println(totalRevenues);
    }
}
