package leetcode;

import java.util.Arrays;

public class CoinChange322 {
    static int minCoins = 1;
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        fewestCoins(coins, coins.length-1, amount-coins[coins.length-1]);
        return minCoins;
    }

    private static void fewestCoins(int[] coins, int den, int amount) {
        if(den < 0 || amount == 0) {
            return;
        }

        if(amount < 0) {
            minCoins--;
            amount += coins[den];
            fewestCoins(coins, den-1, amount);
        }
        minCoins++;
        amount -= coins[den];
        fewestCoins(coins, den, amount);
    }

    public static void main(String[] args) {
        coinChange(new int[]{2,5}, 11);
    }
}
