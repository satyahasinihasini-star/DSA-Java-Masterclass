package algorithms.graph;

import java.util.*;

/**
 * Breadth-First Search (BFS)
 * Time Complexity:  O(V + E)
 * Space Complexity: O(V)
 */
public class BFS {

    private int vertices;
    private LinkedList<Integer>[] adjList;

    @SuppressWarnings("unchecked")
    public BFS(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adjList[i] = new LinkedList<>();
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    public List<Integer> bfsTraversal(int start) {
        boolean[] visited = new boolean[vertices];
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return result;
    }

    public boolean isConnected(int src, int dest) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.add(src);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == dest) return true;
            for (int neighbor : adjList[node])
                if (!visited[neighbor]) { visited[neighbor] = true; queue.add(neighbor); }
        }
        return false;
    }

    public static void main(String[] args) {
        BFS graph = new BFS(6);
        graph.addEdge(0, 1); graph.addEdge(0, 2);
        graph.addEdge(1, 3); graph.addEdge(2, 4); graph.addEdge(3, 5);
        System.out.println("BFS Traversal from 0: " + graph.bfsTraversal(0));
        System.out.println("Is 0 connected to 5? " + graph.isConnected(0, 5));
    }
}
