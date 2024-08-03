### Solution
- There are three states to consider
  - We are holding onto a stock
  - We have no stock and are not on cool-down
  - We have no stock and are on cool-down 

- We can formulate a recurrence of the sub-problem form `opt(i,k)` where i is the ith day, and 
  k is the state we are in
- We can then formulate the recurrence: 
```
    For 1 <= i < n:
        opt(i, 0) = max(opt(i - 1, 0), opt(i - 1, 1) - p(i))
        opt(i, 1) = max(opt(i - 1, 1), opt(i - 1, 2))
        opt(i, 2) = opt(i - 1, 0) + p(i)
        
    Base cases:
        opt(0, 0) = -price(0)
        opt(0, 1) = 0
        opt(0, 2) = 0
```
The recurrence covers the following state transitions:
- If we are holding onto a stock
  - We are waiting to sell up to the i - 1th day, or we did not have a stock up to the i - 1th day and
    bought on day i.
- If we are not holding onto a stock and aren't on cool-down
  - We are either resting or come out of cool - down from the i - 1th day
- If we are not holding onto a stock and are on cool-down
  - Then we have sold stock that we are holding onto on the i - 1th day. 

### Time Complexity
- Each sub-problem is solved in constant time and there are 3n sub-problems, which is solved in `O(n)` time
    with `O(n)` memory to initialise the DP table.