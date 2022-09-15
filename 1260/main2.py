from collections import deque
import sys
input = sys.stdin.readline

N, M, V = map(int, input().split())
graph = [[0 for _ in range(N+1)] for _ in range(N+1)]
visited = [False for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1


def dfs(node):
    visited[node] = True
    print(node, end=' ')
    for i in range(1, N + 1):
        if graph[node][i] == 1 and visited[i] is False:
            dfs(i)


def bfs(node):
    visit = [node]
    queue = deque()
    queue.append(node)

    while queue:
        q = queue.popleft()
        print(q, end=' ')

        for i in range(1, N + 1):
            if graph[q][i] == 1 and (i not in visit):
                visit.append(i)
                queue.append(i)


dfs(V)
print()
bfs(V)

