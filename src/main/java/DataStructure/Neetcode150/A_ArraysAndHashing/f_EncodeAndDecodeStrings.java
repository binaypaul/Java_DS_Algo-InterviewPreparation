package DataStructure.Neetcode150.A_ArraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class f_EncodeAndDecodeStrings {
    public static void main(String[] args) {
        String encoded = new f_EncodeAndDecodeStrings().encode(List.of("neet","code","love","you",""));
        System.out.println(encoded);

        System.out.println(new f_EncodeAndDecodeStrings().decode(encoded));
    }

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length()).append("#").append(str);
        }
        return builder.toString();
    }

    //4#neet4#code4#love3#you
    //012345678
    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int indexOfHash = str.indexOf("#", i);
            int len = Integer.parseInt(str.substring(i, indexOfHash));
            i = indexOfHash+len+1;
            list.add(str.substring(indexOfHash+1, i));
        }
        return list;
    }
}