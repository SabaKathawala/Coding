package leetcode;

public class FirstMissingPositive41 {
    //try this when free: keep the elements at their index. Then loop to check index==value at index

    //separate positive and negatives
    //mark indices of the array with the positive values as negative
    //find the first positive index
    //
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1) {
                if (nums[i] <= 0 || nums[i] >= n)
                    break;

                if(nums[i]==nums[nums[i]-1])
                    break;

                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++){
            if (nums[i] != i + 1){
                return i + 1;
            }
        }

        return n + 1;
    }


    public static void main(String[] args) {
        System.out.println(-0 > 0);
        new FirstMissingPositive41().firstMissingPositive(new int[]{0,1,4,3});
    }
}
