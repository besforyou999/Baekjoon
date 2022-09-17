import sys
input = sys.stdin.readline

N = int(input())

ans = 0
board = [0 for _ in range(16)]


def isPromising(idx):
    for i in range(idx):
        if board[i] == board[idx] or abs(board[i] - board[idx]) == abs(idx - i):
            return False
    return True


def nqueens(x):
    global ans
    if x == N:
        ans += 1
        return
    else:
        for i in range(N):
            board[x] = i
            if isPromising(x):
                nqueens(x + 1)

nqueens(0)
print(ans)

