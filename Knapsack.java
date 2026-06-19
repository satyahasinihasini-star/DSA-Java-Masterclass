package algorithms.dynamic;

/**
 * 0/1 Knapsack Problem — Dynamic Programming
 * Time Complexity:  O(n * W)
 * Space Complexity: O(n * W)
 */
public class Knapsack {

    public int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                dp[i][w] = dp[i - 1][w];
                if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[n][capacity];
    }

    public int[] selectedItems(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++)
            for (int w = 0; w <= capacity; w++) {
                dp[i][w] = dp[i - 1][w];
                if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
            }

        int[] selected = new int[n];
        int w = capacity;
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) { selected[i - 1] = 1; w -= weights[i - 1]; }
        }
        return selected;
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values  = {3, 4, 5, 6};
        int capacity  = 8;

        Knapsack ks = new Knapsack();
        System.out.println("Max Value: " + ks.knapsack(weights, values, capacity));
        int[] items = ks.selectedItems(weights, values, capacity);
        System.out.print("Items selected (index): ");
        for (int i = 0; i < items.length; i++)
            if (items[i] == 1) System.out.print(i + " ");
        System.out.println();
    }
}
