package eight.core.collectors.collect;

import eight.data.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class PeopleListExample {

    // 2. List first names of people in sorted order
    static void _collectFirstNames() {
        System.out.println(" //2. List first names of people in sorted order : " + Person.getPeopleList()
                .stream()
                .map(Person::getFirstName).sorted()
                .toList());
    }

    // 3. List full names of people in  reverse sorted order
    static void _concatenateName() {
        System.out.println(" //3. List full names of people in  reverse sorted order :" + Person.getPeopleList()
                .stream()
                .map(n -> n.getFirstName() + " " + n.getLastName())
                .sorted(Comparator.reverseOrder())
                .toList());
    }

    // 4. List full names of people
    static void _concatenateNameUsingConcat() {
        System.out.println(" //3. List full names of people :" + Person.getPeopleList()
                .stream()
                .map(n -> n.getFirstName().toLowerCase()
                        .concat(" ")
                        .concat(n.getLastName()
                                .toLowerCase()))
                .toList());
    }

    // 6. Grouping By
    static void _groupNamesByGender() {
        Map<String, List<Person>> result = Person.getPeopleList()
                .stream()
                .collect(Collectors.groupingBy(Person::getLastName));
        System.out.println("//6. GroupingBy :" + result);
    }

    // 7. GroupingBy by count
    static void _getCountByLastname() {
        Map<String, Long> result = Person.getPeopleList()
                .stream()
                // .collect(Collectors.groupingBy(Person::getLastName, Collectors.counting()));
                .collect(groupingBy(Person::getLastName, counting()));
        System.out.println("  //7. Grouping By by count : " + result);
    }

    // 8. GroupingBy by count
    static void _getFirstNamesByAge() {
        Map<Integer, List<String>> result = Person.getPeopleList()
                .stream()
                .collect(groupingBy(Person::getAge,
                        mapping(Person::getFirstName, toList())));
        System.out.println(result);
    }

    // 9. GroupingBy  & mapping
    static void _getFullNamesByAge() {
        Map<Integer, List<String>> result = Person.getPeopleList()
                .stream()
                .collect(groupingBy(Person::getAge,
                        mapping(n -> n.getFirstName().concat(" ")
                                .concat(n.getLastName()), toList())
                ));
        System.out.println(result);
    }

    // 10. GroupingBy  & mapping
    static void _getFullNamesListByGender() {
        Map<String, List<String>> result = Person.getPeopleList()
                .stream()
                .collect(groupingBy(Person::getGender, mapping(n -> n.getFirstName().concat(" ")
                        .concat(n.getLastName()), toList())));
        System.out.println(result);
    }

    // 11. GroupingBy  & mapping
    static void _getCountByLastnameSum() {
        Map<String, Long> result = Person.getPeopleList()
                .stream()
                // .collect(Collectors.groupingBy(Person::getLastName, Collectors.counting()));
                .collect(groupingBy(Person::getLastName, summingLong(Person::getAge)));
        System.out.println(result);

    }


    static void _getFullNamesByAgeList() {
        Map<Integer, List<Person>> result = Person.getPeopleList()
                .stream()
                .collect(groupingBy(Person::getAge, toList()));
        System.out.println(result);
    }


    public static void main(String[] args) {

        _collectFirstNames();
        _concatenateName();
        _concatenateNameUsingConcat();
        _groupNamesByGender();
        _getFirstNamesByAge();
        _getFullNamesByAge();
        _getFullNamesListByGender();
        _getCountByLastnameSum();
        _getFullNamesByAgeList();
        _groupNamesByGender();
    }
}
