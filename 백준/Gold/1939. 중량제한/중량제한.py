import sys
from collections import deque
input = sys.stdin.readline
INF = 1000000000


def bfs(mid):
    visit = [False] * (N + 1)
    visit[A] = True
    queue = deque()
    queue.append(A)

    while queue:
        now = queue.popleft()
        if now == B:
            return True
        for nnode, ncost in graph[now]:
            if not visit[nnode] and ncost >= mid:
                visit[nnode] = True
                queue.append(nnode)

    return False


N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

for i in range(N + 1):
    graph[i].sort(reverse=True)

A, B = map(int, input().split())
left, right = 1, INF

while left <= right:
    mid = (left + right) // 2
    if bfs(mid):
        left = mid + 1
    else:
        right = mid - 1

print(right)