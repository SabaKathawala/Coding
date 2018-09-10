package leetcode.array;

import java.util.ArrayList;

public class MissingNumber268 {

    //https://leetcode.com/problems/missing-number/solution/
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

    public int missingNumberBitManipulation(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber268().missingNumber(new int[]{0,2}));
    }
    public int findShortestSubArray(int[] nums) {
        int[] count = new int[50001];
        int max = 0;
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i=0;i<nums.length; i++) {
            count[nums[i]]++;
            if(count[nums[i]] > max) {
                max = count[nums[i]];
                num.clear();
                num.add(nums[i]);
            } else if(count[nums[i]] == max) {
                if(!num.contains(nums[i])) {
                    num.add(nums[i]);
                }
            }
        }
        int minLength = Integer.MAX_VALUE;
        for(Integer in: num) {
            int start = 0;
            for (int i=0; i<nums.length; i++) {
                if(nums[i] == in) {
                    start = i;
                    break;
                }
            }
            int stop = 0;
            for (int i=nums.length-1; i>=0; i--) {
                if(nums[i] == in) {
                    stop = i;
                    break;
                }
            }
            minLength = Math.min(minLength, stop-start+1);
        }
        return minLength;
    }
}
