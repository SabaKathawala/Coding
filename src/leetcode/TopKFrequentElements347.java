package leetcode;

/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TopKFrequentElements347 {

    // better than nlogn as no sorting operation performed
    // can be solved using maxheap as well
    public List<Integer> topKFrequentSimple(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0 || k == 0) {
            return res;
        }
        // find the max and minimum values in the array
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //O(n)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        // record frequency of all elements starting from
        // miniumumm to maximum elements
        // O(n)
        int[] buckets = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] - min]++;
        }

        // create buckets based on frequency of elements and
        // add numbers with same frequency in that bucket
        List[] counting = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            int sizeOfBucket = buckets[i];
            if (counting[sizeOfBucket] == null) {
                counting[sizeOfBucket] = new ArrayList<Integer>();
            }
            counting[sizeOfBucket].add(i + min);
        }

        // loop in reverse to get most frequent elements
        // O(n)
        for (int i = counting.length - 1; i >= 0; i--) {
            if (counting[i] != null) {
                for (Integer in:(ArrayList<Integer>)counting[i]) {
                    res.add(in);
                    if (res.size() == k) break;
                }
            }
            if (res.size() == k) break;
        }
        return res;
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }

        // sorting ho rahi yahan !!
        TreeMap<Integer, List<Integer>> topK = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2>o1?1:o2==o1?0:-1;
            }
        });
        Set<Map.Entry<Integer, Integer>> entry = freq.entrySet();

        for (Map.Entry<Integer, Integer> e : entry) {
            if (k != 0) {
                if (topK.containsKey(e.getValue())) {
                    List<Integer> l = topK.get(e.getValue());
                    l.add(e.getKey());
                    topK.put(e.getValue(), l);
                } else {
                    List<Integer> l = new ArrayList<>();
                    l.add(e.getKey());
                    topK.put(e.getValue(), l);
                }
            }
        }

        List<Integer> finalAns = new ArrayList<>();
        Collection<List<Integer>> aa = topK.values();
        topK.values();
        outer: for(List<Integer> l: aa) {
            for(Integer i: l) {
                finalAns.add(i);
                if(finalAns.size() == k) {
                    break outer;
                }
            }
        }
        return finalAns;
    }

    public static void main(String[] args) {
        System.out.println("6".compareTo("9"));
        final String date = "41/22/2017";
        final String dateFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            Date d = sdf.parse(date);
            sdf.setLenient(true);
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);

    }

}
