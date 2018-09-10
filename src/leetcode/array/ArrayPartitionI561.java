package leetcode.array;

import java.util.Arrays;

public class ArrayPartitionI561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i+=2) {
            sum+=nums[i];
        }
        return sum;
    }

    //fastest solution
    public int arrayPairSumFast(int[] nums) {
        int res = 0;
        int[] count = new int[20001];
        for(int i : nums){
            count[i + 10000]++;
        }

        boolean odd = true;
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                if(odd){
                    res += i - 10000;
                }
                odd = !odd;
                count[i]--;
            }
        }

        return res;
    }
}
