package algorithms.dynamic;

/**
 * Fibonacci — Three DP approaches compared
 * Memoization (Top-Down) | Tabulation (Bottom-Up) | Space Optimized
 */
public class Fibonacci {

    private long[] memo;

    /** Top-Down: Memoization — O(n) time, O(n) space */
    public long fibMemo(int n) {
        memo = new long[n + 2];
        return helper(n);
    }

    private long helper(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(n - 1) + helper(n - 2);
        return memo[n];
    }

    /** Bottom-Up: Tabulation — O(n) time, O(n) space */
    public long fibTab(int n) {
        if (n <= 1) return n;
        long[] dp = new long[n + 1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }

    /** Space Optimized — O(n) time, O(1) space */
    public long fibOptimized(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) { long c = a + b; a = b; b = c; }
        return b;
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        int n = 10;
        System.out.println("Fib(" + n + ") Memoization : " + fib.fibMemo(n));
        System.out.println("Fib(" + n + ") Tabulation  : " + fib.fibTab(n));
        System.out.println("Fib(" + n + ") Optimized   : " + fib.fibOptimized(n));
    }
}
