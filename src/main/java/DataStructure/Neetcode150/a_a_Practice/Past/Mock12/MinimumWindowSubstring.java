package DataStructure.Neetcode150.a_a_Practice.Past.Mock12;

import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring()
//                .minWindow("ADOBECODEBANC", "ABC")); // BANC
                .minWindow("ADOBECODEBANC", "ABC")); // ADOBECODEB
    }
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        var list = new HashMap<Character, Integer>();
        var map = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            list.put(t.charAt(i), list.getOrDefault(t.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int r=0,minl=0,minr=0, len = s.length(), minWinLen = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        while (r<len) {
            char sCharAtR = s.charAt(r);
            if(map.containsKey(sCharAtR)) {
                deque.addLast(r);
                if(list.containsKey(sCharAtR)) {
                    if(list.get(sCharAtR)>1) {
                        list.put(sCharAtR, list.get(sCharAtR)-1);
                    } else {
                        list.remove(sCharAtR);
                    }
                }
                map.put(sCharAtR, map.get(sCharAtR)-1);
                //.minWindow("ADAOABECODEBANC", "ABC")); // BANC
                // [B,C] {A:0, B:0, C:0} []
                while (!deque.isEmpty() && list.isEmpty()) {
                    int l = deque.pollFirst();
                    if (minWinLen > (r - l + 1)) {
                        minWinLen = (r - l + 1);
                        minl = l;
                        minr = r;
                    }
                    char sCharAtL = s.charAt(l);
                    map.put(sCharAtL, map.get(sCharAtL)+1);
                    if(map.get(sCharAtL)>0) {
                        list.put(sCharAtL, 1);
                    }
                }
            }
            r++;
        }
        if(minWinLen==Integer.MAX_VALUE) return "";
        return s.substring(minl,minr+1);
    }
}
