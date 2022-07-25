from collections import deque

dx = [1, 2, 2, 1 ,-1, -2, -2, -1]
dy = [-2, -1, 1, 2, 2, 1, -1, -2]


def bfs(a, b, c, d):
    queue = deque()
    queue.append((a,b))

    while queue:
        curX, curY = queue.popleft()
        if curX == c and curY == d:
            print(board[curX][curY] - 1)
            return True

        for i in range(8):
            nx = curX + dx[i]
            ny = curY + dy[i]
            if nx < 0 or ny < 0 or nx >= I or ny >= I:
                continue
            if board[nx][ny] == 0:
                board[nx][ny] = board[curX][curY] + 1
                queue.append((nx, ny))

    return False

T = int(input())

for _ in range(T):
    I = int(input())
    x, y = map(int, input().split(' '))
    a, b = map(int, input().split(' '))

    board = [[0 for _ in range(I)] for _ in range(I)]
    board[x][y] = 1
    bfs(x, y, a, b)
