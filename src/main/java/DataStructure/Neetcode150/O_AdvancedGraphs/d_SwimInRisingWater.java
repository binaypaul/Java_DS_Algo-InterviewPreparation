package DataStructure.Neetcode150.O_AdvancedGraphs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class d_SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        LinkedHashMap<Integer, List<int[]>> adj = createAdjGraph(grid);
        return 0;
    }
    
    private LinkedHashMap<Integer, List<int[]>> createAdjGraph(int[][] grid) {
        var adj = new LinkedHashMap<Integer, List<int[]>>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                adj.putIfAbsent(grid[i][j], new ArrayList<>());
                if(j+1 < grid.length)
                    adj.get(grid[i][j]).add(new int[]{grid[i][j+1], Math.abs(grid[i][j+1]-grid[i][j])});
                if(i+1 < grid.length)
                    adj.get(grid[i][j]).add(new int[]{grid[i+1][j], Math.abs(grid[i+1][j]-grid[i][j])});
            }
        }
        return adj;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        System.out.println(new d_SwimInRisingWater().swimInWater(grid));
    }
}
