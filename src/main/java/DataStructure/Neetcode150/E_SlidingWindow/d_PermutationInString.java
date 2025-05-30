package DataStructure.Neetcode150.E_SlidingWindow;

import java.util.Arrays;

public class d_PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        String[] s1ArrSorted = s1.split("");
        Arrays.sort(s1ArrSorted);

        int s1Len = s1.length();
        int s2Len = s2.length();
        int i = 0;

        while (i <= (s2Len - s1Len)) {
            String sub = s2.substring(i, i + s1Len);
            String[] subArrSorted = sub.split("");
            Arrays.sort(subArrSorted);
            if(Arrays.equals(s1ArrSorted, subArrSorted)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
