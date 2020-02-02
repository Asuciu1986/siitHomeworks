package objectcontainers.HashMap;

import objectcontainers.TreeSet.Persoana;

import java.util.*;

public class HobbyTest {

    public static void main(String[] args) {
        Persoana persoana1 = new Persoana("Gigel",25,"Masculin");
        Persoana persoana2 = new Persoana("Maricica",28,"Feminin");
        Persoana persoana3 = new Persoana("Ionel",30,"Masculin");


        persoana1.getHobbies().add( new Hobby("swimming", 3, new Address("Romania","Bucuresti","Stefan cel Mare",2)));
        persoana2.getHobbies().add( new Hobby("soccer", 3, new Address("Romania","Bucuresti","Stefan cel Mare",2)));
        persoana3.getHobbies().add( new Hobby("cycling", 3, new Address("Romania","Bucuresti","Stefan cel Mare",2)));
        persoana1.getHobbies().add( new Hobby("running", 3, new Address("Romania","Bucuresti","Stefan cel Mare",2)));
        persoana2.getHobbies().add( new Hobby("tennis", 3, new Address("Romania","Bucuresti","Stefan cel Mare",2)));
        persoana3.getHobbies().add( new Hobby("fitness", 3, new Address("Romania","Bucuresti","Stefan cel Mare",2)));


        Map<Persoana, List<Hobby>> persoane = new HashMap<>();
        persoane.put(persoana1,persoana1.getHobbies());
        persoane.put(persoana2,persoana2.getHobbies());
        persoane.put(persoana3,persoana3.getHobbies());

        for (Map.Entry<Persoana,List<Hobby>> persoana: persoane.entrySet()
             ) {
            System.out.print(persoana.getKey().toString()+ " ");

            for (Hobby hobby: persoana.getValue()
                 ) {
                System.out.println("hobby: "  + hobby.getName() + ", country:" + hobby.getAddress().getCountry());

            }
        }

    }

}
