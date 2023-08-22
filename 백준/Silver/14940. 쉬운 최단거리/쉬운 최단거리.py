import sys
input = sys.stdin.readline

from collections import deque

N, M = map(int, input().split())

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

visited = [[-1] * M for _ in range(N)]
graph = [list(map(int, input().split())) for _ in range(N)]


def bfs(r, c):
    queue = deque()
    queue.append((r, c))

    visited[r][c] = 0

    while queue:
        r, c = queue.popleft()

        for i in range(4):
            nr ,nc = r + dr[i], c + dc[i]

            if 0 <= nr < N and 0 <= nc < M and visited[nr][nc] == -1:
                if graph[nr][nc] == 0:
                    visited[nr][nc] = 0
                elif graph[nr][nc] == 1:
                    visited[nr][nc] = visited[r][c] + 1
                    queue.append((nr, nc))


for i in range(N):
    for j in range(M):
        if graph[i][j] == 2 and visited[i][j] == -1:
            bfs(i, j)


for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            print(0, end=' ')
        else:
            print(visited[i][j], end=' ')
    print()