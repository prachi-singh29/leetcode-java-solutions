# 283. Move Zeroes

## Difficulty
Easy

## Pattern
Array / Two Pointers

## Topics
- Array
- Two Pointers
- In-place Algorithm

## Problem
Given an integer array `nums`, move all `0`s to the end of the array while maintaining the relative order of the non-zero elements.
The operation must be performed in-place, without making a copy of the array.

## Possible Approaches
The problem can be solved using several approaches:

**1) Extra Array**
Create another array, place all non-zero elements first, and fill the remaining positions with zeroes.
- Time: O(n)
- Space: O(n)

**2) Brute Force / Shifting**
Whenever a zero is found, shift the elements after it to the left and place the zero at the end.
- Time: O(n²)
- Space: O(1)

**3) Two Pointers — Optimal**
Use a pointer to track the position where the next non-zero element should be placed.
- Time: O(n)
- Space: O(1)

This solution uses the Two Pointer approach.

## Algorithm
1. Initialize `j = 0`.
2. Traverse the array using `i`.
3. If `nums[i]` is not zero:
   - Swap `nums[i]` and `nums[j]`.
   - Increment `j`.
4. Continue until the entire array is processed.
5. The zeroes will automatically be placed at the end.