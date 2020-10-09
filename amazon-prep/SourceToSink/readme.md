Given a directed acyclic graph of N nodes. 
Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  
    the nodes are 0, 1, ..., graph.length - 1.  
    graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:

    2---->3
    ^     ^
    |     |
    |     |
    1<----0

Output: [[0, 1, 2, 3], [0, 3]]