import sys

board = [list(map(int, input().split())) for _ in range(9)]


def dfs(row, col):
    if col == 9:
        dfs(row + 1, 0)
        return

    if row == 9:
        for r in range(9):
            for c in range(9):
                print(board[r][c], end=' ')
            print()
        sys.exit(0)

    if board[row][col] == 0:
        for i in range(1, 10):
            if valid(row, col, i):
                board[row][col] = i
                dfs(row, col + 1)

        board[row][col] = 0
        return

    dfs(row, col + 1)


def valid(r, c, val):
    # 가로, 세로 확인
    for i in range(9):
        if board[r][i] == val or board[i][c] == val:
            return False

    r = (r // 3) * 3
    c = (c // 3) * 3

    for i in range(r, r + 3):
        for j in range(c, c + 3):
            if board[i][j] == val:
                return False

    return True


dfs(0, 0)