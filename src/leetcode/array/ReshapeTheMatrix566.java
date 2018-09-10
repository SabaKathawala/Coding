package leetcode.array;

public class ReshapeTheMatrix566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int numRow = nums.length;
        int numCol = nums[0].length;
        if(!(r*c == numRow*numCol)) {
            return nums;
        }
        int[][] newMatrix = new int[r][c];
        int row = 0;
        int col = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums[i].length; j++) {
                if(col > c-1) {
                    row++;
                    col = 0;
                }
                //System.out.println(row + " " + col);
                newMatrix[row][col++] = nums[i][j];
            }
        }

        return newMatrix;
    }

    //modulus way
    /*
    The idea behind this approach is as follows. Do you know how a 2-D array is stored in the main memory(which is 1-D in nature)?
    It is internally represented as a 1-D array only. The element nums[i][j]nums[i][j] of numsnums array is represented in the form of
    a one dimensional array by using the index in the form: nums[n*i + j]nums[n∗i+j], where mm is the number of columns in the given matrix.
    Looking at the same in the reverse order, while putting the elements in the elements in the resultant matrix,
    we can make use of a countcount variable which gets incremented for every element traversed as if we are
    putting the elements in a 1-D resultant array. But, to convert the countcount back into 2-D matrix indices with
    a column count of cc, we can obtain the indices as res[count/c][count\%c]res[count/c][count%c] where count/ccount/c is the
    row number and count\%ccount%c is the coloumn number. Thus, we can save the extra checking required at each step.
     */
    public int[][] matrixReshapeModulus(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return res;
    }


}
