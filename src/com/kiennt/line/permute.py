# write a function permute
# take an array a, and return all permutation of a
# and do not use recursive
def permutation(a):
    size = len(a)
    if size == 1:
        yield a
    else:
        for p in permutation(a[1:]):
            for i in xrange(0, size):
                yield p[:i] + a[0:1] + p[i:]


def permutation(a):
    [1 2 3 4]
    [1 2 4 3]
    [1 3 2 4]
    [1 3 4 2]
    [1 4 2 3]
    [1 4 3 2]
