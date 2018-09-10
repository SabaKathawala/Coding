package leetcode;

public class MaxSlidingWindow239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 1) {
            return nums;
        }
        int[] maxSlidingWindow = new int[nums.length-k+1];
        int start = 0;
        int counter = 1;
        int end = k;
        int max, secondMax;
        if(nums[start] > nums[counter]) {
            max = nums[start];
            secondMax = nums[counter];
        } else {
            max = nums[counter];
            secondMax = nums[start];
        }
        counter++;
        while(counter < k) {
            if(nums[counter] > max) {
                secondMax = max;
                max = nums[counter];
            } else if(nums[counter] > secondMax) {
                secondMax = nums[counter];
            }
            counter++;
        }

        maxSlidingWindow[start] = max;

        while(end < nums.length) {
            if(max == nums[start]) {
                // update max
                max = Math.max(secondMax, nums[end]);
                secondMax = Math.min(secondMax, nums[end]);
            } else if(secondMax == nums[start]) {
                // update second max
                secondMax = nums[end];
            }
            if (max < Math.max(max, nums[end])){
                secondMax = max;
                max = Math.max(max,nums[end]);
            } else if(secondMax < Math.max(secondMax, nums[end])) {
                secondMax = Math.max(secondMax,nums[end]);
            }
            start++;
            end++;
            maxSlidingWindow[start] = max;
        }
//        start++;
//        if(max < Math.max(nums[start], nums[end])) {
//            secondMax = max;
//            max = Math.max(nums[start], nums[end]);
//        } else if(secondMax < Math.max(nums[start], nums[end])) {
//            secondMax = Math.max(nums[start], nums[end]);
//        }
        //maxSlidingWindow[start] = max;
        return maxSlidingWindow;
    }

    public int[] maxSlidingWindowIndex(int[] nums, int k) {
        if(nums.length <= 1) {
            return nums;
        }
        int[] maxSlidingWindow = new int[nums.length-k+1];
        int start = 0;
        int counter = 1;
        int end = k;
        int max, secondMax, maxIndex, secondMaxIndex;
        if(nums[start] > nums[counter]) {
            max = nums[start];
            maxIndex = start;
            secondMax = nums[counter];
            secondMaxIndex = counter;
        } else {
            max = nums[counter];
            maxIndex = counter;
            secondMax = nums[start];
            secondMaxIndex = start;
        }
        counter++;
        while(counter < k) {
            if(nums[counter] >= max) {
                secondMax = max;
                secondMaxIndex = maxIndex;
                max = nums[counter];
                maxIndex = counter;
            } else if(nums[counter] >= secondMax) {
                secondMax = nums[counter];
                secondMaxIndex = counter;
            }
            counter++;
        }

        maxSlidingWindow[start] = max;

        while(end < nums.length) {
            if(maxIndex == start) {
                // update max
                if(secondMax > nums[end]) {
                    max = secondMax;
                    maxIndex = secondMaxIndex;
                    secondMaxIndex = end;
                    secondMax = nums[end];
                }
                else {
                    max = nums[end];
                    maxIndex = end;
                }
            } else if(secondMaxIndex == start) {
                // update second max
                secondMax = nums[end];
                secondMaxIndex = end;
            }
            if (max <= nums[end]){
                secondMaxIndex = maxIndex;
                secondMax = max;
                max = nums[end];
                maxIndex = end;
            } else if(secondMax <= nums[end]) {
                secondMax = nums[end];
                secondMaxIndex = end;
            }
            start++;
            end++;
            maxSlidingWindow[start] = max;
        }
        return maxSlidingWindow;
    }

    public static void main(String[] args) {
        new MaxSlidingWindow239().maxSlidingWindowIndex(new int[]{9,10,9,-7,-4,-8,2,-6}, 5);
    }
}
