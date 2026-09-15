# 1431. Kids With the Greatest Number of Candies

## Difficulty
Easy

## Pattern
Two-Pass Array Scan (Find Max, Then Compare)

## Topics
- Array

## Problem
There are `n` kids with candies. You are given an integer array
`candies`, where each `candies[i]` represents the number of candies the
`i`-th kid has, and an integer `extraCandies`, representing the number
of extra candies you have.

Return a boolean array `result` of length `n`, where `result[i]` is
`true` if, after giving the `i`-th kid all `extraCandies`, they will
have the **greatest** number of candies among all the kids, or `false`
otherwise.

Note that multiple kids can have the greatest number of candies.

## Example 1
Input:
```
candies = [2,3,5,1,3], extraCandies = 3
```
Output:
```
[true,true,true,false,true]
```

Explanation:
```text
Kid 1 has 2 candies + 3 extra = 5, which is the greatest among all kids.
Kid 2 has 3 candies + 3 extra = 6, which is the greatest among all kids.
Kid 3 has 5 candies + 3 extra = 8, which is the greatest among all kids.
Kid 4 has 1 candy  + 3 extra = 4, which is not the greatest.
Kid 5 has 3 candies + 3 extra = 6, which is the greatest among all kids.
```

## Example 2
Input:
```
candies = [4,2,1,1,2], extraCandies = 1
```
Output:
```
[true,false,false,false,false]
```

## Possible Approaches
The problem can be solved using several approaches:

**1) Brute Force — Compare Against All Other Kids**
For each kid `i`, add `extraCandies` to `candies[i]` and check whether
this new value is `>=` every other kid's original candy count, by
scanning the whole array again.
- Downside: recomputes the "greatest" comparison from scratch for every
  kid, doing far more work than necessary.

**2) Two-Pass Scan — Find Max First, Then Compare — Optimal**
Since the target to beat (the current maximum candy count) doesn't
change no matter which kid is being checked, compute it **once** up
front in a single pass. Then, in a second pass, each kid only needs a
single comparison: does `candies[i] + extraCandies >= max`?
- This avoids repeated work and is the natural, most direct solution.

This solution uses the **Two-Pass Scan** approach.

## Algorithm
1. Let `n` be the length of `candies`, and initialize `max = 0`.
2. **First pass:** loop through `candies` and update `max` whenever a
   larger value is found, so `max` ends up holding the greatest candy
   count among all kids (before any extra candies are given out).
3. Create an empty result list `result`.
4. **Second pass:** loop through `candies` again. For each kid `i`:
   - If `candies[i] + extraCandies >= max`, that kid could have the
     greatest number of candies — add `true` to `result`.
   - Otherwise, add `false` to `result`.
5. Return `result`.

