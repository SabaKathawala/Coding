package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FIndDisappearedNumbers448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length;i++) {
            if(nums[Math.abs(nums[i])-1] > 0) {
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                missingNumbers.add(i+1);
            }
        }
        return missingNumbers;
    }
}
