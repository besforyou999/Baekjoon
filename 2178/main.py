from collections import deque

# read N, M
N, M = map(int, input().split())
mat = [[0 for col in range(N)] for row in range(M)]

graph = []

for _ in range(N):
    graph.append(list(map(int, input())))


def bfs(y, x):
    # up down left right
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    queue = deque()
    queue.append((y, x))

    while queue:
        y, x = queue.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if nx < 0 or ny < 0 or nx >= M or ny >= N:
                continue

            if graph[ny][nx] == 0:
                continue

            if graph[ny][nx] == 1:
                graph[ny][nx] = graph[y][x] + 1
                queue.append((ny,nx))

    return graph[N-1][M-1]

print(bfs(0, 0))
