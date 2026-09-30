package DataStructure.Practice.Sept2026._27_2;

import java.util.*;

public class MagicDictionary {
    Map<Integer, List<String>> map;
    int charDif;
    public MagicDictionary() {
        map = new HashMap<>();
        charDif = 1;
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            int len = word.length();
            map.computeIfAbsent(len, k-> new ArrayList<>()).add(word);
        }
    }

    public boolean search(String searchWord) {
        if(!map.containsKey(searchWord.length())) return false;

        List<String> sameLenWords = map.get(searchWord.length());
        for (String sameLenWord : sameLenWords) {

            int c = 0;
            for (int i = 0; i < searchWord.length(); i++) {
                if(searchWord.charAt(i) != sameLenWord.charAt(i)) {
                    c++;
                }
            }
            if(c==charDif) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        MagicDictionary md = new MagicDictionary();
        md.buildDict(new String[]{"hello", "leetcode"});

        var ret = md.search("hello");    // false (matches itself exactly, 0 changes — not "exactly one")
        System.out.println(ret);
        ret = md.search("hhhlo");    // true (change 'h' at index 1 to 'e' -> "hello")
        System.out.println(ret);
        ret = md.search("hell");     // false (different length, can't match with exactly one char change)
        System.out.println(ret);
        ret = md.search("leetcoded");// false
        System.out.println(ret);
    }
}
