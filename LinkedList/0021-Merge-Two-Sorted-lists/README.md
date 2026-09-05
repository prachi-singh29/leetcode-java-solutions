# Merge Two Sorted Lists

Merge two sorted singly linked lists into a single sorted linked list by
splicing the existing nodes together (no new nodes are created).

## Problem

Given the heads of two sorted linked lists `list1` and `list2`, merge them
into one sorted list and return the head of the merged list.

**Example**

```
Input:  list1 = 1 -> 2 -> 4
        list2 = 1 -> 3 -> 4
Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
```

**Constraints**

- The number of nodes in both lists is in the range `[0, 50]`.
- `-100 <= Node.val <= 100`
- Both `list1` and `list2` are sorted in non-decreasing order.

## Approach

This is the classic two-pointer merge from merge sort, applied directly to
linked lists:

1. Handle the trivial cases first — if either list is `null`, the other
   list is already the answer.
2. Walk `list1` and `list2` together with a `ptr` cursor. At each step,
   compare the current nodes' values and splice the smaller node onto the
   merged list, then advance that list's pointer.
3. The very first node picked becomes `head`; every subsequent node is
   attached via `ptr.next` and `ptr` moves forward.
4. Once one list is exhausted, the remaining list is already sorted, so
   it's simply attached as-is to the tail (`ptr.next`) — no need to keep
   comparing node by node.

No extra nodes are allocated; only `next` pointers are rewired, so the
merge runs in-place.

## Edge Cases Covered
 
- **One or both lists are `null`** — returned immediately (`list1 == null`
  or `list2 == null` checks at the top).
- **Lists of very different lengths** — the leftover tail of the longer
  list is attached in one shot once the other list runs out.
- **Duplicate values across lists** — ties are broken by taking from
  `list2` when values are equal (`list1.val < list2.val` is `false`),
  which still preserves sorted order and stability isn't required by
  the problem.
- **Both lists empty (`null`)** — caught by the `list1 == null` check,
  which returns `list2` (also `null`).