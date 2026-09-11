# 3483. Unique 3-Digit Even Numbers

## Difficulty
Easy

## Pattern
Brute Force Enumeration / Backtracking (fixed depth-3 permutations)

## Topics
- Array
- Hash Table
- Enumeration
- Backtracking

## Problem
You are given an array `digits` where `digits[i]` is a digit (`0`-`9`).
Some digits may repeat.

You need to form the **largest possible set of unique 3-digit even
numbers** such that each digit in an integer comes from a **different
index** in `digits` (each index can be used at most once per number), and:

- The number **cannot** have leading zeros.
- The number must be **even**.

Return the total number of **distinct** 3-digit even integers that can
be formed this way.

## Example 1
Input:
```
digits = [1,2,3,4]
```
Output:
```
12
```

Explanation:
```text
All combinations that lead to a valid 3-digit even number are:
132, 134, 142, 124, 214, 212... (duplicates skipped)
Since all 4 digits are distinct, this simplifies to:
choose an ordered triple (first, second, third) of distinct indices
where the last digit is even (2 or 4).
There are 4 * 3 * 2 = 24 such ordered triples total, and exactly half
of them end in an even digit -> 12 unique even numbers.
```

## Example 2
Input:
```
digits = [0,2,2]
```
Output:
```
2
```

Explanation:
```text
The only unique 3-digit even numbers that can be formed (no leading
zero, last digit even) are:
202, 220
```

## Possible Approaches
The problem can be solved using several approaches:

**1) Brute Force — Try Every Ordered Triple of Indices**
Fix an index `i` for the hundreds digit, `j` for the tens digit, and `k`
for the units digit (all distinct indices), skip invalid leading zeros
and odd units digits, then record the resulting number in a `visited`
array to avoid counting duplicates twice.
- Time: O(n³)
- Space: O(1000) for the `visited` array (bounded, independent of `n`)

**2) Combinatorial Counting (no explicit number construction)**
Count the frequency of each digit `0-9`. For every choice of an even
units digit `u`, a nonzero hundreds digit `h`, and any tens digit `t`
(all using distinct index "slots" but digit *values* may repeat across
different original indices), determine whether that `(h, t, u)` triple
is achievable given the available counts, and tally distinct `h*100 +
t*10 + u` values directly with a boolean/set structure sized `10x10x10`
instead of iterating over indices.
- Time: O(n) to build frequency counts + O(10³) to enumerate digit
  combinations
- Space: O(1)

**3) Backtracking with a "used" Array**
Recursively pick 3 distinct indices one at a time (hundreds → tens →
units), pruning branches early (skip leading zero at depth 0, skip odd
digits at depth 2), and insert the completed number into a `HashSet`.
- Time: O(n³) in the worst case (same search space as brute force,
  pruned slightly earlier)
- Space: O(n) recursion depth + O(set size) for results

This solution uses the **Brute Force / Triple-Loop with a `visited`
array** approach — it directly mirrors approach (1).

## Algorithm
1. Let `n` be the length of `digits`. Create a `boolean[1000] vis` array
   to mark 3-digit numbers (`000`-`999`) already counted, and `ans = 0`.
2. Loop `i` from `0` to `n-1` as the **hundreds** digit's index:
   - Skip if `digits[i] == 0` (no leading zero allowed).
3. Loop `j` from `0` to `n-1` as the **tens** digit's index:
   - Skip if `j == i` (index already used).
4. Loop `k` from `0` to `n-1` as the **units** digit's index:
   - Skip if `k == i`, `k == j` (index already used), or
     `digits[k] % 2 != 0` (units digit must be even).
5. Compute the number `x = digits[i] * 100 + digits[j] * 10 + digits[k]`.
6. If `x` hasn't been seen before (`!vis[x]`), mark `vis[x] = true` and
   increment `ans`.
7. After all three loops finish, return `ans`.

## Edge Cases Covered
- **Leading zero** — `digits[i] == 0` is skipped for the hundreds
  position, so no number in the count starts with `0`.
- **Odd units digit** — `digits[k] % 2 != 0` is skipped, guaranteeing
  every counted number is even.
- **Reused index** — `k == i`, `k == j`, and `j == i` checks ensure each
  digit position in a given number comes from a distinct original index,
  even if the array has duplicate digit *values*.
- **Duplicate resulting numbers** — the `vis` boolean array deduplicates
  numbers that can be formed multiple ways from different index
  combinations (e.g. two `2`s at different indices both producing `202`).