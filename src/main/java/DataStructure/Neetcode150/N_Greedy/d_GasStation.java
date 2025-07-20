package DataStructure.Neetcode150.N_Greedy;

//https://leetcode.com/problems/gas-station/description/
public class d_GasStation {
    public static void main(String[] args) {
        System.out.println(new d_GasStation()
            .canCompleteCircuit(
                new int[]{1,2,3,4,1,5},
                new int[]{3,4,5,1,2,1}
            )
        );
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, curr = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            curr += diff;
            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}
