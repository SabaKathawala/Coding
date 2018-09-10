package adobe;

/*
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
 */
/*
Check other solutions only if you have time
 */
public class ClimbingStairs {

    /*
    As we can see this problem can be broken into subproblems, and it contains the optimal substructure property i.e.
    its optimal solution can be constructed efficiently from optimal solutions of its subproblems,
    we can use dynamic programming to solve this problem.

    One can reach i^th step in one of the two ways:
    1. Taking a single step from (i-1)th step.
    2. Taking a step of 22 from (i-2)th step.

    So, the total number of ways to reach ith is equal to sum of ways of reaching (i-1)th​​ step and ways of reaching (i-2)th​​ step.
    Let dp[i] denotes the number of ways to reach on ith step.
        dp[i]=dp[i-1]+dp[i-2]
     */

    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        int[] countSteps = new int[n];

        countSteps[0] = 1;
        countSteps[1] = 2;

        for(int i = 2 ; i < n ; i++) {
            countSteps[i] = countSteps[i-1] + countSteps[i-2];
        }
        return countSteps[n-1];
    }
}
