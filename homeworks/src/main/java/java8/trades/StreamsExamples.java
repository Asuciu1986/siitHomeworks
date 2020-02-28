package java8.trades;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamsExamples {

    public static void main(String[] args) {

        String [] array = {"Alex", "Maria", "Paula", "Ninel", "Vali"};
        List<String> names  = Arrays.asList("Alex", "Maria", "Paula", "Ninel", "Vali","Andrei");

        Stream<String> streamFromArray = Stream.of(array);
        Stream<String> streamFromList = names.stream();

        streamFromArray
                .map(s -> s.toUpperCase())
                .filter(s -> s.toLowerCase().contains("a") || s.toLowerCase().contains("e"))
                .filter(s -> s.toLowerCase().contains("a"))
                .filter(s -> s.toLowerCase().contains("a"))
                .sorted()
                .distinct()
                .forEach(System.out::println);

        //streamFromArray.count(); // java.lang.IllegalStateException: stream has already been operated upon or closed
        Stream.of(array).count();



        boolean startsWithA = names.stream()
                .distinct()
                .anyMatch(name -> name.startsWith("A"));

        Optional<String> andreiNameOptional = names.stream()
                .filter(name -> name.equalsIgnoreCase("Andrei"))
                .findAny();

        if (andreiNameOptional.isPresent()){  //Optional.empty()
            System.out.println(andreiNameOptional.get());
        }

        andreiNameOptional.orElseThrow(() -> new RuntimeException());
        andreiNameOptional.orElse("AltAndrei");

        System.out.println(startsWithA);

        List<Integer> listOfLengths =  names.stream()
                .map(s -> s.length())
                .collect(toList());
        System.out.println(listOfLengths);

        String resultOfJoining = names.stream()
                .collect(Collectors.joining("[]","@","X"));
        System.out.println(resultOfJoining);

        Long userIdTo = null;
        System.out.println(userIdTo);
    }

}
