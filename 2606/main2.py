from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

graph = [[0 for _ in range(N + 1)] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split(' '))
    graph[a][b] = graph[b][a] = 1


def bfs(node):
    count = 0
    visited = [node]
    queue = deque()
    queue.append(node)

    while queue:
        v = queue.popleft()
        for i in range(1, N+1):
            if graph[v][i] == 1 and (i not in visited):
                visited.append(i)
                queue.append(i)
                count += 1

    return count


print(bfs(1))

