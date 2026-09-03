# 3849. Maximum Bitwise XOR After Rearrangement

## Difficulty
Medium

## Pattern
Greedy / String / Bit Manipulation

## Topics
- Greedy
- String
- Bit Manipulation
- Counting

## Problem
You are given two binary strings `s` and `t`, each of length `n`.

You may rearrange the characters of `t` in any order, but `s` must remain unchanged.

Return a binary string of length `n` representing the maximum integer value obtainable by taking the bitwise XOR of `s` and rearranged `t`.

## Example 1
Input:
```
s = "101"
t = "011"
```
Output:
```
"110"
```

Explanation:
One optimal rearrangement of `t` is `"011"`.
The bitwise XOR of `s` and rearranged `t` is:
```text
"101" XOR "011" = "110"
```
which is the maximum possible.

## Example 2
Input:
```
s = "0110"
t = "1110"
```
Output:
```
"1101"
```

Explanation:
One optimal rearrangement of `t` is `"1011"`.
```text
"0110" XOR "1011" = "1101"
```

## Example 3
Input:
```
s = "0101"
t = "1001"
```
Output:
```
"1111"
```

Explanation:
One optimal rearrangement of `t` is `"1010"`.
```text
"0101" XOR "1010" = "1111"
```

## Possible Approaches
The problem can be solved using several approaches:

**1) Try All Permutations of `t`**
Generate every possible rearrangement of `t`, compute the XOR with `s` for each, and keep the maximum.
- Time: O(n! × n)
- Space: O(n)
- Impractical for anything beyond very small `n`.

**2) Greedy with Character Counting — Optimal**
Count how many `'0'`s and `'1'`s are available in `t`. Then, walk through `s` from left to right (most significant bit to least significant bit), and at each position, greedily place whichever bit from `t` produces a `1` in the XOR result — prioritizing higher bit positions since they contribute more to the integer value.
- Time: O(n)
- Space: O(1) (excluding the output string)

This solution uses the Greedy with Character Counting approach.

## Greedy Approach

Since we want the **maximum integer value**, and binary strings are compared most-significant-bit first, our priority is to place a `'1'` as early (as far left) in the result as possible, for as many positions as possible — position `0` (leftmost) matters more than any position after it.

Recall how XOR works on individual bits:
```text
0 XOR 0 = 0
0 XOR 1 = 1
1 XOR 0 = 1
1 XOR 1 = 0
```

So a XOR result of `1` requires the two bits to be **different**. This means:
- If `s[i] == '0'`, we want to pair it with a `'1'` from `t` (to get `1`).
- If `s[i] == '1'`, we want to pair it with a `'0'` from `t` (to get `1`).

Since we can rearrange `t` freely, the strategy is:

1. First, count the total number of `'1'`s and `'0'`s available in `t`.
2. Traverse `s` from left to right (highest place value first).
3. At each position:
   - If `s[i] == '0'`: use a `'1'` from `t` if any remain (producing `1` in the result), otherwise fall back to a `'0'` from `t` (producing `0`).
   - If `s[i] == '1'`: use a `'0'` from `t` if any remain (producing `1` in the result), otherwise fall back to a `'1'` from `t` (producing `0`).
4. Whichever choice is made, decrement the corresponding counter (`ones` or `zeroes`), since that character from `t` has now been used.

Because we always prefer to satisfy the earliest (most significant) positions first, and greedily consume the "matching" bit type whenever available, this produces the lexicographically largest — and therefore numerically largest — binary result.

**Trace for `s = "101"`, `t = "011"`:**

Count of `t`: `ones = 2`, `zeroes = 1`

```text
i=0: s[0]='1' -> want a '0' from t -> zeroes(1) > 0 -> append '1', zeroes-- (zeroes=0)
i=1: s[1]='0' -> want a '1' from t -> ones(2) > 0 -> append '1', ones-- (ones=1)
i=2: s[2]='1' -> want a '0' from t -> zeroes(0) == 0 -> fallback: append '0', ones-- (ones=0)
```

Result:
```
"110"
```

which matches the expected output.

## Algorithm

1. Traverse `t` and count the number of `'1'` characters (`ones`) and `'0'` characters (`zeroes`).
2. Initialize an empty `StringBuilder` (or equivalent) called `result`.
3. Traverse `s` from left to right, for each character `c`:
   - If `c == '0'`:
     - If `ones > 0`, append `'1'` to `result` and decrement `ones`.
     - Otherwise, append `'0'` to `result` and decrement `zeroes`.
   - If `c == '1'`:
     - If `zeroes > 0`, append `'1'` to `result` and decrement `zeroes`.
     - Otherwise, append `'0'` to `result` and decrement `ones`.
4. After processing every character of `s`, return `result` as a string.