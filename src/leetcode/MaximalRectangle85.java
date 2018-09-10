package leetcode;

public class MaximalRectangle85 {
    class Rectangle {
        int length;
        int breadth;
        Rectangle(int length, int breadth) {
            this.length = length;
            this.breadth = breadth;
        }
    }
    public int maximalRectangle(char[][] matrix) {
        Rectangle[][] area = new Rectangle[matrix.length][matrix[0].length];

        area[0][0] = matrix[0][0] == '1' ? new Rectangle(1,1) : new Rectangle(0,0);
        //filling first row
        for(int j=1; j<matrix[0].length; j++) {
            if(matrix[0][j] == '1') {
                area[0][j] = new Rectangle(1, area[0][j-1].breadth+1);
            } else {
                area[0][j] = new Rectangle(0,0);
            }
        }

        //filling first col
        for(int i=1; i<matrix.length; i++) {
            if(matrix[i][0] == '1') {
                area[i][0] = new Rectangle(area[i-1][0].length + 1, 1);
            } else {
                area[i][0] = new Rectangle(0,0);
            }
        }

        //filling rest of the matrix
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    if(area[i-1][j-1].breadth == 0) {
                        area[i][j] = new Rectangle(1,area[i][j-1].breadth+1);
                    } else if(area[i][j-1].breadth == 0) {
                        area[i][j] = new Rectangle(area[i-1][j].length+1,1);
                    } else {
                        area[i][j] = new Rectangle(area[i-1][j].length+1,
                                Math.min(area[i][j-1].breadth, area[i-1][j-1].breadth)+1);
                    }
                } else {
                    area[i][j] = new Rectangle(0,0);
                }
            }
        }

        //find max area
        int maxArea = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                maxArea = Math.max(area[i][j].length * area[i][j].breadth, maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        new MaximalRectangle85().maximalRectangle(new char[][] {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}});
//        new MaximalRectangle85().maximalRectangle(new char[][] {{'0','0','0'},
//                {'0','0','0'},
//                {'1','1','1'}});
    }
}
