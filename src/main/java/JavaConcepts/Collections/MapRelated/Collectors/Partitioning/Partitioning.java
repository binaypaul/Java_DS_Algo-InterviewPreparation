package JavaConcepts.Collections.MapRelated.Collectors.Partitioning;

import JavaConcepts.Collections.MapRelated.Collectors.*;
import java.util.*;
import java.util.stream.*;

public class Partitioning {
    public static void main(String[] args) {
        Emp ram = new Emp(1, "Ram", 5000, "Finance");
        Emp shyam = new Emp(2, "Shyam", 5000, "Account");
        Emp tom = new Emp(3, "Tom", 4000, "Finance");
        Emp harry = new Emp(4, "Harry", 6000, "Account");
        Emp ricky = new Emp(4, "Harry", 7000, "Hr");

        List<Emp> emps = List.of(ram, shyam, tom, harry, ricky);


        System.out.println(emps.stream()
                .collect(Collectors.partitioningBy(
                        (Emp e)-> e.getSalary()<=5000,
                        Collectors.toList())));
    }
}