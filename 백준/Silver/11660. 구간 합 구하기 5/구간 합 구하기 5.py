import sys
input = sys.stdin.readline

N, M = map(int, input().split())

graph = [[0] * (N + 1) for _ in range(N + 1)]
dp = [[0] * (N + 1) for _ in range(N + 1)]

for row in range(1, N + 1):
    line = list(map(int, input().split()))
    for col in range(1, N + 1):
        graph[row][col] = line[col - 1]

for r in range(1, N + 1):
    for c in range(1, N + 1):
        dp[r][c] = graph[r][c] + dp[r - 1][c] + dp[r][c - 1] - dp[r - 1][c - 1]

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    print(dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1])