# 219. Contains Duplicate II

## Difficulty
Easy

## Pattern
Array / Hash Table / Sliding Window

## Topics
- Array
- Hash Table
- Sliding Window

## Problem
Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` such that:
nums[i] == nums[j]

and:
|i - j| <= k

Otherwise, return `false`.

## Possible Approaches
The problem can be solved using several approaches:

**1) Brute Force**
Compare every element with the elements that come after it and check whether their indices are within `k`.
- Time: O(n²)
- Space: O(1)

**2) HashSet + Sliding Window — Optimal**
Maintain a set containing the elements within the current window of size `k`.
- Time: O(n)
- Space: O(k)

**3) HashMap**
Store the most recent index of every number. When the same number appears again, check the distance between the current index and its previous index.
- Time: O(n)
- Space: O(n)

## Algorithm
1. Create a `HashSet`.
2. Traverse the array using index `i`.
3. Before adding the current element, check whether it already exists in the set.
4. If it exists, return `true`.
5. Add the current element to the set.
6. If the window size becomes greater than `k`, remove the element that is outside the window.
7. Continue until the array is completely traversed.
8. If no valid duplicate is found, return `false`.