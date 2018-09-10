package leetcode;

public class FirstAndLast34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = start + (end-start)/2;;

        int rangeStart = -1;
        int rangeEnd = -1;
        boolean found = true;

        while(start <= end) {
            if(nums[mid] == target) {
                found = true;
                break;
            }
            else if(nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
            mid = start + (end-start)/2;

        }
        if(found) {
            int index = mid;
            do {
                rangeStart = index;
                index = search(nums, start, index-1, target);

            } while(index != -1);
            index = mid;
            do {
                rangeEnd = index;
                index = search(nums, index+1, end, target);

            } while(index != -1);
        }

        return new int[]{rangeStart, rangeEnd};
    }

    private static int search(int[] nums, int start, int end, int target) {
        int mid;

        while(start <= end) {
            mid = start + (end-start)/2;
            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int trueStart = 0;
        int start = 0;
        int end = nums.length-1;

        int mid = start + (end-start)/2 ;

        while(start <= end) {
            if(nums[mid] == target) {

                return mid;
            }
            else if(nums[mid] > target) {
                if(nums[start] > target) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }

            } else {
                if(nums[start] < target) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
            mid = start + (end-start)/2 ;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstAndLast34().search(new int[]{1,2,3,0}, 0));
    }
}
