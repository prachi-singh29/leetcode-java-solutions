# 1679. Max Number of K-Sum Pairs

## Difficulty
Medium

## Pattern
Array / Hash Table / Two Pointers

## Topics
- Array
- Hash Table
- Two Pointers
- Sorting

## Problem
You are given an integer array `nums` and an integer `k`.

In one operation, you can pick two numbers from the array whose sum equals `k` and remove them from the array.

Return the maximum number of operations you can perform on the array.

## Example 1
Input:
```
nums = [1,2,3,4]
k = 5
```
Output:
```
2
```

Explanation:
```text
Starting with nums = [1,2,3,4]:
- Remove 1 and 4, obtaining nums = [2,3]
- Remove 2 and 3, obtaining nums = []
```
There are no more pairs that sum up to `5`, so a total of `2` operations were made.

## Example 2
Input:
```
nums = [3,1,3,4,3]
k = 6
```
Output:
```
1
```

Explanation:
```text
Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, obtaining nums = [1,4,3]
```
There are no more pairs that sum up to `6`, so a total of `1` operation was made.

## Possible Approaches
The problem can be solved using several approaches:

**1) Brute Force**
Check every pair of elements in the array, and whenever a pair sums to `k`, mark both as used and count the operation.
- Time: O(n²)
- Space: O(n) (to mark used indices)

**2) Sorting + Two Pointers**
Sort the array, then use two pointers — one at the start and one at the end. If the sum of the two pointed elements equals `k`, count it and move both pointers inward. If the sum is smaller, move the left pointer right; if larger, move the right pointer left.
- Time: O(n log n)
- Space: O(1) (excluding sort space)

**3) HashMap Frequency Counting — Optimal**
Store the frequency of every number in a hash map, then for each unique number, check whether its complement (`k - number`) also exists and pair up as many occurrences as possible.
- Time: O(n)
- Space: O(n)

This solution uses the HashMap Frequency Counting approach.

## HashMap Frequency Counting Approach

The idea is to first record how many times each number appears in `nums` using a frequency map. Then, for every distinct number `i` in the map, we look for its complement:

```text
complement = k - i
```

If the complement doesn't exist in the map, no pair can be formed with `i`, so we skip it.

If it does exist, there are two cases:

**Case 1: `i == complement`**
This happens when a number pairs with itself (e.g., `i = 3` and `k = 6`, so `complement = 3`). In this case, we can only form pairs using multiples of two from the same group:
```text
count += map.get(i) / 2
```

**Case 2: `i != complement`**
Here, each occurrence of `i` can pair with one occurrence of `complement`. The number of pairs is limited by whichever value has fewer occurrences:
```text
count += Math.min(map.get(i), map.get(complement))
```

After processing a pair `(i, complement)`, both entries are reset to `0` in the map (`map.put(i, 0)` and `map.put(complement, 0)`) so that they are not accidentally reprocessed later when the loop reaches `complement` as the outer key — this avoids double-counting the same pair group twice.

**Trace for `nums = [3,1,3,4,3]`, `k = 6`:**

Frequency map:
```text
{3: 3, 1: 1, 4: 1}
```

Processing each key:
```text
i = 3 -> complement = 3 (self-pair) -> count += map.get(3)/2 = 3/2 = 1 -> count = 1
         map.put(3, 0)
i = 1 -> complement = 5 -> not in map -> skip
i = 4 -> complement = 2 -> not in map -> skip
```

Final count:
```
1
```

## Algorithm
1. Create a `HashMap<Integer, Integer>` to store the frequency of each number in `nums`.
2. Traverse `nums` and populate the map, incrementing the count for each number as it's encountered.
3. Initialize `count = 0`.
4. Traverse each unique key `i` in the map:
   - Compute `complement = k - i`.
   - If `complement` is not a key in the map, skip to the next key.
   - If `i == complement`, add `map.get(i) / 2` to `count`.
   - Otherwise, add `Math.min(map.get(i), map.get(complement))` to `count`.
   - Set both `map.get(i)` and `map.get(complement)` to `0` to prevent reprocessing this pair.
5. After all keys are processed, return `count`.