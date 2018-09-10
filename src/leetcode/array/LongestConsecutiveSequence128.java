package leetcode.array;

import java.util.Iterator;
import java.util.TreeSet;

public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        int longestSequence = 0;

        // boolean[] negatives = new boolean[Integer.MAX_VALUE-5];
        // boolean[] positives = new boolean[Integer.MAX_VALUE-5];
        TreeSet<Integer> numbers = new TreeSet<>();
        for(int i = 0; i < nums.length; i++ ) {
            if(!numbers.contains(nums[i])) {
                numbers.add(nums[i]);
            }
        }
        Iterator<Integer> iterator = numbers.iterator();
        Integer previous = iterator.next();
        int sequence = 1;
        while(iterator.hasNext()) {
            Integer current = iterator.next();
            if(current == previous+1) {
                sequence++;
            } else {
                if(sequence > longestSequence) {
                    longestSequence = sequence;
                    sequence = 0;
                }
            }
            previous = current;
        }
        return longestSequence;
    }

    public static void main(String[] args) {
        new LongestConsecutiveSequence128().longestConsecutive(new int[]{9,1,-3,2,4,8,3,-1,6,-2,-4,7});
    }
}