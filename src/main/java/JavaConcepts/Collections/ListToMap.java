package JavaConcepts.Collections;

import JavaConcepts.Collections.MapRelated.b_Collectors.*;
import java.util.*;
import java.util.stream.*;

public class ListToMap {
    public static void main(String[] args) {
        Emp ram = new Emp(1, "Ram", 5000, "Finance");
        Emp shyam = new Emp(2, "Shyam", 5000, "Account");
        Emp tom = new Emp(3, "Tom", 4000, "Finance");
        Emp harry = new Emp(4, "Harry", 6000, "Account");
        Emp ricky = new Emp(4, "Harry", 7000, "Hr");

        List<Emp> emps = List.of(ram, shyam, tom, harry, ricky);

        LinkedHashMap<String, Integer> map = emps
                .stream()
                .collect(Collectors.toMap(
                        Emp::getName,
                        Emp::getSalary,
                        (ov, nv) -> nv,
                        LinkedHashMap::new));
        System.out.println(map);
    }
}