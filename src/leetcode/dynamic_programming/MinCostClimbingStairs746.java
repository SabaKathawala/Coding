package leetcode.dynamic_programming;

public class MinCostClimbingStairs746 {

    //can be solved by using 3 variables instead of array: try that
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[2001];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        int i=2;
        for(; i<cost.length; i++) {
            minCost[i] = cost[i] + Math.min(minCost[i-1] , minCost[i-2]);
        }
        return Math.min(minCost[i-1] , minCost[i-2]);
    }


}
