package DataStructure.Neetcode.C_Stack;

import java.util.Arrays;
import java.util.Stack;

public class e_DailyTemperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res  = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int j = i+1;
            while (j < temperatures.length) {
                if(temperatures[j] > temperatures[i]) {
                    res[i] = j-i;
                    break;
                }
                j++;
            }
        }
        return res;
    }
}
