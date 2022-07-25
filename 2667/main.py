from collections import deque

# up down left right
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

N = int(input())
mat = [[0 for col in range(N)] for row in range(N)]
visited = [[False for col in range(N)] for row in range(N)]

for col in range(N):
    line = str(input())
    idx = 0
    for row in line:
        mat[col][idx] = int(row)
        idx += 1

def bfs(y,x):
    groups = 1
    queue = deque()
    queue.append((y, x))
    visited[y][x] = True

    while queue:
        y, x = queue.popleft()

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue

            if mat[ny][nx] == 0:
                continue

            if mat[ny][nx] == 1 and visited[ny][nx] is False:
                visited[ny][nx] = True
                groups += 1
                queue.append((ny, nx))

    return groups

groups = []

for col in range(N):
    for row in range(N):
        if mat[col][row] == 1 and visited[col][row] is False:
            num = bfs(col, row)
            groups.append(num)

print(len(groups))
groups.sort()
for houses in groups:
    print(houses)
