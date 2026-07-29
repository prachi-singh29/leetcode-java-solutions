# 14. Longest Common Prefix

## Problem Statement
Given an array of strings `strs`, return the **longest common prefix** among all the strings.
If there is no common prefix, return an empty string `""`.

### Example 1
**Input**
["flower","flow","flight"]

**Output**
"fl"

### Example 2
**Input**
["dog","racecar","car"]

**Output**
""

## Approach
This solution uses **sorting** to efficiently determine the longest common prefix.

### Key Observation
After sorting the array lexicographically:

- The **first string** will be the smallest.
- The **last string** will be the largest.
- Any common prefix shared by **all** strings must also be common between these two strings.

Therefore, instead of comparing every string, we only compare the first and last strings character by character.

### Algorithm
1. Sort the array of strings.
2. Store the first string as `str1`.
3. Store the last string as `str2`.
4. Compare characters of both strings from left to right.
5. Stop when:
   - Characters differ, or
   - End of one string is reached.
6. Return the substring from index `0` to the matched length.

