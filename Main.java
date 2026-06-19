package main;

import algorithms.graph.*;
import algorithms.dynamic.*;
import java.util.List;

/**
 * Main entry point — runs all algorithm demos
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   ADS - Algorithms & Data Structures   ");
        System.out.println("========================================\n");

        // --- BFS ---
        System.out.println("[ BFS - Breadth First Search ]");
        BFS bfsGraph = new BFS(6);
        bfsGraph.addEdge(0, 1); bfsGraph.addEdge(0, 2);
        bfsGraph.addEdge(1, 3); bfsGraph.addEdge(2, 4);
        bfsGraph.addEdge(3, 5);
        System.out.println("Traversal: " + bfsGraph.bfsTraversal(0));
        System.out.println();

        // --- DFS ---
        System.out.println("[ DFS - Depth First Search ]");
        DFS dfsGraph = new DFS(6);
        dfsGraph.addEdge(0, 1); dfsGraph.addEdge(0, 2);
        dfsGraph.addEdge(1, 3); dfsGraph.addEdge(2, 4);
        dfsGraph.addEdge(3, 5);
        System.out.println("Recursive: " + dfsGraph.dfsRecursive(0));
        System.out.println("Iterative: " + dfsGraph.dfsIterative(0));
        System.out.println();

        // --- A* ---
        System.out.println("[ A* Search ]");
        int[][] grid = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0}
        };
        AStarSearch astar = new AStarSearch(grid);
        List<int[]> path = astar.findPath(0, 0, 4, 4);
        System.out.println("Path steps: " + path.size());
        System.out.println();

        // --- Knapsack ---
        System.out.println("[ 0/1 Knapsack - DP ]");
        Knapsack ks = new Knapsack();
        System.out.println("Max Value: " + ks.knapsack(new int[]{2,3,4,5}, new int[]{3,4,5,6}, 8));
        System.out.println();

        // --- LCS ---
        System.out.println("[ LCS - Longest Common Subsequence ]");
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println("LCS: " + lcs.lcsString("ABCBDAB", "BDCAB"));
        System.out.println();

        // --- Fibonacci ---
        System.out.println("[ Fibonacci - DP ]");
        Fibonacci fib = new Fibonacci();
        System.out.println("Fib(10) = " + fib.fibOptimized(10));
        System.out.println();

        System.out.println("========================================");
        System.out.println("              All Done!                 ");
        System.out.println("========================================");
    }
}
