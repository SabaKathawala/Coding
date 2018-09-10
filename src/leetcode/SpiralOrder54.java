package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrder = new ArrayList<>();
        int level = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int levels = n%2 == 0 ? n/2-1 : n/2;
        System.out.println(levels);
        while(level <= levels) {
            n-=1;
            m-=1;
            int i = level;
            int j = i;
            while(j<= m-1) {
                spiralOrder.add(matrix[i][j]);
                j++;
            }
            while(i <= n-1) {
                spiralOrder.add(matrix[i][j]);
                i++;
            }

            while(j >= level+1) {
                spiralOrder.add(matrix[i][j]);
                j--;
            }
            while(i >= level+1) {
                spiralOrder.add(matrix[i][j]);
                i--;
            }
            level++;
        }
        return spiralOrder;
    }

    public static void main(String[] args) {
        new SpiralOrder54().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
