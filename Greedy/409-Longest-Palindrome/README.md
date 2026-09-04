# 409. Longest Palindrome

## Difficulty
Easy

## Pattern
String / Hash Table / Greedy

## Topics
- Hash Table
- String
- Greedy

## Problem
Given a string `s` which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, `"Aa"` is not considered a palindrome.

## Example 1
Input:
```
s = "abccccdd"
```
Output:
```
7
```

Explanation:
One longest palindrome that can be built is `"dccaccd"`, whose length is `7`.

## Example 2
Input:
```
s = "a"
```
Output:
```
1
```

Explanation:
The longest palindrome that can be built is `"a"`, whose length is `1`.

## Possible Approaches
The problem can be solved using several approaches:

**1) Brute Force**
Generate all possible arrangements of the characters and check which ones form the longest palindrome.
- Time: Exponential
- Space: Exponential
- Highly impractical even for small strings.

**2) HashMap Frequency Counting**
Count the frequency of each character using a hash map, then apply the same pairing logic as the array-based approach.
- Time: O(n)
- Space: O(k), where k = number of distinct characters

**3) Fixed-Size Array Frequency Counting — Optimal**
Since the string consists only of English letters (uppercase and lowercase), use a fixed-size array of size 128 (covering all ASCII characters) to count frequencies, avoiding hash map overhead entirely.
- Time: O(n)
- Space: O(1) (the array size is constant, regardless of input size)

This solution uses the Fixed-Size Array Frequency Counting approach.

## Greedy / Frequency Counting Approach

A palindrome reads the same forwards and backwards, which means (except for possibly one character in the very middle) every character must appear in **pairs** — one on the left side mirrored by one on the right side.

So the strategy is:
1. Count how many times each character appears in `s`.
2. For every character, use as many **complete pairs** as possible — each pair contributes `2` to the palindrome's length.
3. If **any** character has a leftover odd occurrence (after using up its pairs), we can place **one** such leftover character in the exact center of the palindrome, adding `1` more to the total length. This only needs to happen once, since a palindrome can only have one center character.

For example, with `s = "abccccdd"`:
```text
Frequency:
a -> 1
b -> 1
c -> 4
d -> 2
```

Processing each character:
```text
a: val=1 -> pairs = 1/2 = 0 -> contributes 0 -> odd leftover exists
b: val=1 -> pairs = 1/2 = 0 -> contributes 0 -> odd leftover exists
c: val=4 -> pairs = 4/2 = 2 -> contributes 2*2 = 4
d: val=2 -> pairs = 2/2 = 1 -> contributes 1*2 = 2
```

Sum of pair contributions:
```text
0 + 0 + 4 + 2 = 6
```

Since there was at least one character with an odd leftover count (`a` or `b`), we can add `1` more character in the center:
```text
6 + 1 = 7
```

This matches the expected output of `7` (e.g., `"dccaccd"`).

**How the code tracks this without a separate flag:**

Instead of using a separate boolean to track "was there an odd leftover", the code cleverly reuses `res` itself:
```java
if (res % 2 == 0 && val % 2 == 1) {
    res++;
}
```

Since `res` is built up entirely from `(val / 2) * 2` terms — which are always even — `res` stays even throughout the loop **until** we add the `+1` for a center character. So checking `res % 2 == 0` is really asking "have we not yet used our one allowed center character?" Once `res` becomes odd (after adding `1`), this condition becomes `false` for all subsequent characters, ensuring the `+1` bonus is only ever applied once, no matter how many characters have odd counts.

## Algorithm

1. Create an integer array `count` of size `128` (covering all ASCII characters), initialized to `0`.
2. Traverse `s` and increment `count[ch]` for each character `ch`.
3. Initialize `res = 0`.
4. Loop through all `128` possible character values:
   - Let `val = count[i]`.
   - Add `(val / 2) * 2` to `res` (the number of characters usable in matching pairs).
   - If `res` is currently even and `val` is odd, increment `res` by `1` (reserve the center slot using this character's leftover).
5. After the loop, return `res` as the length of the longest possible palindrome.