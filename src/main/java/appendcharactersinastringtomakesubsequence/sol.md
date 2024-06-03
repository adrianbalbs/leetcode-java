# Solution
- Greedy algo with two pointers
- if the characters match, increment the s and t pointers, if not only increment s
- If we reach the end of t before we reach the end of s, then t is already a subsequence of s, so return 0
- If we reach the end of s, then return n - j, where n is the length of t, and j is the current index

# Time Complexity
- O(max(m, n)) since either m or n can finish depending on the size of each of the strings