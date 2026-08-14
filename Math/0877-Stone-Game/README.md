# 877. Stone Game

## Difficulty
Medium

## Pattern
Dynamic Programming / Game Theory

## Topics
- Array
- Math
- Dynamic Programming
- Game Theory

## Problem
Alice and Bob play a game with piles of stones. There are an even number of piles arranged in a row, and each pile has a positive integer number of stones, given as an array `piles`.

The objective of the game is to end with the most stones. The total number of stones across all the piles is odd, so there are no ties.

Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile of stones either from the beginning or from the end of the row. This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alice and Bob play optimally, return `true` if Alice wins the game, or `false` if Bob wins.

## Possible Approaches
The problem can be solved using several approaches:

**1) Brute Force / Recursion**
At every turn, try taking either the first or the last pile, and recursively simulate both players playing optimally.
- Time: O(2ⁿ)
- Space: O(n) (recursion stack)

**2) Dynamic Programming (Top-Down / Bottom-Up) — Optimal**
Use a DP table where `dp[i][j]` represents the maximum score difference the current player can achieve over the opponent, considering the subarray from index `i` to `j`.
- Time: O(n²)
- Space: O(n²)

**3) Mathematical Insight**
Since the number of piles is always even and the total stones are odd, Alice can always win by always picking either all even-indexed or all odd-indexed piles.
- Time: O(1)
- Space: O(1)

This solution uses the Dynamic Programming approach because it generalizes to the underlying game-theory logic clearly.

## Algorithm
1. Let `n` be the length of `piles`.
2. Create a 2D DP table `dp[n][n]`.
3. Initialize the base case: `dp[i][i] = piles[i]` for every `i`.
4. Iterate over increasing subarray lengths, from `2` to `n`.
5. For each subarray `[i, j]`, calculate:
   ```text
   dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])
   ```
6. After filling the table, check the value of `dp[0][n-1]`.
7. Return `true` if `dp[0][n-1] > 0`, otherwise return `false`.