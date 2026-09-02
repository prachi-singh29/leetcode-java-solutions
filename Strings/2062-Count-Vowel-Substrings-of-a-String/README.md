# 2062. Count Vowel Substrings of a String

## Difficulty
Easy

## Pattern
String / Sliding Window / Brute Force

## Topics
- String
- Hash Table
- Sliding Window

## Problem
A substring is a contiguous (non-empty) sequence of characters within a string.

A vowel substring is a substring that contains **only vowels** (`'a'`, `'e'`, `'i'`, `'o'`, `'u'`) and contains **all five vowels at least once**.

Given a string `word`, return the number of vowel substrings in `word`.

## Example 1
Input:
```
word = "aeiouu"
```
Output:
```
2
```

Explanation:
The vowel substrings of `word` are:
```text
aeiou  (index 0-4)
aeiouu (index 0-5)
```

## Example 2
Input:
```
word = "unicornarihan"
```
Output:
```
0
```

Explanation:
`word` does not have a substring containing all five vowels, so there are no vowel substrings.

## Example 3
Input:
```
word = "cuaieuouac"
```
Output:
```
7
```

## Possible Approaches
The problem can be solved using several approaches:

**1) Brute Force — Expand from Every Starting Index**
For every starting index `i`, extend a substring character by character as long as it stays entirely made of vowels, tracking how many unique vowels have been seen so far.
- Time: O(n²)
- Space: O(1) (fixed-size tracking array of 5 vowels)

**2) Sliding Window**
Maintain a window of consecutive vowel-only characters and track vowel frequency counts within it, shrinking or resetting the window when a non-vowel is found or a vowel count needs adjusting.
- Time: O(n)
- Space: O(1)

**3) Precompute Vowel-Only Segments, Then Check Substrings**
Split `word` into maximal runs of consecutive vowels first, then for each run, count qualifying substrings using nested loops or frequency counting within just that run.
- Time: O(n²) in the worst case (single large vowel run)
- Space: O(n)

This solution uses the Brute Force — Expand from Every Starting Index approach.

## Brute Force Approach

The idea is to try **every possible starting index** `i` in `word`, and from there, keep extending the substring one character at a time (`j = i, i+1, i+2, ...`) as long as every character encountered is a vowel.

While extending, we track:
- `seen[]` — a boolean array of size 5, one slot per vowel (`a`, `e`, `i`, `o`, `u`), marking whether that vowel has appeared in the current substring `word[i..j]`.
- `unique` — a running count of how many distinct vowels have been seen so far in the current substring.

As soon as a non-vowel character is encountered, we `break` out of the inner loop — since any substring starting at `i` and extending past this point can never be vowel-only, so there's no point checking further.

Whenever `unique` reaches `5`, it means the current substring `word[i..j]` contains all five vowels at least once, so we increment `count`. Note that even after `unique` hits `5`, the loop continues extending `j` further (as long as vowels continue), because a longer substring like `word[i..j+1]` may *also* be a valid vowel substring (e.g., `"aeiou"` and `"aeiouu"` are both valid, as seen in Example 1).

**Trace for `word = "aeiouu"`, starting at `i = 0`:**
```text
j=0: c='a' -> seen[a]=true, unique=1
j=1: c='e' -> seen[e]=true, unique=2
j=2: c='i' -> seen[i]=true, unique=3
j=3: c='o' -> seen[o]=true, unique=4
j=4: c='u' -> seen[u]=true, unique=5 -> count++ (count=1, substring "aeiou")
j=5: c='u' -> already seen, unique stays 5 -> count++ (count=2, substring "aeiouu")
```

This process is repeated for every starting index `i` from `0` to `word.length() - 1`, and the counts from each starting point are summed together into the final `count`.

## Algorithm
1. Initialize `count = 0`.
2. Loop over every starting index `i` from `0` to `word.length() - 1`.
3. For each `i`, reset a `seen` array of size `5` (all `false`) and `unique = 0`.
4. Loop over every ending index `j` starting from `i`:
   - Get the character `c = word.charAt(j)`.
   - If `c` is not a vowel, `break` out of the inner loop (no valid substring can extend past this point).
   - Map `c` to its vowel index (`a=0, e=1, i=2, o=3, u=4`).
   - If this vowel hasn't been seen yet in the current substring, mark it as seen and increment `unique`.
   - If `unique == 5`, increment `count` (the current substring `word[i..j]` is a valid vowel substring).
5. After both loops finish, return `count`.