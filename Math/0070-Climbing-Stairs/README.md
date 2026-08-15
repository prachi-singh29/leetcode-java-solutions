# 70. Climbing Stairs

## Difficulty
Easy

## Pattern
Dynamic Programming / Fibonacci

## Topics
- Math
- Dynamic Programming
- Memoization

## Problem
You are climbing a staircase. It takes `n` steps to reach the top.
Each time you can either climb `1` or `2` steps. In how many distinct ways can you climb to the top?

## Example 1
Input:
```
n = 2
```
Output:
```
2
```

Explanation:
There are two ways to climb to the top:
```text
1. 1 step + 1 step
2. 2 steps
```

## Example 2
Input:
```
n = 3
```
Output:
```
3
```

Explanation:
There are three ways to climb to the top:
```text
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

## Possible Approaches
The problem can be solved using several approaches:

**1) Brute Force / Recursion**
At each step, recursively try taking either 1 step or 2 steps, and sum the number of ways from both choices.
- Time: O(2ⁿ)
- Space: O(n) (recursion stack)

**2) Recursion with Memoization (Top-Down DP)**
Store the result for each step number so it isn't recomputed.
- Time: O(n)
- Space: O(n)

**3) Dynamic Programming (Bottom-Up) — Optimal**
Build up the answer iteratively from the base cases.
- Time: O(n)
- Space: O(n), reducible to O(1)

**4) Fibonacci Formula**
Since the recurrence matches the Fibonacci sequence, the answer can also be derived using Binet's formula or matrix exponentiation.
- Time: O(log n) using matrix exponentiation
- Space: O(1)

This solution uses the Bottom-Up Dynamic Programming approach.

## Algorithm
1. If `n == 1`, return `1`. If `n == 2`, return `2`.
2. Initialize `first = 1` (ways to reach step 1) and `second = 2` (ways to reach step 2).
3. Loop from `i = 3` to `n`:
   - Compute `current = first + second`.
   - Update `first = second`.
   - Update `second = current`.
4. After the loop, `second` holds the number of ways to reach step `n`.
5. Return `second`.