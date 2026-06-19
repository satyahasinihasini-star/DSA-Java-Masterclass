# 🧠 ADS — Algorithms & Data Structures in Java

A clean, well-commented Java implementation of classic **Algorithms and Data Structures** including Graph Search, Dynamic Programming, and Pathfinding algorithms.

---

## 📁 Project Structure

```
ADS-Java/
├── src/
│   ├── algorithms/
│   │   ├── graph/
│   │   │   ├── BFS.java              # Breadth-First Search
│   │   │   ├── DFS.java              # Depth-First Search (Recursive + Iterative)
│   │   │   └── AStarSearch.java      # A* Pathfinding (Manhattan heuristic)
│   │   └── dynamic/
│   │       ├── Fibonacci.java        # Fibonacci (Memo, Tab, Optimized)
│   │       ├── Knapsack.java         # 0/1 Knapsack Problem
│   │       └── LongestCommonSubsequence.java  # LCS
│   └── main/
│       └── Main.java                 # Demo runner
├── .gitignore
└── README.md
```

---

## 🚀 Algorithms Implemented

### 📌 Graph Algorithms

| Algorithm | Description | Time Complexity | Space Complexity |
|-----------|-------------|-----------------|------------------|
| **BFS** | Level-order traversal, shortest path in unweighted graphs | O(V + E) | O(V) |
| **DFS** | Recursive & Iterative traversal, cycle detection | O(V + E) | O(V) |
| **A\*** | Heuristic-based shortest path on a 2D grid | O(E log V) | O(V) |

### 📌 Dynamic Programming

| Algorithm | Description | Time Complexity | Space Complexity |
|-----------|-------------|-----------------|------------------|
| **Fibonacci** | Three approaches: Memoization, Tabulation, Space-Optimized | O(n) | O(1) to O(n) |
| **0/1 Knapsack** | Maximize value within weight capacity | O(n × W) | O(n × W) |
| **LCS** | Longest Common Subsequence of two strings | O(m × n) | O(m × n) |

---

## ⚙️ How to Run

### Prerequisites
- Java 8 or higher
- No external libraries needed

### Compile & Run (Terminal)

```bash
# Navigate to src folder
cd ADS-Java/src

# Compile all files
javac algorithms/graph/*.java algorithms/dynamic/*.java main/Main.java

# Run the main demo
java main.Main
```

### Run individual algorithms

```bash
# BFS only
java algorithms.graph.BFS

# DFS only
java algorithms.graph.DFS

# A* Search
java algorithms.graph.AStarSearch

# Knapsack
java algorithms.dynamic.Knapsack

# LCS
java algorithms.dynamic.LongestCommonSubsequence

# Fibonacci
java algorithms.dynamic.Fibonacci
```

---

## 💡 Sample Output

```
==========================================
   ADS — Algorithms & Data Structures     
==========================================

[ BFS - Breadth-First Search ]
  Traversal from 0 : [0, 1, 2, 3, 4, 5]
  0 connected to 5 : true

[ DFS - Depth-First Search ]
  Recursive : [0, 1, 3, 5, 2, 4]
  Iterative : [0, 2, 4, 1, 3, 5]
  Has Cycle : false

[ A* Search - Grid Pathfinding ]
  Path found: true (9 steps)

[ 0/1 Knapsack - Dynamic Programming ]
  Max value (capacity=8): 9

[ LCS - Longest Common Subsequence ]
  LCS of ABCBDAB & BDCAB: BCAB

[ Fibonacci - DP ]
  Fib(10) = 55

==========================================
              All Done!                   
==========================================
```

---

## 🧩 Algorithm Details

### BFS (Breadth-First Search)
- Explores nodes **level by level** using a Queue
- Used for: **shortest path** in unweighted graphs, connectivity check
- Key feature: `isConnected(src, dest)` to check reachability

### DFS (Depth-First Search)
- Explores as **deep as possible** before backtracking
- Both **recursive** (cleaner) and **iterative** (stack-based) versions
- Includes **cycle detection**

### A* Search
- Finds the **optimal path** on a 2D grid with obstacles
- Uses **Manhattan Distance** heuristic: `|x1-x2| + |y1-y2|`
- Grid: `0` = walkable, `1` = obstacle

### 0/1 Knapsack
- Classic DP problem: select items to **maximize value** within weight limit
- Includes **backtracking** to find which items were selected

### Longest Common Subsequence
- Finds the **longest subsequence** common to two strings
- Returns both the **length** and the **actual LCS string**

### Fibonacci
- **Memoization** (Top-Down): caches subproblems recursively
- **Tabulation** (Bottom-Up): fills table iteratively
- **Space Optimized**: uses only two variables — O(1) space

---

## 🛠️ IDE Setup

### IntelliJ IDEA
1. Open IntelliJ → `File > Open` → select `ADS-Java` folder
2. Mark `src` as Sources Root: right-click `src` → `Mark Directory as > Sources Root`
3. Run `Main.java`

### VS Code
1. Install **Extension Pack for Java**
2. Open `ADS-Java` folder
3. Run `Main.java` with the Run button

### Eclipse
1. `File > New > Java Project` → uncheck default location → point to `ADS-Java`
2. Run `Main.java`

---

## 📚 Topics Covered

- [x] Graph Traversal (BFS, DFS)
- [x] Heuristic Search (A*)
- [x] Dynamic Programming (Knapsack, LCS, Fibonacci)
- [ ] Sorting Algorithms *(coming soon)*
- [ ] Binary Search & Variants *(coming soon)*
- [ ] Dijkstra's Algorithm *(coming soon)*
- [ ] Bellman-Ford *(coming soon)*
- [ ] Tree Algorithms *(coming soon)*

---

## 🤝 Contributing

1. Fork the repo
2. Create a branch: `git checkout -b feature/algorithm-name`
3. Add your algorithm with comments and a `main()` demo
4. Submit a Pull Request

---

## 📄 License

MIT License — free to use, modify, and distribute.

---

> Made with ☕ and Java | Happy Coding!
