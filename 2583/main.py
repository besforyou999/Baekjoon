from collections import deque

# up down left right
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

# read m, n, k
h, w, k = map(int, input().split(' '))

board = [[0 for _ in range(w)] for _ in range(h)]

# read coords of squares
for _ in range(k):
    x, y, a, b = map(int, input().split(' '))
    for i in range(y, b):
        for j in range(x, a):
            board[i][j] = 1


def bfs(x, y):
    area = 1
    queue = deque()
    queue.append((x, y))
    board[y][x] = 1

    while queue:
        curx, cury = queue.popleft()
        for i in range(4):
            newx = curx + dx[i]
            newy = cury + dy[i]
            if newx < 0 or newy < 0 or newx >= w or newy >= h:
                continue
            if board[newy][newx] == 0:
                area += 1
                board[newy][newx] = 1
                queue.append((newx, newy))

    return area


areas = []

for i in range(h):
    for j in range(w):
        if board[i][j] == 0:
            area = bfs(j, i)
            areas.append(area)

areas.sort()
print(len(areas))
for i in areas:
    print(i, end=' ')

