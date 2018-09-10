package leetcode;

/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

Solution: http://www.cnblogs.com/grandyang/p/6208062.html
 */
public class TotalHammingDistance477 {

    public int totalHammingDistance(int[] nums) {
        int count = 0;
        int result = 0;
        int n = nums.length;
        for(int i=0; i<32; i++) {
            count = 0;
            for(int num:nums) {
                if((num & (1 << i)) == 0)
                    count++;
            }
            result += count * (n-count);
        }
        return result;
    }

}
