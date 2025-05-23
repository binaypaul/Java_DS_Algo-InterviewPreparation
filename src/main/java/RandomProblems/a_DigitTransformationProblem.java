package RandomProblems;
/*
The Digit Transformation Problem, where:

You are given a start number and an end number (both non-negative integers).
You can only transform digits in-place using three operations:
Double a digit (only if result ≤ 9),
Increment a digit (only if digit < 9),
Decrement a digit (only if digit > 0).
We need to find the minimum number of operations to convert start to end, and also return the path of numbers taken.

Example:
Start: 123, End: 345
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a_DigitTransformationProblem {
    static List<String> pathList = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(new a_DigitTransformationProblem().transform("1123", "345"));
        System.out.println(pathList);
    }

    private int transform(String num, String target) {
        var count=0;
        if(num.length() < target.length()) {
            num ="0"+num;
        } else if (num.length() > target.length()) {
            num = num.substring(1);
        }
        String[] targetstr = target.split("");

        String[] numstr = num.split("");

        for(int i=0;i<numstr.length;i++) {
            while (!numstr[i].equals(targetstr[i])) {
                if (Integer.parseInt(numstr[i]) * 2 <= 9
                        && Integer.parseInt(numstr[i]) * 2 <= Integer.parseInt(targetstr[i])) {
                    numstr[i] = String.valueOf(Integer.parseInt(numstr[i]) * 2);
                    pathList.add(Arrays.stream(numstr.clone()).reduce("", String::concat));
                    count++;
                }
                if (Integer.parseInt(numstr[i]) < 9
                        && Integer.parseInt(numstr[i]) < Integer.parseInt(targetstr[i])) {
                    numstr[i] = String.valueOf(Integer.parseInt(numstr[i]) + 1);
                    pathList.add(Arrays.stream(numstr.clone()).reduce("", String::concat));
                    count++;
                } else if (Integer.parseInt(numstr[i]) > 0
                        && Integer.parseInt(numstr[i]) > Integer.parseInt(targetstr[i])) {
                    numstr[i] = String.valueOf(Integer.parseInt(numstr[i]) - 1);
                    pathList.add(Arrays.stream(numstr.clone()).reduce("", String::concat));
                    count++;
                }
            }
        }
        return count;
    }
}