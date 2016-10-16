# -*- coding: utf-8 -*-
"""
https://codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/

Solution to this task can be found at our blog.

You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by a zero-indexed array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:

def solution(H)
that, given a zero-indexed array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:

  H[0] = 8    H[1] = 8    H[2] = 5
  H[3] = 7    H[4] = 9    H[5] = 8
  H[6] = 7    H[7] = 4    H[8] = 8
the function should return 7. The figure shows one possible arrangement of seven blocks.


Assume that:

N is an integer within the range [1..100,000];
each element of array H is an integer within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

"""
def solution(A):
    count = 0
    stack = []

    for item  in A:
        while stack and stack[-1] > item:
            stack.pop()
        if not stack or stack[-1] < item:
            stack.append(item)
            count += 1

    return count



def test_solution():
    assert 7 == solution([8, 8, 5, 7, 9, 8, 7, 4, 8])
    assert 1 == solution([1])
    assert 1 == solution([8, 8, 8, 8])
    assert 4 == solution([1, 2, 3, 4])
