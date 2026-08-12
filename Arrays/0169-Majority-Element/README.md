# 169. Majority Element

## Difficulty
Easy

## Pattern
Array / Hash Table / Greedy

## Topics
- Array
- Hash Table
- Counting
- Greedy
- Boyer-Moore Voting Algorithm

## Problem
Given an array `nums` of size `n`, return the majority element.

The majority element is the element that appears more than `n / 2` times.

The problem guarantees that a majority element always exists.

## Example
Input:
nums = [2,2,1,1,1,2,2]

Output:
2

Explanation:
The number 2 appears 4 times in an array of size 7.

Since:
4 > 7 / 2

2 is the majority element.

## Possible Approaches
**1) Sorting**
Sort the array. Since the majority element appears more than n / 2 times, it must occupy the middle position.
- Time: O(n log n)
- Space: Depends on the sorting implementation.

**2) HashMap / Frequency Counting**
Store the frequency of each element and return the element whose frequency is greater than n / 2.
- Time: O(n)
- Space: O(n)

**3) Boyer-Moore Voting Algorithm — Optimal**
Maintain a candidate and a count. Matching elements increase the count, while different elements decrease it. When the count becomes 0, choose a new candidate.
- Time: O(n)
- Space: O(1)

This solution uses the Boyer-Moore Voting Algorithm.

## Algorithm
1. Initialize `candidate = 0` and `count = 0`.
2. Traverse through every element in `nums`.
3. If `count == 0`, make the current element the new candidate.
4. If the current element is equal to `candidate`, increase `count`.
5. Otherwise, decrease `count`.
6. After traversing the entire array, `candidate` is the majority element.
7. Return `candidate`.