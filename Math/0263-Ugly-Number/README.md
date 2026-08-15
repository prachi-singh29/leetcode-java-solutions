# 263. Ugly Number

## Difficulty
Easy

## Pattern
Math

## Topics
- Math

## Problem
An ugly number is a positive integer whose prime factors are limited to `2`, `3`, and `5`.

Given an integer `n`, return `true` if `n` is an ugly number.

## Example 1
Input:
n = 6

Output:
true

Explanation:
6 = 2 × 3

## Example 2
Input:
n = 1

Output:
true

Explanation:
`1` has no prime factors, so it is considered an ugly number by convention.

## Example 3
Input:
n = 14

Output:
false

Explanation:
14 = 2 × 7
`7` is a prime factor other than `2`, `3`, or `5`, so `14` is not ugly.

## Possible Approaches
The problem can be solved using several approaches:

**1) Prime Factorization (Full)**
Find all prime factors of `n` and check whether they are only `2`, `3`, or `5`.
- Time: O(√n)
- Space: O(1)

**2) Repeated Division — Optimal**
Repeatedly divide `n` by `2`, `3`, and `5` as long as it is divisible. If the final value is `1`, the number is ugly.
- Time: O(log n)
- Space: O(1)

This solution uses the Repeated Division approach.

## Algorithm
1. If `n <= 0`, return `false` (ugly numbers must be positive).
2. While `n` is divisible by `2`, divide `n` by `2`.
3. While `n` is divisible by `3`, divide `n` by `3`.
4. While `n` is divisible by `5`, divide `n` by `5`.
5. After all divisions, check if `n == 1`.
6. Return `true` if `n == 1`, otherwise return `false`.