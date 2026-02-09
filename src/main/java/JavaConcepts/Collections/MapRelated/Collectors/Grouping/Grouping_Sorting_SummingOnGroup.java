package JavaConcepts.Collections.MapRelated.Collectors.Grouping;

import JavaConcepts.Collections.MapRelated.Collectors.*;
import java.util.*;
import java.util.stream.*;

class Grouping_Sorting_SummingOnGroup {
    public static void main(String[] args) {
        Emp ram = new Emp(1, "Ram", 5000, "Finance");
        Emp shyam = new Emp(2, "Shyam", 5000, "Account");
        Emp tom = new Emp(3, "Tom", 4000, "Finance");
        Emp harry = new Emp(4, "Harry", 6000, "Account");
        Emp ricky = new Emp(4, "Harry", 7000, "Hr");

        List<Emp> emps = List.of(ram, shyam, tom, harry, ricky);

        //Grouping on deptName -> Sorting by deptName(key) using TreeMap-> summing the salary in each group created Grouping on deptName
        Map<String, Integer> treeMap = emps.stream().collect(
                Collectors.groupingBy(Emp::getDeptName, TreeMap::new, Collectors.summingInt(Emp::getSalary))
        );
        System.out.println(treeMap);

        //Grouping on deptName -> summing the salary in each group created Grouping on deptName
        Map<String, Integer> map = emps.stream().collect(Collectors.groupingBy(Emp::getName, Collectors.summingInt(Emp::getSalary)));
        System.out.println(map);
    }
}