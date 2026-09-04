# 455. Assign Cookies

## Difficulty
Easy

## Pattern
Greedy / Two Pointers

## Topics
- Array
- Greedy
- Sorting
- Two Pointers

## Problem
Assume you are an awesome parent and want to give your children some cookies. But you should give each child at most one cookie.

Each child `i` has a greed factor `g[i]`, which is the minimum size of a cookie that the child will be content with. Each cookie `j` has a size `s[j]`. If `s[j] >= g[i]`, we can assign cookie `j` to child `i`, and the child will be content.

Your goal is to maximize the number of your content children and output the maximum number.

## Example 1
Input:
```
g = [1,2,3]
s = [1,1]
```
Output:
```
1
```

Explanation:
You have 3 children and 2 cookies. The greed factors of the 3 children are `1, 2, 3`. Although you have 2 cookies, since their sizes are both `1`, you can only make the child with greed factor `1` content. You need to output `1`.

## Example 2
Input:
```
g = [1,2]
s = [1,2,3]
```
Output:
```
2
```

Explanation:
You have 2 children and 3 cookies. The greed factors of the 2 children are `1, 2`. You have 3 cookies and their sizes are big enough to gratify all of the children. You need to output `2`.

## Possible Approaches
The problem can be solved using several approaches:

**1) Brute Force**
For every child, search through all remaining cookies to find the smallest one that satisfies their greed factor, and mark it as used.
- Time: O(m × n)
- Space: O(n) (to track used cookies)

**2) Sorting + Greedy with Two Pointers — Optimal**
Sort both the greed factors and cookie sizes. Then use two pointers to walk through both arrays simultaneously, always trying to satisfy the least greedy child first with the smallest available cookie.
- Time: O(m log m + n log n) for sorting
- Space: O(1) (excluding sort space)

This solution uses the Sorting + Greedy with Two Pointers approach.

## Greedy Approach

The key insight is that it's always optimal to try satisfying the **least greedy** child using the **smallest** cookie that can satisfy them. This way, larger cookies are preserved for children with bigger greed factors, maximizing the total number of children who can be made content.

To achieve this, we first sort both `g` (greed factors) and `s` (cookie sizes) in ascending order.

We then use two pointers:
- `i` — points to the current child being considered (starts at `0`).
- `j` — points to the current cookie being considered (starts at `0`).

We move `j` forward through the cookies one at a time. For each cookie `s[j]`:
- If it's large enough to satisfy the current child (`s[j] >= g[i]`), we assign this cookie to that child, so we move `i` forward as well (that child is now content).
- Regardless of whether the cookie satisfied the child or not, we always move `j` forward, since each cookie can only be considered/used once.

This greedily pairs up children and cookies in sorted order, and `i` at the end represents exactly how many children were successfully made content.

**Trace for `g = [1,2,3]`, `s = [1,1]`:**

After sorting (already sorted here):
```text
g = [1, 2, 3]
s = [1, 1]
```

```text
i=0, j=0: s[0]=1 >= g[0]=1 -> child satisfied, i=1
          j=1
i=1, j=1: s[1]=1 >= g[1]=2? No -> child not satisfied
          j=2
Loop ends (j == n)
```

Final value of `i`:
```
1
```

which matches the expected output.

## Algorithm
1. Sort the array `g` (children's greed factors) in ascending order.
2. Sort the array `s` (cookie sizes) in ascending order.
3. Initialize two pointers, `i = 0` (for children) and `j = 0` (for cookies).
4. While `i < g.length` and `j < s.length`:
   - If `s[j] >= g[i]`, this cookie satisfies the current child, so increment `i`.
   - Always increment `j`, moving to the next cookie regardless of the outcome.
5. Once the loop ends, `i` represents the total number of children who were successfully made content.
6. Return `i`.