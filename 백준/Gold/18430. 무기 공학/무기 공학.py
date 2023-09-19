import sys

N, M = map(int, input().split())
if N * M <= 4:
    print(0)
    sys.exit(0)


board = [list(map(int, input().split())) for _ in range(N)]
visit = [[False] * M for _ in range(N)]
ans = -1


def is_in(y, x):
    return 0 <= y < N and 0 <= x < M


def dfs(r, c, cost):
    if c >= M:
        c = 0
        r += 1

    global ans
    if r >= N:
        ans = max(ans, cost)
        return

    # type 1
    if is_in(r, c - 1) and is_in(r, c) and is_in(r + 1, c):
        if not visit[r][c - 1] and not visit[r][c] and not visit[r + 1][c]:
            visit[r][c - 1] = visit[r][c] = visit[r + 1][c] = True
            boom = board[r][c] * 2 + board[r][c - 1] + board[r + 1][c]
            dfs(r, c + 1, cost + boom)
            visit[r][c - 1] = visit[r][c] = visit[r + 1][c] = False

    # type 2
    if is_in(r - 1, c) and is_in(r, c) and is_in(r, c - 1):
        if not visit[r - 1][c] and not visit[r][c] and not visit[r][c - 1]:
            visit[r - 1][c] = visit[r][c] = visit[r][c - 1] = True
            boom = board[r][c] * 2 + board[r][c - 1] + board[r - 1][c]
            dfs(r, c + 1, cost + boom)
            visit[r - 1][c] = visit[r][c] = visit[r][c - 1] = False

    # type 3
    if is_in(r - 1, c) and is_in(r, c) and is_in(r, c + 1):
        if not visit[r - 1][c] and not visit[r][c] and not visit[r][c + 1]:
            visit[r - 1][c] = visit[r][c] = visit[r][c + 1] = True
            boom = board[r][c] * 2 + board[r - 1][c] + board[r][c + 1]
            dfs(r, c + 1, cost + boom)
            visit[r - 1][c] = visit[r][c] = visit[r][c + 1] = False

    # type 4
    if is_in(r + 1, c) and is_in(r, c) and is_in(r, c + 1):
        if not visit[r + 1][c] and not visit[r][c] and not visit[r][c + 1]:
            visit[r + 1][c] = visit[r][c] = visit[r][c + 1] = True
            boom = board[r][c] * 2 + board[r + 1][c] + board[r][c + 1]
            dfs(r, c + 1, cost + boom)
            visit[r + 1][c] = visit[r][c] = visit[r][c + 1] = False

    dfs(r, c + 1, cost)


dfs(0, 0, 0)
print(ans)