# 231. Power of Two

## Difficulty
Easy

## Pattern
Bit Manipulation / Math

## Topics
- Math
- Bit Manipulation
- Recursion

## Problem
Given an integer `n`, return `true` if it is a power of two. Otherwise, return `false`.

An integer `n` is a power of two if there exists an integer `x` such that:
```text
n == 2^x
```

## Example 1
Input:
```
n = 1
```
Output:
```
true
```

Explanation:
```
2^0 = 1
```

## Example 2
Input:
```
n = 16
```
Output:
```
true
```

Explanation:
```
2^4 = 16
```

## Example 3
Input:
```
n = 3
```
Output:
```
false
```

## Possible Approaches
The problem can be solved using several approaches:

**1) Repeated Division — Used in this solution**
Repeatedly divide `n` by `2` as long as it is even and greater than `1`. If we end up at exactly `1`, it is a power of two.
- Time: O(log n)
- Space: O(1)

**2) Counting Set Bits**
A power of two has exactly one set bit in its binary representation. Count the number of `1` bits and check if it equals `1`.
- Time: O(log n)
- Space: O(1)

**3) Bit Manipulation Trick**
Use the expression `n & (n - 1)` to clear the lowest set bit. If `n` is a power of two, this results in `0`.
- Time: O(1)
- Space: O(1)

This solution uses the Repeated Division approach because it directly mirrors the definition of a power of two — a number that can be halved evenly all the way down to `1`.

## Algorithm
1. If `n <= 0`, return `false`.
2. While `n` is even and greater than `1`:
   - Divide `n` by `2`.
3. After the loop, check if `n == 1`.
4. Return `true` if `n == 1`, otherwise return `false`.