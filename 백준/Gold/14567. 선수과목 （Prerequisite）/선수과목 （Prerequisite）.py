import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())

graph = [[] for _ in range(N + 1)]
degree = [0] * (N + 1)

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    degree[b] += 1

queue = deque()
result = [0] * (N + 1)

for i in range(1, N + 1):
    if degree[i] == 0:
        queue.append(i)

loop = 1
while queue:
    for i in queue:
        result[i] = loop

    size = len(queue)

    for _ in range(size):
        i = queue.popleft()
        for j in graph[i]:
            degree[j] -= 1
            if degree[j] == 0:
                queue.append(j)
    loop += 1

result.pop(0)
print(*result)