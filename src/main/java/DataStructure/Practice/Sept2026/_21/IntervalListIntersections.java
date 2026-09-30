package DataStructure.Practice.Sept2026._21;

import java.util.*;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int flen = firstList.length, slen = secondList.length;
        if(flen==0 || slen==0) return new int[][]{};

        List<int[]> ret = new ArrayList<>();
        int f = 0, s = 0;

        while (f<flen && s<slen) {
            int[] fcur = firstList[f];
            for (int i = s; i < slen; i++) {
                if(fcur[1] < secondList[i][0]) {
                    //noOverlap
                    break;
                } else if (fcur[0] > secondList[i][1]){
                    continue;
                }
                //overlap
                ret.add(intersection(fcur, secondList[i]));
            }
            int[] scur = secondList[s];
            for (int i = f+1; i < flen; i++) {
                if(scur[1] < firstList[i][0]) {
                    //noOverlap
                    break;
                } else if (scur[0] > firstList[i][1]) {
                    continue;
                }
                //overlap
                ret.add(intersection(scur,firstList[i]));
            }
            f++;s++;
        }
        return ret.toArray(new int[ret.size()][]);
    }
    private int[] intersection(int[] fcur, int[] scur) {
        int minStInt = Math.min(fcur[0],scur[0]);
        int maxEnInt = Math.max(fcur[1],scur[1]);

        if(minStInt == fcur[0] && maxEnInt==fcur[1]) {
            return scur;
        } else if(minStInt == scur[0] && maxEnInt==scur[1]) {
            return fcur;
        } else {
            int maxStInt = Math.max(fcur[0], scur[0]);
            int minEnInt = Math.min(fcur[1], scur[1]);
            return new int[] {Math.min(maxStInt, minEnInt), Math.max(maxStInt, minEnInt)};
        }
    }
    public static void main(String[] args) {
        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        var ret = intervalListIntersections.intervalIntersection(firstList, secondList);
        //int[][] expected = {{1,2},{5,5},{8,10},{15,23},{24,24},{25,25}};
        System.out.println(Arrays.deepToString(ret));
    }
}
