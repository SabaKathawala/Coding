package leetcode.two_sum;

import java.util.Arrays;

public class SortedArray {
    //two pointers
    //binary search

    //O(logn)
    public int[] twoSumBetter(int[] numbers, int target) {
        boolean isBegin = true;
        int [] result = new int [2];
        int temp, before = 0, end = numbers.length, index;
        while(before<end){
            if(isBegin){
                //find complement
                temp = target - numbers[before];
                //search using binary search as sorted
                index = Arrays.binarySearch(numbers, before, end, temp);
                if(index > 0){
                    result[0] = before + 1;
                    result[1] = index + 1;
                    return result;
                }else{
                    end = -index - 1 - 1;
                    isBegin = false;
                }
            }else{
                temp = target - numbers[end];
                index = Arrays.binarySearch(numbers, before, end, temp);
                if(index > 0){
                    result[0] = index + 1;
                    result[1] = end + 1;
                    return result;
                }else{
                    before = -index - 1;
                    isBegin = true;
                }
            }
        }
        return result;

    }

    // adding the left and right elements: cool
    //O(n)
    public int[] twoSum(int[] numbers, int target) {
        int x= 0,y=numbers.length-1;
        while(x<y) {
            if(numbers[x]+numbers[y]==target)return new int[]{x+1,y+1};
            if(numbers[x]+numbers[y]>target)
                y--;
            else
                x++;
        }
        return numbers[x]+numbers[y]==target?new int[]{x+1,y+1}:new int[]{-1,-1};
    }
}
