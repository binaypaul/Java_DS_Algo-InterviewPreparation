package JavaConcepts.Collections.MapRelated.SortMapByValue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByValue_SimpleValueType {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("two", 2);
            put("one", 1);
            put("three", 3);
        }};

        map = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        e->e.getKey(),
                        e->e.getValue(),
                        (ov,nv) -> ov, //could understand find the use of this as map cannot have same key so key collision is not possible.
                        LinkedHashMap::new));
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
            System.out.println();
        }
    }
}
