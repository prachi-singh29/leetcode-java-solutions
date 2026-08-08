# 242. Valid Anagram

## Difficulty
Easy

## Pattern
Hashing / Frequency Count

## Topics
- String
- Hash Table
- Sorting

## Approach
The goal is to determine whether two strings are anagrams of each other.

Two strings are anagrams if they contain the **same characters with the same frequencies**, but the characters can appear in a different order.

For example:
s = "anagram"
t = "nagaram"

Both strings contain:
a → 3
n → 1
g → 1
r → 1
m → 1


Therefore, they are anagrams.

We can solve this efficiently using a frequency array.

Since the problem contains lowercase English letters, we can create an array of size `26`.

- Increment the count for every character in `s`.
- Decrement the count for every character in `t`.
- If all counts are `0`, the strings are anagrams.

## Algorithm
1. If the lengths of the two strings are different, return `false`.
2. Create an integer array of size `26`.
3. Traverse `s` and increment the frequency of each character.
4. Traverse `t` and decrement the frequency of each character.
5. Traverse the frequency array.
6. If any value is not `0`, return `false`.
7. Otherwise, return `true`.