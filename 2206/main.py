from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split(' '))
graph = []
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for _ in range(N):
    row = list(str(input().rstrip()))
    graph.append(list(map(int, row)))

visited = [[[0] * 2 for _ in range(M)] for _ in range(N)]


def bfs():
    queue = deque()
    queue.append([0, 0, 0])
    visited[0][0][0] = 1

    while queue:
        y, x, w = queue.popleft()

        if y == N - 1 and x == M - 1:
            return visited[y][x][w]

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if 0 <= ny < N and 0 <= nx < M:
                if graph[ny][nx] == 0 and visited[ny][nx][w] == 0:
                    visited[ny][nx][w] = visited[y][x][w] + 1
                    queue.append((ny, nx, w))
                elif graph[ny][nx] == 1 and w == 0:
                    visited[ny][nx][w + 1] = visited[y][x][w] + 1
                    queue.append((ny, nx, w + 1))

    return -1


print(bfs())

