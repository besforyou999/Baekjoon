import sys

sys.setrecursionlimit(10 ** 9)
k = int(sys.stdin.readline())

inorder = list(map(int, sys.stdin.readline().split()))
trees = [[] for _ in range(k)]


def tree(order, depth):
    length = len(order)
    if length == 1:
        trees[depth].append(order[0])
        return

    mid = length // 2
    trees[depth].append(order[mid])
    tree(order[:mid], depth + 1)
    tree(order[mid + 1:], depth + 1)


tree(inorder, 0)

for arr in trees:
    for item in arr:
        print(item, end=' ')
    print()
