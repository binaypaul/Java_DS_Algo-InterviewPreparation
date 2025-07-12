package JavaConcepts.Collections.MapRelated.SortMapByValue;

import java.util.*;
import java.util.stream.Collectors;

public class SortMapByValue_ComplexValueObject {
    public static void main(String[] args) {
        Map<String, Person> hashMap = new HashMap<String, Person>() {{
            put("one", new Person(1, "Rahi"));
            put("two", new Person(31, "Jui"));
            put("three", new Person(31, "Binay"));
            put("four", new Person(75, "Baba"));
            put("five", new Person(70, "Maa"));
        }};

        hashMap = hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(new AgeComparator()))
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


class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.age, o2.age);
    }
}