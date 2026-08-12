# 136. Single Number

## Difficulty
Easy

## Pattern
Array / Bit Manipulation

## Topics
- Array
- Bit Manipulation
- XOR
- Hash Table
- Sorting

## Problem
Given a non-empty array of integers `nums`, every element appears twice except for one element that appears exactly once.

Find and return the element that appears only once.

## Example
Input:
nums = [4,1,2,1,2]

Output:
4

The numbers 1 and 2 appear twice, while 4 appears only once.

## Possible Approaches
The problem can be solved using several approaches:

**1) Brute Force / Frequency Counting**
Compare each element with every other element.
- Time: O(n²)
- Space: O(1)

**2) HashMap / Frequency Map**
Store the frequency of each number.
- Time: O(n)
- Space: O(n)

**3) Sorting**
Sort the array and check elements in pairs.
- Time: O(n log n)
- Space: Depends on the sorting implementation.

**4) XOR / Bit Manipulation — Optimal**
Use the properties of the XOR operator.
- Time: O(n)
- Space: O(1)

This solution uses the XOR approach.

## XOR Approach
The key properties of XOR are:
a ^ a = 0

A number XORed with itself becomes 0.

a ^ 0 = a

A number XORed with 0 remains unchanged.
Therefore, all numbers that appear twice will cancel each other out.

For example:
nums = [4,1,2,1,2]

Perform XOR on every element:
4 ^ 1 ^ 2 ^ 1 ^ 2

Rearrange the pairs:
4 ^ (1 ^ 1) ^ (2 ^ 2)

Since:
1 ^ 1 = 0
2 ^ 2 = 0

we get:
4 ^ 0 ^ 0

Therefore:
4
is left.

## Algorithm
1. Initialize `ans` to `0`.
2. Traverse through every element in the array.
3. XOR the current element with `ans`.
4. Duplicate elements cancel each other because:
   a ^ a = 0
5. The remaining value is the element that appears only once.
6. Return `ans`.