from sys import stdin
import heapq

n, m = map(int, stdin.readline().split())

answer = []
graph = [[] for _ in range(n+1)]
inDegree = [0 for _ in range(n+1)]
queue = []

for i in range(m):
    first, second = map(int, stdin.readline().split())
    graph[first].append(second)
    inDegree[second] += 1

for i in range(1, n + 1):
    if inDegree[i] == 0:
        heapq.heappush(queue, i)

while queue:
    next = heapq.heappop(queue)
    answer.append(next)
    for i in graph[next]:
        inDegree[i] -= 1
        if inDegree[i] == 0:
            heapq.heappush(queue, i)

print(" ".join(map(str, answer)))