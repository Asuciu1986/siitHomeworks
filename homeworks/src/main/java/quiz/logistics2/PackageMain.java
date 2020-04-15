package quiz.logistics2;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class PackageMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        int totalPackagesValue = 0;
        int totalRevenues = 0;

        File file = new File("src/main/java/quiz/logistics/packages.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;

        List<Package> allPackages = bufferedReader.lines()
                .map(l -> l.split(","))
                .map(objArray -> new Package(objArray[0],
                        Integer.parseInt(objArray[1]),
                        Integer.parseInt(objArray[2]),
                        LocalDate.parse(objArray[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .collect(Collectors.toList());

        Map<String, PackageGroup> packagesByKey = new HashMap<>();
        packagesByKey = Collections.synchronizedMap(packagesByKey);

        for (Package pack : allPackages
        ) {
            String identifier = pack.getLocation() + " " + pack.getDeliveryDate().toString();
            if (!packagesByKey.containsKey(identifier)) {
                PackageGroup packageGroup = new PackageGroup();
                packageGroup.addToGroup(pack);
                packagesByKey.put(identifier, packageGroup);
            } else {
                PackageGroup packageGroup = packagesByKey.get(identifier);
                packageGroup.getPackages().add(pack);
            }
        }

        for (Map.Entry<String, PackageGroup> packageKeyValue : packagesByKey.entrySet()
        ) {
            PackageGroup packageGroup = packageKeyValue.getValue();
            DeliveryThread deliveryThread = new DeliveryThread(packageGroup);
            Thread thread = new Thread(deliveryThread);
            thread.start();
            thread.join();
            totalPackagesValue += packageGroup.getGroupValue();
            totalRevenues += packageGroup.getGroupRevenue();
        }

        System.out.println("Total value of all delivered packages: " + totalPackagesValue);
        System.out.println("Total value of the revenue computed for all groups delivered: " + totalRevenues);
    }
}

