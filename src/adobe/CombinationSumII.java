package adobe;

import java.util.*;

/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used "once" in the combination.
Sort but do not filter out dupliactes.
Once all combinations for a starting positions are done: increment till index has a new value

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
 */

//recursion:
//condition: sum < 0(subtracting from target sum), sum == 0
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<Integer> lists = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        findCombinations(candidates, lists, finalList, target, 0) ;
        return finalList;

    }

    public static void findCombinations(int[] candidates,  List<Integer> lists, List<List<Integer>> finalList, int target, int index) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            finalList.add(new ArrayList<>(lists));
            return;
        }
        // checking for target-candidates[index] so that elements > target are not considered
        while(index< candidates.length && target - candidates[index] >=0 ){
            // add to possible combinations
            int val = candidates[index];
            lists.add(val);

            //will fill in the list till sum=0 or sum < 0
            findCombinations(candidates, lists, finalList, target-val, ++index);

            // backtrack
            // start with the last element removed
            lists.remove(lists.size()-1);

            // to remove duplicate sets
            while(index < candidates.length && val == candidates[index]) {
                index++;
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> a = new CombinationSumII().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for( List l: a) {
            for (Object i: l) {
                System.out.print(i.toString() + " ");
            }
            System.out.println();
        }
    }
}
