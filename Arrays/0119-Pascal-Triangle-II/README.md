# 119. Pascal's Triangle II

## Difficulty
Easy

## Pattern
Math / Combinations

## Topics
- Array
- Math
- Combinatorics

## Problem
Given an integer `rowIndex`, return the `rowIndex`th row of Pascal's Triangle.

The row index is **0-based**.

For example:
rowIndex = 3

The Pascal's Triangle is:
        1
       1 1
      1 2 1
     1 3 3 1

Therefore, the answer is:
[1,3,3,1]

## Approach
Every value in a row of Pascal's Triangle can be represented using combinations:

C(n, r)

For a given `rowIndex = n`, the row is:
C(n,0), C(n,1), C(n,2), ..., C(n,n)

For example, when:
n = 4

the row is:
C(4,0)  C(4,1)  C(4,2)  C(4,3)  C(4,4)
   1       4        6        4        1

So the answer is:
[1,4,6,4,1]

## Formula

Instead of calculating factorials for every value, we can calculate each value using the previous value.

The relationship is:

```text
C(n,r) = C(n,r-1) × (n-r+1) / r
```

## Algorithm

1. Create an empty result list.
2. Initialize `ans = 1`.
3. Add `1` to the result because `C(n,0) = 1`.
4. Loop from `i = 1` to `rowIndex`.
5. Calculate the next combination using:
   ans = ans × (rowIndex - i + 1) / i
6. Add the calculated value to the result.
7. Return the result.