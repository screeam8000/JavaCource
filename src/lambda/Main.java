package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {

        PersonFactory<Person> personPersonFactory = Person::new;
        Person pers = personPersonFactory.create("Name", "Surname");
        System.out.println(pers.firstName + "  " + pers.lastName);

        List<Person> list = new ArrayList<>();
        list.add(personPersonFactory.create("1", "A"));
        list.add(personPersonFactory.create("2", "B"));
        list.add(personPersonFactory.create("3", "C"));
        list.add(personPersonFactory.create("4", "D"));

        Map<String, String> mp =
                list.stream().collect(Collectors.toMap(Person::getFirstName, Person::getLastName));
        list.stream().collect(Collectors.toMap(o -> o.getFirstName() + "aa", Person::getLastName));
        System.out.println(mp);




        /*
        List<String> strings = new ArrayList<>();
        strings.add("a1");
        strings.add("b987");
        strings.add("c83");
        strings.add("e4");
        strings.add("r56");
        strings.add("p98");
        strings.add("q34");

        strings.stream().filter(s -> {
            System.out.println("p:"+s);
            return  s.contains("a");
        })
                .filter(ss -> ss.matches("\\s\\w"))
                .forEach(System.out::println);
    */
    }
}
