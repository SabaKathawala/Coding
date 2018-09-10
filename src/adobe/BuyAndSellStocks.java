package adobe;

public class BuyAndSellStocks {

    public int maxProfit(int[] prices) {
        //thats how you skip null length == 0 step
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int start = 0, end = 0, temp =0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                temp = i;
            }
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
                end = i;
                start = temp;
            }
        }
        //start and end keep track of the indices of the two values
        System.out.println("start: " + start + " end: " + end);
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new BuyAndSellStocks().maxProfit(new int[]{7,2,7,1,4}));
    }
}
