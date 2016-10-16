class Node(object):

    def __init__(self, value):
        self.value = value
        self.min_value = None
        self.next = None

    def set_next(self, next):
        if next is not None:
            self.min_value = min(self.value, next.min_value)
        self.next = next


class MinStack(object):

    def __init__(self):
        self.head = None

    def is_empty(self):
        return self.head is None

    def push(self, value):
        node = Node(value)
        if self.head is None:
            node.min_value = value
        else:
            node.set_next(self.head)
        self.head = node

    def pop(self):
        if self.head is None:
            raise Exception
        old_head = self.head
        self.head = old_head.next
        return old_head.value

    def min(self):
        if self.head is None:
            raise Exception
        return self.head.min_value


class MinQueue(object):

    def __init__(self):
        self.stack1 = MinStack()
        self.stack2 = MinStack()

    def enqueue(self, value):
        self.stack1.push(value)

    def dequeue(self):
        if self.stack2.is_empty():
            while not self.stack1.is_empty():
                value = self.stack1.pop()
                self.stack2.push(value)

        if self.stack2.is_empty():
            raise Exception

        return self.stack2.pop()

    def min(self):
        is_empty1 = self.stack1.is_empty()
        is_empty2 = self.stack2.is_empty()
        if is_empty1 and is_empty2:
            raise Exception
        if is_empty1:
            return self.stack2.min()
        elif is_empty2:
            return self.stack1.min()
        return min(self.stack1.min(), self.stack2.min())


if __name__ == '__main__':
    a = [2, 3, 4, 5, 1]
    q = MinQueue()
    for i in xrange(0, len(a)):
        q.enqueue(a[i])
        print q.min()
    for i in xrange(0, len(a) - 1):
        q.dequeue()
        print q.min()
