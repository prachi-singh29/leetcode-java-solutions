# 28. Find the Index of the First Occurrence in a String

## Difficulty
Easy

## Pattern
String / String Matching

## Topics
- String
- String Matching
- Two Pointers

## Problem
Given two strings `haystack` and `needle`, return the index of the first occurrence of `needle` in `haystack`.
If `needle` is not part of `haystack`, return `-1`.

## Possible Approaches
The problem can be solved using several approaches:

**1) Brute Force / Character Matching**
Check every possible starting position in `haystack` and compare the characters of `needle` with the corresponding characters in `haystack`.
- Time: O(n × m)
- Space: O(1)
where:
- `n` = length of `haystack`
- `m` = length of `needle`

**2) Built-in String Search**
Java provides methods such as:
haystack.indexOf(needle)
which can directly find the first occurrence.
- Time: Depends on the underlying implementation
- Space: Depends on the implementation

**3) KMP (Knuth-Morris-Pratt)**
KMP preprocesses the `needle` using an LPS (Longest Prefix Suffix) array and avoids unnecessary comparisons.
- Time: O(n + m)
- Space: O(m)

This solution uses the Brute Force / Character Matching approach because it is straightforward and useful for understanding string matching.

## Algorithm
1. Get the lengths of `haystack` and `needle`.
2. If `needle` is longer than `haystack`, return `-1`.
3. Traverse `haystack` from index `0`.
4. For each index, check whether `needle` can fit starting from that position.
5. Compare each character of `needle` with the corresponding character of `haystack`.
6. If all characters match, return the current starting index.
7. If no match is found after checking all possible positions, return `-1`.