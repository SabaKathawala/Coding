package adobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
 */
public class CombinationSumIV {
    static int count = 0;
    public List<List<Integer>> combinationSum4(int[] nums, int target) {
        List<Integer> lists = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(target - nums[i] >= 0) {
                lists.add(nums[i]);
                findCombinations(nums, lists, finalList, target-nums[i], i, 0);
                lists.clear();
            }
        }
        return finalList;
    }

    public static void findCombinations(int[] candidates, List<Integer> lists, List<List<Integer>> finalList, int target, int current, int rest) {

        if(target < 0) {
            return;
        }

        if(target == 0) {
            finalList.add(new ArrayList<>(lists));
            return;
        }

        // checking for target-candidates[index] so that elements > target are not considered
        while(rest < candidates.length && target >=0){
            // add to possible combinations
            int val = candidates[rest];
            lists.add(val);

            //will fill in the list till sum=0 or sum < 0
            findCombinations(candidates, lists, finalList, target-val, current, 0);

            // backtrack
            // start with the last element removed
            lists.remove(lists.size()-1);
            rest++;
        }
    }

    public static void countCombinations(int[] candidates, int target, int current, int rest) {

        if(target < 0) {
            return;
        }

        if(target == 0) {
            count++;
            return;
        }

        // checking for target-candidates[index] so that elements > target are not considered
        while(rest < candidates.length && target >=0){
            // add to possible combinations
            int val = candidates[rest];

            //will fill in the list till sum=0 or sum < 0
            countCombinations(candidates, target-val, current, 0);

            // backtrack
            // start with the last element removed
            rest++;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> a = new CombinationSumIV().combinationSum4(new int[]{}, 1);
        for( List l: a) {
            for (Object i: l) {
                System.out.print(i.toString() + " ");
            }
            System.out.println();
        }
        countCombinations(new int[]{1,2,3}, 32, 0, 0);
        System.out.println(count);
    }


}
