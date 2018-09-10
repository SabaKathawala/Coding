package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LargestRectangleInHistogram84 {
    class Neighbour {
        int right;
        int left;
    }
    public int largestRectangleArea(int[] heights) {
        List<Neighbour> neighbours = new ArrayList<>();
        int maxSum = 0;
        int i=0;
        while(i+1<heights.length && heights[i+1] >= heights[i]) {
            i++;
        }
        Neighbour nb = new Neighbour();
        nb.left = 0;
        nb.right = i;
        neighbours.add(nb);
        maxSum = (i+1)*heights[0];
        for(i=1; i<heights.length;i++) {
            int bars = 1;
            if(i-1 >=0 && heights[i] <= heights[i-1]) {
                Neighbour n = neighbours.get(i-1);
                int j = n.left < i ? n.left : i;
                while(j-1 >= 0 && heights[j-1] >= heights[i]) {
                    j--;
                }
                nb = new Neighbour();
                nb.left = j;
                bars += i-j;
                j = n.right > i ? n.right: i;
                while(j+1 < heights.length && heights[j+1] >= heights[i]) {
                    j++;
                }
                bars += j-i;
                nb.right = j;
                neighbours.add(nb);
            } else if(i+1< heights.length && heights[i] <= heights[i+1]) {
                int j=i;
                while(j+1 < heights.length && heights[j+1] >= heights[i]) {
                    j++;
                }
                bars += j-i;
                nb = new Neighbour();
                nb.left = i;
                nb.right = j;
                neighbours.add(nb);
            }
            else {
                nb = new Neighbour();
                nb.left = i;
                nb.right = i;
                neighbours.add(nb);
            }

            maxSum = Math.max(maxSum, bars*heights[i]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        new LargestRectangleInHistogram84().largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}
