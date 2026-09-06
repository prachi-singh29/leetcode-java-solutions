# 69. Sqrt(x)

## Difficulty
Easy

## Pattern
Binary Search on Answer

## Topics
- Math
- Binary Search

## Problem
Given a non-negative integer `x`, return the square root of `x` rounded
**down** to the nearest integer. The returned integer should be
non-negative as well.

You must not use any built-in exponent function or operator (e.g.
`pow(x, 0.5)` or `x ** 0.5`).

## Example 1
Input:
```
x = 4
```
Output:
```
2
```

## Example 2
Input:
```
x = 8
```
Output:
```
2
```

Explanation:
```text
sqrt(8) = 2.82842..., and since the decimal part is truncated,
2 is returned.
```

## Possible Approaches
The problem can be solved using several approaches:

**1) Brute Force / Linear Scan**
Try every integer `i` starting from `0` upward until `i * i > x`, then
return `i - 1`.
- Time: O(√x)
- Space: O(1)

**2) Binary Search on the Answer — Optimal**
The candidate answers `0, 1, 2, ..., x` are sorted, and `i * i <= x` is a
monotonic predicate (true for small `i`, false for large `i`). That
monotonicity is exactly what binary search needs: search the range
`[0, x]` for the largest `mid` whose square doesn't exceed `x`.
- Time: O(log x)
- Space: O(1)

**3) Newton's Method**
Start with a guess and repeatedly refine it using
`r = (r + x / r) / 2` until it stabilizes. Converges quadratically, so
it's typically faster in practice than binary search, though slightly
less intuitive to prove correct.
- Time: O(log x) (fewer iterations in practice than binary search)
- Space: O(1)

This solution uses the **Binary Search on the Answer** approach.

## Algorithm
1. If `x == 0`, return `0` immediately.
2. Initialize `left = 0`, `right = x`, and `result = 0`.
3. While `left <= right`:
   - Compute `mid = (left + right) / 2`.
   - Compute `sqrd = (long) mid * mid`, cast to `long` to avoid integer
     overflow when `mid` is large.
   - If `sqrd == x`, `x` is a perfect square — return `mid` directly.
   - If `sqrd < x`, `mid` is a valid answer so far — record it in
     `result` and search the upper half (`left = mid + 1`).
   - If `sqrd > x`, `mid` overshoots — search the lower half
     (`right = mid - 1`).
4. After the loop ends, `result` holds the largest `mid` whose square
   did not exceed `x` — the floor of the square root.
5. Return `result`.


