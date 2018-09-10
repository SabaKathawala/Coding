package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum39 {
    public static List<List<Integer>> answer = null;
    public static List<Integer> temp = null;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        answer = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            while(candidates[i] == candidates[i+1]) {
                i++;
            }
            i--;
            temp = new ArrayList<>();
            answer.add(getList(i, candidates, target-candidates[i]));
        }

        return answer;
    }

    private static List<Integer> getList(int index, int[] candidates, int target) {
        if(target == 0) {
            temp.add(candidates[index]);
            return temp;
        }
        if(target < 0) {
            temp.remove(temp.size()-1);
            getList(index+1, candidates, target+candidates[index]);
        }
        else {
            temp.add(candidates[index]);
            getList(index, candidates, target-candidates[index]);
        }
        return null;

    }

    public static void main (String[] args) {

    }
}
