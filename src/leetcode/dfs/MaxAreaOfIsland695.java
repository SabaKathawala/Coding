package leetcode.dfs;


public class MaxAreaOfIsland695 {
    static int count = 0;
    /*
    Cleaner code
     */
    /*public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                maxArea = Math.max(maxArea, findAdjacentOnes(grid, i,j));
            }
        }
        return maxArea;
    }

    private static int findAdjacentOnes(int[][] grid, int i, int j) {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == -1 || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = -1;
        return (1 + findAdjacentOnes(grid, i+1,j) + findAdjacentOnes(grid, i-1,j)
                + findAdjacentOnes(grid, i,j+1) + findAdjacentOnes(grid, i,j-1));
    }*/

    /*
    My code
    */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    findAdjacentOnes(grid, i,j);
                }
                maxArea = Math.max(maxArea, count);
                count = 0;
            }
        }
        return maxArea;
    }

    private static void findAdjacentOnes(int[][] grid, int i, int j) {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 ) {
            return;
        }

        if(grid[i][j] == 1) {
            count++;
            grid[i][j] = -1;
            findAdjacentOnes(grid, i+1,j);
            findAdjacentOnes(grid, i-1,j);
            findAdjacentOnes(grid, i,j+1);
            findAdjacentOnes(grid, i,j-1);
        }

    }
}
