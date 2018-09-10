package adobe;

import java.util.ArrayList;

/*
Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]

 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
        permute(A, 0, finalList);
        return finalList;
    }

    void permute(ArrayList<Integer> A, int start, ArrayList<ArrayList<Integer>> result) {

        if (start >= A.size()) {
            ArrayList<Integer> item = new ArrayList<Integer>(A);
            result.add(item);
        }

        for (int j = start; j <= A.size() - 1; j++) {
            swap(A, start, j);
            permute(A, start + 1, result);
            swap(A, start, j);
        }
    }
    private void swap(ArrayList<Integer> A, int i, int j) {
        Integer temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
