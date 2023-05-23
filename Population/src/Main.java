import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        Stream<Person> stream = persons.stream();
        Stream<Person> stream1 = persons.stream();
        Stream<Person> stream2 = persons.stream();
        System.out.println("Количество лиц не достигших совершеннолетия в переписываемом городе равно: " + stream.filter(x -> x.getAge() < 18).count());
        List<String> recruit = stream1
                .filter(x -> x.getSex() == Sex.MAN)
                .filter(x -> x.getAge() >= 18 && x.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        List<String> workers = stream2
                .filter(x -> x.getAge() >= 18)
                .filter(x -> x.getEducation() == Education.HIGHER)
                .filter(x -> (x.getSex() == Sex.MAN && x.getAge() <= 65) || (x.getSex() == Sex.WOMAN && x.getAge() <= 60))
                .sorted(Comparator.comparing(Person::getFamily))
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println("Количество лиц призывного возраста в переписываемом городе равно: " + recruit.size());
        System.out.println("Количество лиц трудоспособного возраста в переписываемом городе равно: " + workers.size());
    }
}