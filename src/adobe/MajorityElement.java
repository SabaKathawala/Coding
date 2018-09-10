package adobe;

/*
Lots of solutions. Read if you get time.
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        return findMajorityElement(0, nums.length-1, nums);
    }

    private int findMajorityElement(int i, int j, int[] nums) {
        if(i == j) {
            return nums[i];
        }
        //important for recursion to end
        int mid = (j-i)/2 + i;
        int leftMajority = findMajorityElement(i, mid, nums);
        int rightMajority = findMajorityElement(mid+1, j, nums);

        if( leftMajority == rightMajority ) {
            return leftMajority;
        }

        else {
            int left = countMajority(leftMajority, i, j, nums);
            int right = countMajority(rightMajority, i, j, nums) ;
            if(left > right) {
                return leftMajority;
            }
            return rightMajority;
        }
    }

    private int countMajority(int majority, int start, int end, int[] nums) {
        int count = 0;
        for(int i = start; i <= end ; i++) {
            if(nums[i] == majority) {
                count++;
            }
        }
        return count;
    }
}
