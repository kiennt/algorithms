def min_distance(c1, c2):
    dis = abs(ord(c2) - ord(c1))
    return min(dis, 26 - dis)

def solution(word):
    sum = 0
    current_char = 'a'
    for char in word:
        d = min_distance(current_char, char)
        current_char = char
        sum += d

    return sum



if __name__ == '__main__':
    word = raw_input()
    print solution(word)


import unittest

class TestSolution(unittest.TestCase):

    def test_solution1(self):
        self.assertEquals(18, solution('zeus'))

    def test_solution1(self):
        self.assertEquals(35, solution('map'))

    def test_solution1(self):
        self.assertEquals(34, solution('ares'))
