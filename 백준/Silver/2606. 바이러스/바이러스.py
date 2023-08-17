import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


visited = [False] * (N + 1)


def dfs(V):
    visited[V] = True

    for i in graph[V]:
        if not visited[i]:
            dfs(i)


dfs(1)

ans = 0

for i in range(N+1):
    if visited[i]:
        ans += 1

print(ans - 1)