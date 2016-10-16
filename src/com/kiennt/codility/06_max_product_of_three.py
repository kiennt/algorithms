# -*- coding: utf-8 -*-
"""
https://codility.com/programmers/lessons/6-sorting/max_product_of_three/

A non-empty zero-indexed array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
contains the following example triplets:

(0, 1, 2), product is −3 * 1 * 2 = −6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.

Write a function:

int solution(int A[], int N);
that, given a non-empty zero-indexed array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Assume that:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
"""
def find_min_with_index(array):
    min_result = 1000
    min_index = -1
    for index, item in enumerate(array):
        if item < min_result:
            min_result = item
            min_index = index
    return min_index, min_result


def find_mins(A, k):
    result = []
    array = A[:]  # copy array
    for i in xrange(k):
        index, value = find_min_with_index(array)
        result.append(value)
        array = array[:index] + array[index + 1:]
        if not array:
            break
    return result


def find_max_with_index(array):
    max_result = -1000
    max_index = -1
    for index, item in enumerate(array):
        if item > max_result:
            max_result = item
            max_index = index
    return max_index, max_result


def find_maxes(A, k):
    result = []
    array = A[:]  # copy array
    for i in xrange(k):
        index, value = find_max_with_index(array)
        result.append(value)
        array = array[:index] + array[index + 1:]
        if not array:
            break
    return result


def solution(A):
    pos = filter(lambda x: x > 0, A)
    neg = filter(lambda x: x < 0, A)
    zero = filter(lambda x: x == 0, A)

    len_pos = len(pos)
    len_neg = len(neg)
    len_zero = len(zero)

    if len_pos + len_neg < 3:
        return 0

    if len_pos >= 3:
        max_pos = find_maxes(pos, 3)
        value = max_pos[0] * max_pos[1] * max_pos[2]
        if len_neg >= 2:
            min_neg = find_mins(neg, 2)
            return max(value, max_pos[0] * min_neg[0] * min_neg[1])
        else:
            return value
    elif len_pos == 2:
        max_pos = find_maxes(pos, 3)
        if len_neg >= 2:
            min_neg = find_mins(neg, 2)
            return max_pos[0] * min_neg[0] * min_neg[1]
        elif len_zero:
            return 0
        else:
            return max_pos[0] * max_pos[1] * neg[0]
    elif len_pos == 1:
        min_neg = find_mins(neg, 2)
        return pos[0] * min_neg[0] * min_neg[1]
    elif len_zero:
        return 0
    else:
        n0, n1, n2 = find_maxes(neg, 3)
        return n0 * n1 * n2


import unittest

class TestSolution(unittest.TestCase):
    def test_solution(self):
        self.assertEquals(
            60, solution([-3, 1, 2, -2, 5, 6]))
        self.assertEquals(
            60, solution([-3, 1, 2, -2, -5, -6]))
        self.assertEquals(
            220, solution([1, 2, -10, -11, -1]))
        self.assertEquals(
            0, solution([1, 2, -2, 0]))
        self.assertEquals(
            -4, solution([1, 2, -2]))
        self.assertEquals(
            110, solution([1, -10, -11, -1]))
        self.assertEquals(
            -110, solution([-10, -11, -1]))
        self.assertEquals(
            0, solution([0, -10, -11, -1]))

    def test_find_maxes_find_mins(self):
        self.assertEquals(
            [6, 5, 2, 1, -2, -3],
            find_maxes([-3, 1, 2, -2, 5, 6], 6))
        self.assertEquals(
            [-3, -2, 1, 2, 5, 6],
            find_mins([-3, 1, 2, -2, 5, 6], 6))
