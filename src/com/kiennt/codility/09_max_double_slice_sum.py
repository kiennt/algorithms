# -*- coding: utf-8 -*-
"""
https://codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/start/

A non-empty zero-indexed array A consisting of N integers is given.

A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.

The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

For example, array A such that:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
contains the following example double slices:

double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
double slice (3, 4, 5), sum is 0.
The goal is to find the maximal sum of any double slice.

Write a function:

def solution(A)
that, given a non-empty zero-indexed array A consisting of N integers, returns the maximal sum of any double slice.

For example, given:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
the function should return 17, because no double slice of array A has a sum of greater than 17.

Assume that:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−10,000..10,000].
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

    if size == 3:
        return 0

    if size == 4:
        return max(A[1], A[2], 0)

    build_prefix_sum(A)
    minp = min(A[0], A[1])
    minyx = A[1]
    maxds = 0
    for i in xrange(2, size - 1):
        current_yx = A[i] - A[i - 1] + minp
        minyx = min(minyx, current_yx)
        current_ds = A[i] - minyx
        maxds = max(maxds, current_ds)
        minp = min(minp, A[i])
    return maxds

import unittest

class TestSolution(unittest.TestCase):
    def test_solution(self):
        self.assertEquals(
            17, solution([3, 2, 6, -1, 4, 5, -1, 2]))
        self.assertEquals(
            0, solution([3, 2, 6]))
        self.assertEquals(
            17, solution([5, 17, 0, 3]))
        self.assertEquals(
            29, solution([5, 17, 29, 3]))
        self.assertEquals(
            20, solution([5, 10, 10, 3, 40]))
        self.assertEquals(
            60, solution([5, 10, 10, 3, 40, 20]))
        self.assertEquals(
            0, solution([-1, -2, -3, -4]))
        self.assertEquals(
            26, solution([6, 1, 5, 6, 4, 2, 9, 4]))


"""
@huydx solution, easier to reasoning

class Solution {
    public int solution(int[] A) {
        if (A.length == 3) {
            return 0;
        }

        int n = A.length;

        int[] max_from_left = new int[n];
        int[] max_from_right = new int[n];
        for (int i = 1; i < (n-1); i++) {
            max_from_left[i] = max_from_left[i-1]+A[i] > 0 ? max_from_left[i-1]+A[i] : 0;
        }
        for (int i = n-2; i > 0; i--) {
            max_from_right[i] = max_from_right[i+1]+A[i] > 0 ? max_from_right[i+1]+A[i] : 0;
        }

        int max = 0;
        for (int i = 1; i < n-1; i++) {
            int slice_sum = max_from_left[i-1] + max_from_right[i+1];
            max = slice_sum > max ? slice_sum : max;
        }
        return max;
    }
}
"""
