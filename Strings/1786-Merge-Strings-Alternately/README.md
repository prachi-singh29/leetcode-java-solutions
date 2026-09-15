# 1768. Merge Strings Alternately

## Difficulty
Easy

## Pattern
Two Pointers

## Topics
- Two Pointers
- String

## Problem
You are given two strings `word1` and `word2`. Merge the strings by
adding letters in **alternating order**, starting with `word1`. If one
string is longer than the other, append the additional letters onto the
end of the merged string.

Return the merged string.

## Example 1
Input:
```
word1 = "abc", word2 = "pqr"
```
Output:
```
"apbqcr"
```

Explanation:
```text
The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
```

## Example 2
Input:
```
word1 = "ab", word2 = "pqrs"
```
Output:
```
"apbqrs"
```

Explanation:
```text
Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q r s
```

## Possible Approaches
The problem can be solved using several approaches:

**1) Two Pointers with a Single Shared Index — Optimal**
Walk a single index `i` forward across both strings at once. At each
step, append `word1[i]` if it still has a character at that position,
then append `word2[i]` if it does too. Once `i` exceeds both lengths,
stop — this naturally handles the "append the leftover tail" requirement
without any special-casing.
- Time: O(n + m)
- Space: O(n + m) for the result string (O(1) extra beyond the output)

**2) Two Separate Pointers**
Use two independent pointers `i` and `j`, advance whichever string still
has characters left, alternating which one gets appended first, then
append any remaining tail from the longer string in one shot at the end.
- Time: O(n + m)
- Space: O(n + m) for the result string

**3) Built-in Interleave + Substring Append**
Loop up to `min(n, m)`, appending one character from each string per
iteration, then use `substring()` to append whichever string still has
characters remaining beyond the shorter length.
- Time: O(n + m)
- Space: O(n + m) for the result string

This solution uses the **Two Pointers with a Single Shared Index**
approach — it directly mirrors approach (1).

## Algorithm
1. Create a `StringBuilder res` to build the merged result.
2. Initialize `i = 0`.
3. While `i` is a valid index for **either** `word1` or `word2`:
   - If `i < word1.length()`, append `word1.charAt(i)` to `res`.
   - If `i < word2.length()`, append `word2.charAt(i)` to `res`.
   - Increment `i`.
4. Once `i` is out of bounds for both strings, the loop ends.
5. Return `res.toString()`.

## Edge Cases Covered
- **Different lengths** — since both length checks (`i < word1.length()`
  and `i < word2.length()`) are independent `if`s rather than an
  `if/else`, the loop keeps running and appending from the longer string
  after the shorter one is exhausted, automatically handling the
  "append the remaining letters" requirement.
- **One empty string** — if `word1` (or `word2`) is `""`, its length
  check never passes, so the result is simply the other string
  unchanged.
- **Both empty strings** — the `while` condition is `false` immediately,
  and an empty `StringBuilder` returns `""`.
- **Equal-length strings** — both `if` branches fire on every iteration,
  producing a perfectly alternating result with no leftover tail.