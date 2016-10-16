# -*- coding: utf-8 -*-
"""
https://codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/

We draw N discs on a plane. The discs are numbered from 0 to N − 1. A zero-indexed array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0

There are eleven (unordered) pairs of discs that intersect, namely:

discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.
Write a function:

def solution(A)
that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2,147,483,647].
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
"""
def find_position_rec(value, A, left, right):
    if left >= right:
        return left

    mid = (left + right) / 2
    if A[mid] <= value < A[mid + 1]:
        return mid
    elif value < A[mid]:
        return find_position_rec(value, A, left, mid - 1)
    else:
        return find_position_rec(value, A, mid + 1, right)


def find_position(value, A):
    return find_position_rec(value, A, 0, len(A) - 1)


def solution(A):
    size = len(A)
    L = [i - A[i] for i in xrange(0, size)]
    L.sort()

    result = 0
    for i in xrange(0, size):
        value = i + A[i]
        position = find_position(value, L)
        result += position - i

    if result > 10000000:
        result = -1
    return result


import unittest

class TestSolution(unittest.TestCase):
    def test_find_position(self):
        L = [-4, -1, 0, 0, 2, 5]
        R = [1, 6, 4, 4, 8, 5]
        P = [3, 5, 4, 4, 5, 5]
        for i, value in enumerate(R):
            self.assertEquals(P[i], find_position(value, L))

    def test_solution(self):
        self.assertEquals(11, solution([1, 5, 2, 1, 4, 0]))
