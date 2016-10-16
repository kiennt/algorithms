# -*- coding: utf-8 -*-
"""
A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

Write a function:

int solution(int A[], int N);
that, given an array A consisting of N integers, returns the maximum sum of any slice of A.

For example, given array A such that:

A[0] = 3  A[1] = 2  A[2] = -6
A[3] = 4  A[4] = 0
the function should return 5 because:

(3, 4) is a slice of A that has sum 4,
(2, 2) is a slice of A that has sum −6,
(0, 1) is a slice of A that has sum 5,
no other slice of A has sum greater than (0, 1).
Assume that:

N is an integer within the range [1..1,000,000];
each element of array A is an integer within the range [−1,000,000..1,000,000];
the result will be an integer within the range [−2,147,483,648..2,147,483,647].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
"""
def build_prefix_sum(A):
    sum = 0
    for index, item in enumerate(A):
        sum += item
        A[index] = sum

def solution(A):
    size = len(A)
    build_prefix_sum(A)
    smax, smin = A[0], A[0]
    for index in xrange(1, size):
        item = A[index]
        smax = max(item, item - smin, smax)
        smin = min(item, smin)
    return smax


import unittest

class TestSolution(unittest.TestCase):
    def test_solution(self):
        self.assertEquals(
            5, solution([3, 2, -6, 4, 0]))
        self.assertEquals(
            -1, solution([-1, -2, -3, -4, -5]))
        self.assertEquals(
            6, solution([-1, -2, -3, -4, -5, 6]))
        self.assertEquals(
            21, solution([1, 2, 3, 4, 5, 6]))
        self.assertEquals(
            1, solution([-2, 1]))
