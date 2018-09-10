package adobe;

import java.util.ArrayList;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]

 */
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<Integer> lists = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();

        findSets(A, 0, B, 1, finalList, lists);
        return finalList;
    }

    public static void findSets(int n, int step, int k, int start,
                                ArrayList<ArrayList<Integer>> finalList, ArrayList<Integer> lists) {
        if(step == k) {
            finalList.add(new ArrayList<>(lists));
            return;
        }
        if(start > n) {
            return;
        }

        while( start <= n) {
            lists.add(start);
            findSets(n, step+1, k, start+1, finalList, lists);
            start++;
            lists.remove(lists.size()-1);
        }

    }
}
