class Node(object):

    def __init__(self, key, value, next=None, prev=None):
        self.key = key
        self.value = value
        self.set_next(next)
        self.set_prev(prev)

    def set_next(self, next):
        if next is None:
            self.next = None
        else:
            next.prev = self
            self.next = next

    def set_prev(self, prev):
        if prev is None:
            self.prev = None
        else:
            prev.next = self
            self.prev = prev


class LRUCache(object):

    def __init__(self, capacity):
        assert capacity > 0, 'Can not init cache with capacity is 0'
        self.capacity = capacity
        self.queue_size = 0
        self.cache = {}
        self.head = None
        self.tail = None

    def remove_head(self):
        next_head = self.head.next
        if next_head:
            next_head.prev = None

        self.head.next = self.head.prev = None
        del self.cache[self.head.key]

        self.head = next_head

    def set_tail(self, node):
        if self.tail is None:
            self.tail = node
        else:
            node.set_prev(self.tail)
            self.tail = node

        if self.head is None:
            self.head = node

    def push_to_end(self, node):
        if self.queue_size == self.capacity:
            self.remove_head()
        else:
            self.queue_size += 1
        self.set_tail(node)

    def link_nodes_before_and_after(self, node):
        if node.prev:
            node.prev.set_next(node.next)
        elif node.next:
            # in this case node is head
            node.next.set_prev(None)
            self.head = node.next

    def move_to_end(self, node):
        if node == self.tail:
            return

        self.link_nodes_before_and_after(node)
        self.set_tail(node)
        node.next = None

    def get(self, key):
        node = self.cache.get(key)
        if node is None:
            return None
        else:
            self.move_to_end(node)
            return node.value

    def set(self, key, value):
        node = self.cache.get(key)
        if node is None:
            node = Node(key, value)
            self.push_to_end(node)
            self.cache[key] = node
        else:
            self.move_to_end(node)


if __name__ == '__main__':
    cache_size = 10000
    num_size = 10000
    c = LRUCache(cache_size)
    for i in xrange(num_size):
        c.set(i, i)
    for i in xrange(num_size):
        print c.get(i)
