package leetcode.integer_arithmetic;

public class SumOfTwoIntegers371 {
    public static int getSum(int a, int b) {
        int sum = 0;

        //overflow
        int i = 0;
        int carry = 0;
        int one = 1;

        while(i < 32) {
            if((a & one) > 0 && (b & one) > 0) {
                if(carry == 1) {
                    sum ^= one;
                } else {
                    carry = 1;
                }
            } else {
                int temp = ((a&one) | (b&one)) > 0 ? 1 : 0;
                if((temp ^ carry) == 1) {
                    sum ^= one;
                    carry = 0;
                } else if ((temp & carry) == 1){
                    carry = 1;
                }
            }
            i++;
            one <<= 1;
        }
        System.out.println(sum);
        return sum;
    }
    public static int titleToNumber(String s) {

        char[] columnTitle = s.toCharArray();
        double columnNumber = columnTitle[columnTitle.length-1]-'A'+1;
        for(int i = columnTitle.length-2, j=1; i>=0; i--, j++) {
            columnNumber += (columnTitle[i]-'A'+1) * Math.pow(26,j);
        }

        return (int)columnNumber;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("CFDGSXM"));
        getSum(-5,-8);
    }
}
