package JavaConcepts.Collections.MapRelated.SortMapByValue;

import java.util.*;
import java.util.stream.Collectors;

public class SortByValue_ThenSortByKey_SimpleValueType {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("b", 1);
            put("a", 1);
            put("c", 3);
        }};

        map = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed() //* sorting in desc ord (boro theke choto)
                        .thenComparing(Map.Entry.<String, Integer>comparingByKey())) //* in case of same value, sort in asc order of key (choto theke boro)
                .collect(Collectors.toMap(
                        e->e.getKey(),
                        e->e.getValue(),
                        (ov,nv) -> ov, //could understand find the use of this as map cannot have same key so key collision is not possible.
                        LinkedHashMap::new));
        System.out.println(map);
    }
}
