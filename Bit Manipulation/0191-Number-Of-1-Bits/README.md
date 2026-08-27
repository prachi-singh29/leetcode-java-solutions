# 191. Number of 1 Bits

## Difficulty
Easy

## Pattern
Bit Manipulation

## Topics
- Divide and Conquer
- Bit Manipulation

## Problem
Given a positive integer `n`, write a function that returns the number of set bits (also known as the Hamming weight) in its binary representation.

## Example 1
Input:
```
n = 11 (00000000000000000000000000001011)
```
Output:
```
3
```

Explanation:
The input binary string `00000000000000000000000000001011` has a total of three `1`'s.

## Example 2
Input:
```
n = 128 (00000000000000000000000010000000)
```
Output:
```
1
```

Explanation:
The input binary string `00000000000000000000000010000000` has a total of one `1`.

## Example 3
Input:
```
n = 2147483645 (01111111111111111111111111111101)
```
Output:
```
30
```

Explanation:
The input binary string `01111111111111111111111111111101` has a total of thirty `1`'s.

## Possible Approaches
The problem can be solved using several approaches:

**1) Bit-by-Bit Check with Mask**
Check each of the 32 bit positions using a shifting mask and count how many are set.
- Time: O(32) = O(1)
- Space: O(1)

**2) Right Shift and Check LSB**
Repeatedly check the least significant bit using `n & 1`, then right-shift `n` by 1, counting the set bits along the way.
- Time: O(32) = O(1)
- Space: O(1)

**3) Brian Kernighan's Algorithm — Optimal**
Repeatedly turn off the lowest set bit using `n & (n - 1)` and count how many times this operation is performed until `n` becomes `0`. This only loops once per set bit, not once per total bit.
- Time: O(k), where k = number of set bits
- Space: O(1)

**4) Built-in Function**
Use a language built-in such as `Integer.bitCount(n)` in Java.
- Time: O(1) (hardware-optimized)
- Space: O(1)

This solution uses Brian Kernighan's Algorithm because it is the most efficient manual approach, skipping over runs of zero bits entirely.

## Brian Kernighan's Algorithm

The key trick is the expression:
```text
n & (n - 1)
```

This operation always clears (turns off) the lowest set bit of `n`, no matter how many zeros follow it.

**Why this works:**
Subtracting `1` from `n` flips all the bits from the lowest set bit down to bit `0`. ANDing this with the original `n` cancels out that lowest set bit while leaving all higher bits unchanged.

For example:
```text
n = 1011 0100

n - 1        = 1011 0011
n & (n - 1)  = 1011 0100 & 1011 0011 = 1011 0000
```

Notice the lowest set bit (at position 2) has been cleared, while everything else remains the same.

We repeat this operation, incrementing a counter each time, until `n` becomes `0`. The number of iterations equals the number of `1` bits.

Trace for `n = 1011` (binary):
```text
Step 1: n = 1011 -> n & (n-1) = 1011 & 1010 = 1010, count = 1
Step 2: n = 1010 -> n & (n-1) = 1010 & 1001 = 1000, count = 2
Step 3: n = 1000 -> n & (n-1) = 1000 & 0111 = 0000, count = 3
Step 4: n = 0000 -> loop ends
```

Final count:
```
3
```

## Algorithm

1. Initialize `count = 0`.
2. While `n != 0`:
   - Update `n = n & (n - 1)` to clear the lowest set bit.
   - Increment `count` by `1`.
3. Once `n` becomes `0`, the loop ends.
4. Return `count` as the total number of set bits.