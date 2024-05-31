# Solution
- Note that for each transformation, there is a one letter difference
- Construct a graph adj list using a pattern as a key (mask each letter), where we then store words with that common pattern
- Then perform a level order traversal BFS on the graph, for each layer, we increment the step (increment at start)

# Time Complexity
- O(n * m^2), n nodes, with a pattern length of m^2