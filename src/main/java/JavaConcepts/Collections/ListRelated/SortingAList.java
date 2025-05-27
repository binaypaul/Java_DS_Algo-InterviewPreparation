package JavaConcepts.Collections.ListRelated;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingAList {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>(){{
            add(1);
            add(3);
            add(2);
        }};
        //natural order
        Collections.sort(l);
        System.out.println(l);

        //reverse order
        l.sort(Comparator.reverseOrder());
        System.out.println(l);

        //natural order
        Collections.sort(l, Comparator.naturalOrder());
        System.out.println(l);

        //reverse order
        l = l.stream().sorted((x,y)->Integer.compare(y,x)).collect(Collectors.toList());
        System.out.println(l);
    }
}
