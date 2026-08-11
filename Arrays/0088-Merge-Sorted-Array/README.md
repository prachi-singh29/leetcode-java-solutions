# 88. Merge Sorted Array

## Difficulty
Easy

## Pattern
Two Pointers

## Topics
- Arrays
- Two Pointers
- Sorting

## Approach
The goal is to merge two sorted arrays into `nums1` in sorted order.

`nums1` has enough space to store all elements from both arrays.

For example:
nums1 = [1,2,3,0,0,0]
m = 3

nums2 = [2,5,6]
n = 3

The first `m` elements of `nums1` are valid:
[1,2,3]

The remaining positions are empty space:
[0,0,0]

There are two possible approaches.

# Approach 1: Copy and Sort
A simple approach is to copy all elements of `nums2` into the empty positions of `nums1`.
nums1 = [1,2,3,2,5,6]


Then sort the entire array:
[1,2,2,3,5,6]


# Approach 2: Optimal Two-Pointer Approach
Since both arrays are already sorted, we don't need to sort the combined array again.

The empty positions in `nums1` are at the **end**, so we can merge the arrays from **right to left**.

We use three pointers:
i = m - 1
j = n - 1
k = m + n - 1
Where:

- `i` points to the last valid element in `nums1`.
- `j` points to the last element in `nums2`.
- `k` points to the last position in `nums1`.

We compare:
nums1[i] and nums2[j]

and place the larger element at:
nums1[k]

Then move the corresponding pointer backward.

## Algorithm
1. Set `i = m - 1`.
2. Set `j = n - 1`.
3. Set `k = m + n - 1`.
4. While both arrays still have elements:
   - Compare `nums1[i]` and `nums2[j]`.
   - Place the larger element at `nums1[k]`.
   - Move the corresponding pointer backward.
   - Decrease `k`.
5. If elements remain in `nums2`, copy them into `nums1`.
6. Elements remaining in `nums1` do not need to be moved.