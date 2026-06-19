package algorithms.graph;

import java.util.*;

/**
 * Depth-First Search (DFS) — Recursive & Iterative
 * Time Complexity:  O(V + E)
 * Space Complexity: O(V)
 */
public class DFS {

    private int vertices;
    private LinkedList<Integer>[] adjList;

    @SuppressWarnings("unchecked")
    public DFS(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adjList[i] = new LinkedList<>();
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    public List<Integer> dfsRecursive(int start) {
        boolean[] visited = new boolean[vertices];
        List<Integer> result = new ArrayList<>();
        dfsHelper(start, visited, result);
        return result;
    }

    private void dfsHelper(int node, boolean[] visited, List<Integer> result) {
        visited[node] = true;
        result.add(node);
        for (int neighbor : adjList[node])
            if (!visited[neighbor])
                dfsHelper(neighbor, visited, result);
    }

    public List<Integer> dfsIterative(int start) {
        boolean[] visited = new boolean[vertices];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                result.add(node);
                for (int neighbor : adjList[node])
                    if (!visited[neighbor]) stack.push(neighbor);
            }
        }
        return result;
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++)
            if (!visited[i] && cycleDetect(i, visited, -1)) return true;
        return false;
    }

    private boolean cycleDetect(int node, boolean[] visited, int parent) {
        visited[node] = true;
        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                if (cycleDetect(neighbor, visited, node)) return true;
            } else if (neighbor != parent) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DFS graph = new DFS(6);
        graph.addEdge(0, 1); graph.addEdge(0, 2);
        graph.addEdge(1, 3); graph.addEdge(2, 4); graph.addEdge(3, 5);
        System.out.println("DFS Recursive: " + graph.dfsRecursive(0));
        System.out.println("DFS Iterative: " + graph.dfsIterative(0));
        System.out.println("Has Cycle: "     + graph.hasCycle());
    }
}
