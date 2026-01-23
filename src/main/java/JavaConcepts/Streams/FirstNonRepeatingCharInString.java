package JavaConcepts.Streams;

import java.util.*;
import java.util.stream.*;

public class FirstNonRepeatingCharInString {
    //^ i/p: dacedaccfij
    //^ o/p: e
    public String getFirstNonRepChar(String str) {
        String[] strArr = str.split("");
        var map = Arrays.stream(strArr)
                .collect(Collectors.toMap(
                        k->k,
                        v->1,
                        (ov,nv) -> ov+1,
                        LinkedHashMap::new
                        )
                );
        System.out.println(map);
        String ret = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .findFirst().get().getKey();
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new FirstNonRepeatingCharInString().getFirstNonRepChar("dacedaccfij"));
    }
}
