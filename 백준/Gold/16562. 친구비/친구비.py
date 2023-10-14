import sys
from collections import deque
input = sys.stdin.readline

N, M, k = map(int, input().split())
Ai = deque(map(int, input().split()))
root = [i for i in range(N + 1)]
Ai.appendleft('empty')


def find_root(a):
    if root[a] == a:
        return a
    root[a] = find_root(root[a])
    return root[a]


def union(a, b):
    a = find_root(a)
    b = find_root(b)
    if a > b:
        root[a] = b
    elif a < b:
        root[b] = a


for _ in range(M):
    a, b = map(int, input().split())
    union(a, b)

for i in range(1, N + 1):
    root[i] = find_root(root[i])

queue = []

for i in range(1, N + 1):
    r = root[i]
    cost = Ai[i]
    queue.append((r, cost))
    queue.sort(key=lambda x: (x[0], x[1]))

prev_root = queue[0][0]
total = queue[0][1]

for i in range(1, N):
    r, cost = queue[i]
    if prev_root == r:
        continue
    else:
        prev_root = r
        total += cost

    if total > k:
        print("Oh no")
        sys.exit(0)

print(total)