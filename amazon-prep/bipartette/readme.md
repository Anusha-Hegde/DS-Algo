Given an undirected graph, return true if and only if it is bipartite.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  
Each node is an integer between 0 and graph.length - 1.  
There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:

Input: 
[
    [1, 3], 
    [0, 2], 
    [1, 3], 
    [0, 2]  ]

Output: true

Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.