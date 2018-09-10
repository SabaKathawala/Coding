package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[]{};
        }
        Deque<Integer> maxInWindow = new LinkedList<>();
        int i=0;
        for(;i<k;i++) {
            while(!maxInWindow.isEmpty() && nums[i] >= nums[maxInWindow.peekLast()]) {
                maxInWindow.removeLast();
            }
            maxInWindow.add(i);
        }

        int[] max = new int[nums.length-k+1];
        int start = 0;
        while(i<nums.length) {
            max[start] = nums[maxInWindow.peek()];
            while(!maxInWindow.isEmpty() && nums[i] >= nums[maxInWindow.peekLast()]) {
                maxInWindow.removeLast();
            }
            maxInWindow.add(i);
            if(!maxInWindow.isEmpty() && start == maxInWindow.peek()) {
                maxInWindow.remove();
            }
            start++;
            i++;
        }

        max[start] = nums[maxInWindow.peek()];
        return max;

    }

    public static void main(String[] args) {
        new SlidingWindowMaximum239().maxSlidingWindow(new int[]{4,3,11}, 3);
    }
}
