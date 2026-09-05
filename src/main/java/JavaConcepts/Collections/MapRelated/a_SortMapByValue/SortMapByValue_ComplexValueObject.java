package JavaConcepts.Collections.MapRelated.a_SortMapByValue;

import java.util.*;
import java.util.stream.Collectors;
import lombok.*;

public class SortMapByValue_ComplexValueObject {
    public static void main(String[] args) {
        Map<String, Person> hashMap = new HashMap<String, Person>() {{
            put("one", new Person(1, "Rahi", 50));
            put("two", new Person(31, "Jui", 20));
            put("three", new Person(31, "Rahi", 30));
            put("four", new Person(75, "Baba", 40));
            put("five", new Person(70, "Maa", 10));
        }};

        hashMap = hashMap.entrySet()
                .stream()
                // sorted using NameComparator
                .sorted(Map.Entry.<String, Person>comparingByValue(new NameComparator())
                        // in case of collision when sorting by NameComparator, sort by salary using comparable
                                 .thenComparing(Map.Entry.comparingByValue()))
                .collect(
                        Collectors.toMap(
                                e->e.getKey(),
                                e->e.getValue(),
                                (ov,nv) -> ov, //could not understand the use of this as map cannot have same key so key collision is not possible.
                                LinkedHashMap::new
                        )
                );
        for (Map.Entry<String, Person> e : hashMap.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
            System.out.println();
        }
    }
}

@Data
@AllArgsConstructor
class Person implements Comparable<Person> {
    int age;
    String name;
    int salary;

    @Override
    public int compareTo(Person o) {
        return this.salary-o.salary;
    }
}

class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.age, o2.age);
    }
}

class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.name.compareTo(p2.name);
    }
}