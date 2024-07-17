package DataStructure.Neetcode.C_Stack;

import java.util.Arrays;
import java.util.Stack;

public class e_DailyTemperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {30,60,90})));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int x, y, count=0;
        int[] res  = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            x = temperatures[i];
            int j = i+1;

            while (j < temperatures.length) {
                y = temperatures[j];
                if(y > x) {
                    res[i] = j-i;
                    break;
                }
                j++;
            }
        }
        return res;
    }
}
