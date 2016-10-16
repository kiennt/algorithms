# -*- coding: utf-8 -*-
"""
https://codility.com/programmers/lessons/2-arrays/cyclic_rotation/

A zero-indexed array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is also moved to the first place.

For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]. The goal is to rotate array A K times; that is, each element of A will be shifted to the right by K indexes.

Write a function:

def solution(A, K)

that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3, 8].

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
"""
def reverse(a, start, end):
    for i in xrange(0, (end - start) // 2):
        i1, i2 = start + i, end - i - 1
        a[i1], a[i2] = a[i2], a[i1]

def rotate(a, k):
    if k == 0:
        return a
    size = len(a)
    reverse(a, 0, k)
    reverse(a, k, size)
    reverse(a, 0, size)
    return a

def solution(A, K):
    N = len(A)
    if N == 0:
        return A

    K = K % N
    if K == 0:
        return A
    return rotate(A, N - K)


import unittest

class TestSolution(unittest.TestCase):

    def test_rotate_array(self):
        self.assertListEqual([2, 3, 4, 5, 1], rotate([1, 2, 3, 4, 5], 1))
        self.assertListEqual([3, 4, 5, 1, 2], rotate([1, 2, 3, 4, 5], 2))
        self.assertListEqual([4, 5, 1, 2, 3], rotate([1, 2, 3, 4, 5], 3))
        self.assertListEqual([5, 1, 2, 3, 4], rotate([1, 2, 3, 4, 5], 4))
        self.assertListEqual([1, 2, 3, 4, 5], rotate([1, 2, 3, 4, 5], 5))

    def test_solution(self):
        self.assertListEqual(
            [],
            solution([], 10))
        self.assertListEqual(
            [6, 3, 8, 9, 7],
            solution([3, 8, 9, 7, 6], 1))
        self.assertListEqual(
            [7, 6, 3, 8, 9],
            solution([3, 8, 9, 7, 6], 2))
        self.assertListEqual(
            [9, 7, 6, 3, 8],
            solution([3, 8, 9, 7, 6], 3))
        self.assertListEqual(
            [8, 9, 7, 6, 3],
            solution([3, 8, 9, 7, 6], 4))
        self.assertListEqual(
            [3, 8, 9, 7, 6],
            solution([3, 8, 9, 7, 6], 5))
        self.assertListEqual(
            [6, 3, 8, 9, 7],
            solution([3, 8, 9, 7, 6], 6))
