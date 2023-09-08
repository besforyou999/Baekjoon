import sys
from collections import deque


def pour(a, b):
    if not visit[a][b]:
        visit[a][b] = True
        queue.append((a, b))


def bfs():
    while queue:

        a, b = queue.pop()
        c = C - a - b
        if a == 0:
            answer.append(c)

        # a -> b
        water = min(a, B - b)
        pour(a - water, b + water)
        # a -> c
        water = min(a, C - c)
        pour(a - water, b)
        # b -> a
        water = min(b, A - a)
        pour(a + water, b - water)
        # b -> c
        water = min(b, C - c)
        pour(a, b - water)
        # c -> a
        water = min(c, A - a)
        pour(a + water, b)
        # c -> b
        water = min(c, B - b)
        pour(a, b + water)


A, B, C = map(int, input().split())
visit = [[False] * (B + 1) for _ in range(A + 1)]
visit[0][0] = True

queue = deque()
queue.append((0, 0))

answer = []

bfs()

answer.sort()
print(*answer)