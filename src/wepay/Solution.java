package wepay;

public class Solution {

    static boolean alert(int[] inputs, int windowSize, float allowedIncrease) {
        double sum = 0;
        double[] averages = new double[inputs.length];
        double min_average = Double.MAX_VALUE;
        for (int i = 0; i < windowSize; i++) {
            sum += inputs[i];
        }
        for (int i = 0; i < inputs.length - windowSize ; i++) {
            double average = sum/windowSize;
            averages[i] = (average)*allowedIncrease;
            if(min_average > averages[i]) {
                min_average = averages[i];
            }
            if(checkConditionOne(i-windowSize+1>0?i-windowSize:0, i, averages, inputs[i])) {
                return false;
            }
            if(min_average < average) {
                return false;
            }
            sum-=inputs[i];
            sum+=inputs[i+1];

        }

        return false;
    }

    private static boolean checkConditionOne(int start, int end, double[] averages, long value) {
        for (int i=start; i<=end ; i++) {
            if(value > averages[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(alert(new int[]{
                1,
                1,
                1,
                1,
                200,
                200,
                1,
                1,
                1},
                2,
        1.5f)?1:0);
    }
}
