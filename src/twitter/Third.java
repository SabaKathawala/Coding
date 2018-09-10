package twitter;

/* Find Regions */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Third {

    private static int countMatches(List<String> grid1, List<String> grid2) {
        return matchingGrid(getArray(grid1), getArray(grid2));
    }

    private static int[][] getArray(List<String> g1) {
        int[][] result = new int[g1.size()][g1.get(0).length()];
        for (int i=0;i<g1.size();i++) {
            for(int j=0;j<g1.get(i).length();j++)
                result[i][j] = g1.get(i).charAt(j) == '0' ? 0 : 1;
        }
        return result;
    }

    private static int matchingGrid(int[][] grid1, int[][] grid2) {
        if(grid1 == null || grid2 == null || grid1.length == 0 || grid2.length == 0) return 0;
        if(grid1.length != grid2.length || grid1[0].length != grid2[0].length) return 0;
        grid1 = findRegion(grid1);
        grid2 = findRegion(grid2);

        Set<Integer> match = new HashSet<>();
        Set<Integer> misMatch = new HashSet<>();
        for(int i = 0; i < grid1.length; i++) {
            for(int j = 0; j < grid1[0].length; j++) {
                if(grid1[i][j] == grid2[i][j]) match.add(grid1[i][j]);
                else {
                    misMatch.add(grid1[i][j]);
                    misMatch.add(grid2[i][j]);
                }
            }
        }

        match.removeAll(misMatch);
        match.remove(0);
        return match.size();

    }

    private static int[][] findRegion(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) continue;
                int region = i * grid.length + j + 1;
                if(i != 0 && grid[i-1][j] != 0) region = Math.min(region, grid[i - 1][j]);
                if(j != 0 && grid[i][j-1] != 0) region = Math.min(region, grid[i][j - 1]);
                grid[i][j] = region;
                updateGrid(grid, i - 1, j, region);
                updateGrid(grid, i + 1, j, region);
                updateGrid(grid, i, j - 1, region);
                updateGrid(grid, i, j + 1, region);
            }
        }

        return grid;
    }

    private static  void updateGrid(int[][] grid, int i, int j, int value) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == value) return;
        grid[i][j] = value;
        updateGrid(grid, i - 1, j, value);
        updateGrid(grid, i + 1, j, value);
        updateGrid(grid, i, j - 1, value);
        updateGrid(grid, i, j + 1, value);
    }

    public static void main(String[] args) {
        int totalHammingDistance = 0;
        int[] nums = {4,14,2};
        int one = 1;
        int size = nums.length;
        for(int i=0; i<32; i++) {
            int numOnes = 0;
            for(int num: nums) {
                if((num & one) == one) {
                    numOnes++;
                }
            }
            totalHammingDistance += numOnes * (size-numOnes);
            one <<= 1;
        }

        List<String> g1 = new ArrayList<>();
        g1.add("0100");
        g1.add("1001");
        g1.add("0011");
        g1.add("0011");
        List<String> g2 = new ArrayList<>();
        g2.add("0101");
        g2.add("1001");
        g2.add("0011");
        g2.add("0011");
        System.out.println(countMatches(g1, g2));
    }

}
