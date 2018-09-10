package leetcode;

import sun.security.krb5.internal.PAData;

public class  PaintHouse{
    public int minCost(int[][] costs) {
        if(costs.length == 0) {
            return 0;
        }
        int redStart = costs[0][0];
        int greenStart = costs[0][1];
        int blueStart = costs[0][2];
        int red = 0, green =1, blue = 2;
        return Math.min(findMinCost(red, redStart, costs),
                Math.min(findMinCost(green, greenStart, costs), findMinCost(blue, blueStart, costs)));
    }

    private static int findMinCost(int color, int start, int[][] costs) {
        for(int i=1; i<costs.length; i++) {
            if(color == 0) {
                if(costs[i][1] > costs[i][2]) {
                    color = 2;
                    start += costs[i][2];
                } else {
                    color = 1;
                    start += costs[i][1];
                }
            } else if(color == 1) {
                if(costs[i][0] > costs[i][2]) {
                    color = 2;
                    start += costs[i][2];
                } else {
                    color = 0;
                    start += costs[i][0];
                }
            } else {
                if(costs[i][1] > costs[i][0]) {
                    color = 0;
                    start += costs[i][0];
                } else {
                    color = 1;
                    start += costs[i][1];
                }
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[][] costs = {{5,8,6},{19,14,13},{7,5,12},{14,15,17},{3,20,10}};
        int len = costs.length;
        new PaintHouse().minCost(costs);
        for (int i=1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        Math.min(Math.min(costs[len][0], costs[len][1]), costs[len][2]);
    }
}
