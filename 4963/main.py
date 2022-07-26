from collections import deque

# 0 0 -> left top
# up down left right (right up) (right, down) (left down) (left up)
dx = [0, 0, -1, 1, 1, 1, -1, -1]
dy = [-1, 1, 0, 0, -1, 1, 1, -1]

def bfs(board, x, y):
    queue = deque()
    queue.append((x,y))
    board[y][x] = 0

    while queue:
        cur_x, cur_y = queue.popleft()
        for i in range(8):
            new_x = cur_x + dx[i]
            new_y = cur_y + dy[i]

            if new_x >= 0 and new_y >= 0 and new_x < w and new_y < h:
                if board[new_y][new_x] == 1:
                    board[new_y][new_x] = 0
                    queue.append((new_x, new_y))

while True:
    w, h = map(int, input().split(' '))
    if w == 0 and h == 0:
        break;

    board = [[0 for _ in range(w)] for _ in range(h)]

    for i in range(h):
        line = list(map(int, input().split(' ')))
        for j in range(w):
            board[i][j] = line[j]

    island = 0

    for i in range(h):
        for j in range(w):
            if board[i][j] == 1:
                bfs(board, j, i)
                island += 1

    print(island)
