package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BeautifulArrangement52  {
    static int arr;
    public int countArrangement(int N) {
        arr = 0;
        List<List<Integer>> multiples = new ArrayList<>();
        int n = 1;
        while(n <= N) {
            multiples.add(findMultiples(n, N));
            n++;

        }
        findArrangements(multiples, new HashSet<>(), N, 0);
        return arr;
    }

    private static List<Integer> findMultiples(int n, int N) {
        List<Integer> multiples = new ArrayList<Integer>();
        int multiple = 1;
        while(n*multiple <= N) {
            multiples.add(n*multiple++);
        }
        multiple = n/2;
        while(multiple >= 1) {
            if(n%multiple == 0)
                multiples.add(multiple);
            multiple--;
        }
        System.out.println(multiples.size());
        return multiples;
    }

    private static void findArrangements(List<List<Integer>> multiples, Set<Integer> set, int N, int index) {
        if(index == N) {
            if(set.size() == N) {
                arr++;
            }
            return;
        }
        int arr = 0;
        List<Integer> list = multiples.get(index);
        for(Integer i: list) {
            if(!set.contains(i)) {
                set.add(i);
                findArrangements(multiples, set, N, index+1);
                set.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        new BeautifulArrangement52().countArrangement(5);
    }
}