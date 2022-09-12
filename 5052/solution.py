import sys
input = sys.stdin.readline


class Node(object):
    def __init__(self, key, data=None):
        self.key = key
        self.data = data
        self.children = {}


class Trie:
    def __init__(self):
        self.head = Node(None)

    def insert(self, string):
        current_node = self.head

        for char in string:
            if char not in current_node.children:
                current_node.children[char] = Node(char)
            current_node = current_node.children[char]
        current_node.data = string

    def starts_with(self, prefix):
        current_node = self.head
        words = []

        for p in prefix:
            if p in current_node.children:
                current_node = current_node.children[p]
            else:
                return None

        current_node = [current_node]
        next_node = []
        while True:
            for node in current_node:
                if node.data:
                    words.append(node.data)
                next_node.extend(list(node.children.values()))
            if len(next_node) != 0:
                current_node = next_node
                next_node = []
            else:
                break

        return words


t = int(input())

for _ in range(t):
    trie = Trie()
    n = int(input())
    numbers = []
    for _ in range(n):
        num = input().rstrip()
        numbers.append(num)
        trie.insert(num)

    result = 0
    for num in numbers:
        if len(trie.starts_with(num)) > 1:
            result = 1
            break

    if result == 0:
        print("YES")
    elif result == 1:
        print("NO")

