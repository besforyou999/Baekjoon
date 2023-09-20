import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [list(map(int, list(input().strip()))) for _ in range(N)]
dp = [[0] * M for _ in range(N)]

answer = 0
for r in range(N):
    for c in range(M):
        if r == 0 or c == 0:
            dp[r][c] = graph[r][c]
        elif graph[r][c] == 0:
            dp[r][c] = 0
        else:
            dp[r][c] = min(dp[r - 1][c - 1], dp[r - 1][c], dp[r][c - 1]) + 1
        answer = max(dp[r][c], answer)

print(answer * answer)