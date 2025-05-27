package JavaConcepts.Collections.MapRelated;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByKey {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>() {{
            put(1, "one");
            put(3, "three");
            put(2, "two");
        }};

        map = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (ov, nv) -> nv,
                        LinkedHashMap::new));

        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
            System.out.println();
        }
    }
}
