package algorithms.graph;

import java.util.*;

/**
 * A* Search Algorithm — Grid-based pathfinding
 * Uses Manhattan Distance as heuristic
 * Time Complexity:  O(E log V)
 * Space Complexity: O(V)
 *
 * Grid: 0 = walkable, 1 = obstacle
 */
public class AStarSearch {

    static class Node implements Comparable<Node> {
        int x, y;
        double g, h, f;
        Node parent;

        Node(int x, int y) { this.x = x; this.y = y; }

        @Override public int compareTo(Node o) { return Double.compare(this.f, o.f); }
        @Override public boolean equals(Object o) {
            if (!(o instanceof Node)) return false;
            Node n = (Node) o; return x == n.x && y == n.y;
        }
        @Override public int hashCode() { return Objects.hash(x, y); }
    }

    private int[][] grid;
    private int rows, cols;
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    public AStarSearch(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
    }

    private double heuristic(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2); // Manhattan
    }

    public List<int[]> findPath(int startX, int startY, int endX, int endY) {
        PriorityQueue<Node> open = new PriorityQueue<>();
        Set<Node> closed = new HashSet<>();

        Node start = new Node(startX, startY);
        start.g = 0;
        start.h = heuristic(startX, startY, endX, endY);
        start.f = start.g + start.h;
        open.add(start);

        while (!open.isEmpty()) {
            Node current = open.poll();
            if (current.x == endX && current.y == endY)
                return reconstructPath(current);

            closed.add(current);

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= rows || ny >= cols || grid[nx][ny] == 1)
                    continue;

                Node neighbor = new Node(nx, ny);
                if (closed.contains(neighbor)) continue;

                neighbor.g = current.g + 1;
                neighbor.h = heuristic(nx, ny, endX, endY);
                neighbor.f = neighbor.g + neighbor.h;
                neighbor.parent = current;
                open.add(neighbor);
            }
        }
        return Collections.emptyList();
    }

    private List<int[]> reconstructPath(Node node) {
        List<int[]> path = new ArrayList<>();
        while (node != null) { path.add(new int[]{node.x, node.y}); node = node.parent; }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0}
        };
        AStarSearch astar = new AStarSearch(grid);
        List<int[]> path = astar.findPath(0, 0, 4, 4);
        if (path.isEmpty()) System.out.println("No path found!");
        else {
            System.out.println("A* Path (" + path.size() + " steps):");
            for (int[] p : path) System.out.println("  -> (" + p[0] + ", " + p[1] + ")");
        }
    }
}
