# 67. Add Binary

## Difficulty
Easy

## Pattern
String / Math / Simulation

## Topics
- Math
- String
- Bit Manipulation
- Simulation

## Problem
Given two binary strings `a` and `b`, return their sum as a binary string.

## Possible Approaches
The problem can be solved using several approaches:

**1) Convert to Integer, Add, Convert Back**
Convert both binary strings to decimal integers, add them, then convert the sum back to a binary string.
- Time: O(n + m)
- Space: O(n + m)
- Limitation: Can overflow for very large binary strings.

**2) Built-in BigInteger (Java) / Big Integer Handling**
Use language-provided big integer utilities to avoid overflow issues.
- Time: Depends on the underlying implementation
- Space: Depends on the implementation

**3) Simulated Binary Addition — Optimal**
Add the two strings digit by digit from right to left, just like manual binary addition, while tracking the carry.
- Time: O(max(n, m))
- Space: O(max(n, m))

This solution uses the Simulated Binary Addition approach because it works for strings of any length without overflow.

## Algorithm
1. Initialize two pointers `i` and `j` at the last index of `a` and `b` respectively.
2. Initialize `carry = 0` and an empty result (built using a `StringBuilder` or list, then reversed at the end).
3. Loop while `i >= 0` or `j >= 0` or `carry > 0`:
   - Take the digit from `a[i]` if `i >= 0`, otherwise treat it as `0`.
   - Take the digit from `b[j]` if `j >= 0`, otherwise treat it as `0`.
   - Compute `sum = digitA + digitB + carry`.
   - Append `sum % 2` to the result.
   - Update `carry = sum / 2`.
   - Decrement `i` and `j`.
4. Reverse the result to get the correct order.
5. Return the result as a binary string.