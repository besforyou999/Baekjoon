from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split(' '))
graph = [[0 for _ in range(M+1)] for _ in range(N+1)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for row in range(1, N + 1):
    line = input().rstrip()
    for col in range(1, M + 1):
        graph[row][col] = int(line[col - 1])


def bfs(row, col):
    visited = [(row, col)]
    matrix = [[0 for _ in range(M+1)] for _ in range(N+1)]
    matrix[row][col] = 1

    queue = deque()
    queue.append((row, col))

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if nx < 1 or ny < 1 or nx > M or ny > N:
                continue
            if (ny, nx) in visited:
                continue
            if graph[ny][nx] == 0:
                continue

            matrix[ny][nx] = matrix[y][x] + 1
            visited.append((ny, nx))
            queue.append((ny, nx))

    return matrix[N][M]


print(bfs(1, 1))

