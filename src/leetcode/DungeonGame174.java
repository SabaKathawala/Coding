package leetcode;

public class DungeonGame174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] minHP = new int[rows][cols];
        int[][] currentHP = new int[rows][cols];
        if(dungeon[0][0] <= 0) {
            minHP[0][0] = 1 + Math.abs(dungeon[0][0]);
            currentHP[0][0] = 1;
        } else {
            minHP[0][0] = 1;
            currentHP[0][0] = dungeon[0][0];
        }


        //first row
        for(int i=1; i<cols; i++) {
            int diff = currentHP[0][i-1] + dungeon[0][i];
            if(diff <= 0) {
                minHP[0][i] = 1 + Math.abs(diff) + minHP[0][i-1];
                currentHP[0][i] = 1;
            } else {
                minHP[0][i] = minHP[0][i-1];
                currentHP[0][i] = dungeon[0][i] + currentHP[0][i-1];
            }
        }
        //first col
        for(int i=1; i<rows; i++) {
            int diff = currentHP[i-1][0] + dungeon[i][0];
            if(diff <= 0) {
                minHP[i][0] = 1 + Math.abs(diff) + minHP[i-1][0];
                currentHP[i][0] = 1;
            } else {
                minHP[i][0] = minHP[i-1][0];
                currentHP[i][0] = dungeon[i][0] + currentHP[i-1][0];
            }
        }
        //next cells in row wise manner
        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                int top = currentHP[i-1][j] + dungeon[i][j];
                int left = currentHP[i][j-1] + dungeon[i][j];
                if(top <= 0 && left <=0) {
                    if(top == left) {
                        minHP[i][j] = 1 + Math.abs(top) + Math.min(minHP[i-1][j], minHP[i][j-1]);
                    }
                    else {

                    }
                    currentHP[i][j] = 1;
                } else if(top > 0 || left > 0) {
                    if(minHP[i-1][j] > minHP[i][j-1]) {
                        minHP[i][j] = minHP[i-1][j];
                        currentHP[i][j] = top;
                    } else if(minHP[i-1][j] < minHP[i][j-1]){
                        minHP[i][j] = minHP[i][j-1];
                        currentHP[i][j] = left;
                    } else {
                        minHP[i][j] = minHP[i][j-1];
                        currentHP[i][j] = Math.max(left, top);
                    }
                }
            }
        }
        return minHP[rows-1][cols-1];
    }
    public int shortestSubarray(int[] A, int K) {
        int sum = 0;
        int length = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++) {
            sum += A[i];
            if(sum >=  K) {
                length = Math.min(length, i+1);
            }
        }
        int temp = sum;
        for(int i=0; i<A.length; i++) {
            for(int j=A.length-1; j>=i; j--) {
                if(sum >=  K) {
                    length = Math.min(length, j-i+1);
                }
                temp -= A[j];
            }
            sum-=A[i];
            temp = sum;
        }
        return length == Integer.MAX_VALUE ? -1: length;

    }

    public static void main(String[] args) {
        //new DungeonGame174().calculateMinimumHP(new int[][]{{-2,-3,3}, {-5,-10,1}, {10,30,-5}});
        new DungeonGame174().shortestSubarray(new int[]{2,1}, 3);
    }
}
