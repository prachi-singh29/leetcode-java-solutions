# 1071. Greatest Common Divisor of Strings

## Difficulty
Easy

## Pattern
String Manipulation / Euclidean Algorithm (GCD)

## Topics
- Math
- String

## Problem
For two strings `s` and `t`, we say `"t divides s"` if and only if
`s = t + t + t + ... + t` (i.e. `t` is concatenated with itself one or
more times to form `s`).

Given two strings `str1` and `str2`, return the **largest** string `x`
such that `x` divides both `str1` and `str2`.

## Example 1
Input:
```
str1 = "ABCABC", str2 = "ABC"
```
Output:
```
"ABC"
```

## Example 2
Input:
```
str1 = "ABABAB", str2 = "ABAB"
```
Output:
```
"AB"
```

Explanation:
```text
"ABABAB" = "AB" + "AB" + "AB"
"ABAB"   = "AB" + "AB"
"AB" is the largest string that divides both.
```

## Example 3
Input:
```
str1 = "LEET", str2 = "CODE"
```
Output:
```
""
```

Explanation:
```text
There is no string that, repeated one or more times, can build both
"LEET" and "CODE", so the answer is the empty string.
```

## Possible Approaches
The problem can be solved using several approaches:

**1) Brute Force — Try Every Prefix Length**
Try every possible divisor length from the length of the shorter string
down to `1`. For each candidate length, take that prefix of the shorter
string and check whether repeating it can exactly rebuild both `str1`
and `str2`. Return the first (largest) length that works.
- Downside: repeatedly rebuilding and comparing strings for every
  candidate length is wasteful once a smarter check is available.

**2) Concatenation Check + GCD of Lengths — Optimal**
Two key insights combine into an elegant solution:
- If a common divisor string exists, `str1` and `str2` must be built
  from repeats of the *same* base string, which means they must
  "commute" when concatenated: `str1 + str2` must equal `str2 + str1`.
  If they don't match, no common divisor exists at all.
- If they do match, the length of the largest possible common divisor
  string is the mathematical **GCD of `str1.length()` and
  `str2.length()`**, using the standard Euclidean algorithm — exactly
  the same logic as finding the GCD of two integers, just applied to
  string lengths. The divisor string itself is simply the prefix of
  either string with that length.

This solution uses the **Concatenation Check + GCD of Lengths**
approach.

## Algorithm
1. Let `len1` and `len2` be the lengths of `str1` and `str2`.
2. Check whether `str1 + str2` equals `str2 + str1`.
   - If they are **not** equal, no common divisor string can exist —
     return `""` immediately.
3. If they **are** equal, a common divisor string exists. Its length is
   `gcd(len1, len2)`, computed via the Euclidean algorithm:
   - `gcd(a, b)`: if `b == 0`, return `a`; otherwise recurse with
     `gcd(b, a % b)`.
4. Take the substring of `str1` from index `0` up to (but not including)
   `gcd(len1, len2)` — this is the largest common divisor string.
5. Return that substring.