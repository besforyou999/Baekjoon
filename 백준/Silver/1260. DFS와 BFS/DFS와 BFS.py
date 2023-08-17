import sys
input = sys.stdin.readline

from collections import deque

N, M, V = map(int, input().split())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(N+1):
    graph[i].sort()


def dfs(V):
    visited[V] = True
    print(V, end=' ')

    for i in graph[V]:
        if not visited[i]:
            dfs(i)


def bfs(V):
    queue = deque([V])
    visited[V] = True

    while queue:
        node = queue.popleft()

        print(node, end=' ')

        for i in graph[node]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


visited = [False] * (N + 1)

dfs(V)
print()
visited = [False for _ in range(N+1)]
bfs(V)