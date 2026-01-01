public class BestTimeBuySellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        // Brute force approach
        /**
         * Check every possible pair (buy day, sell day).
         * For each i, check j > i and compute profit = prices[j] - prices[i].
         * Keep track of the maximum profit.
         * Time Complexity: O(n^2), Space Complexity: O(1).
         * Not efficient for large inputs.
         */
        System.out.println("Brute Force: " + maxProfitBruteForce(prices));

        // Optimal approach
        /**
         * Use a single pass:
         * - Track the minimum price seen so far.
         * - At each day, calculate potential profit = current price - min price.
         * - Update max profit if this profit is larger.
         * Time Complexity: O(n), Space Complexity: O(1).
         * This is the most efficient solution and the one expected in interviews.
         */
        System.out.println("Optimal: " + maxProfitOptimal(prices));
    }

    // Brute force solution
    public static int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    // Optimal solution
    public static int maxProfitOptimal(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // update minimum price so far
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // update max profit
            }
        }
        return maxProfit;
    }
}