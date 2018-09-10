package adobe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k , int n) {

        List<Integer> lists = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        findCombinations(1, lists, finalList, n, 0, k) ;
        return finalList;

    }

    public static void findCombinations(int candidate,  List<Integer> lists, List<List<Integer>> finalList, int target, int step, int k) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            if(step == k) {
                finalList.add(new ArrayList<>(lists));
            }
            return;
        }
        // checking for target-candidates[index] so that elements > target are not considered
        while(candidate < 10 && target - candidate >=0 && step <= k){
            // add to possible combinations
            lists.add(candidate);

            //will fill in the list till sum=0 or sum < 0
            findCombinations(candidate+1, lists, finalList, target-candidate, step+1, k);

            // backtrack
            // start with the last element removed
            lists.remove(lists.size()-1);
            candidate++;
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> a = new CombinationSumIII().combinationSum3(3, 7);
        for( List l: a) {
            for (Object i: l) {
                System.out.print(i.toString() + " ");
            }
            System.out.println();
        }
    }
}

