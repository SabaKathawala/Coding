package adobe;

import java.util.*;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Set<Integer> s = new TreeSet<>();
        for(Integer i: A) {
            s.add(i);
        }
        A.clear();
        for(Integer i: s) {
            A.add(i);
        }


        //recurse
        ArrayList<Integer> internal = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

        findNumbers(A, B, answer, internal, 0);
        return answer;
    }
    private void findNumbers(ArrayList<Integer> A, int sum, ArrayList<ArrayList<Integer>> answer, ArrayList<Integer> internal, int i) {
        if (sum < 0)
            return;

        // if we get exact answer
        if (sum == 0)
        {
            answer.add(new ArrayList<>(internal));
            return;
        }

        // Recur for all remaining elements that
        // have value smaller than sum.
        while (i < A.size() && sum - A.get(i) >= 0)
        {

            // Till every element in the Array stAting
            // from i which can contribute to the sum
            internal.add(A.get(i)); // add them to list

            // recur for next numbers
            findNumbers(A, sum - A.get(i), answer, internal, i);
            i++;

            // remove number from list (backtracking)
            internal.remove(internal.size()-1);
        }
    }


    public List<List<Integer>> combinationSum(int[] cand, int B) {
        //sort

        Set<Integer> s = new TreeSet<>();
        for(int i: cand) {
            s.add(i);
        }
        int[] array = new int[s.size()];
        int k = 0;
        for(Integer i: s) {
            array[k++] = i.intValue();
        }

        //recurse
        ArrayList<Integer> internal = new ArrayList<Integer>();
        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        findNumbers(array, B, answer, internal, 0);
        return answer;
    }
    private void findNumbers(int[] A, int sum, List<List<Integer>> answer, ArrayList<Integer> internal, int i) {
        if (sum < 0)
            return;

        // if we get exact answer
        if (sum == 0)
        {
            answer.add(new ArrayList<>(internal));
            return;
        }

        // Recur for all remaining elements that
        // have value smaller than sum.
        while (i < A.length && sum - A[i] >= 0)
        {

            // Till every element in the Array stAting
            // from i which can contribute to the sum
            internal.add(A[i]); // add them to list

            // recur for next numbers
            findNumbers(A, sum - A[i], answer, internal, i);
            i++;

            // remove number from list (backtracking)
            internal.remove(internal.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> a = new CombinationSum().combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 69);
        for( List l: a) {
            for (Object i: l) {
                System.out.print(i.toString() + " ");
            }
            System.out.println();
        }
    }
}
