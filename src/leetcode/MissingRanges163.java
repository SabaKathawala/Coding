package leetcode;

import leetcode.array.MissingNumber268;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missingRanges = new ArrayList<>();
        if(nums.length == 0) {
            if(lower == upper) {
                missingRanges.add(String.valueOf(lower));
            } else {
                missingRanges.add(new String(lower + "->" + upper));
            }
            return missingRanges;
        }
        int j=0;
        for(int i=0; j+lower <= upper && i<nums.length; i++, j++) {
            while(i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }

            if(i< nums.length && nums[i] != j+lower) {
                StringBuilder sb = new StringBuilder();
                sb.append(j+lower);

                if(j+lower+1 == nums[i]) {
                    missingRanges.add(sb.toString());
                    j++;
                    continue;
                }
                sb.append("->");
                sb.append(nums[i]-1);
                j = nums[i]-lower;
                missingRanges.add(sb.toString());
            }
        }
        if(upper != nums[nums.length-1] && j+lower < upper) {
            missingRanges.add((j+lower) + "->" + upper);
        } else if(j+lower == upper) {
            missingRanges.add(String.valueOf(upper));
        }
        return missingRanges;
    }

    public static void main(String[] args) {
        new MissingRanges163().findMissingRanges(new int[]{-1000000000,-9999,0,1,2,10,100,1000,999999999,1000000000}, -1000000000, 1000000000);
    }

    // really neat solution
    public List<String> findMissingRangesClean(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            result.add(group(lower, upper));
            return result;
        }

        if (nums[0] != lower) {
            result.add(group(lower, nums[0] - 1));
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1 && nums[i] != nums[i - 1]) {
                result.add(group(nums[i - 1] + 1, nums[i] - 1));
            }
        }

        if (nums[nums.length - 1] != upper) {
            result.add(group(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }

    private String group(int l, int r) {
        if (l == r) {
            return l + "";
        } else {
            return l + "->" + r;
        }
    }
}
