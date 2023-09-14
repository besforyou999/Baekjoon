import sys
input = sys.stdin.readline
R, C, Q = map(int, input().split())

graph = [[0] * (C + 1) for _ in range(R + 1)]
dp = [[0] * (C + 1) for _ in range(R + 1)]

for r in range(1, R + 1):
    line = list(map(int, input().split()))
    for c in range(1, C + 1):
        graph[r][c] = line[c - 1]

for r in range(1, R + 1):
    for c in range(1, C + 1):
        dp[r][c] = graph[r][c] + dp[r - 1][c] + dp[r][c - 1] - dp[r - 1][c - 1]

for _ in range(Q):
    r1, c1, r2, c2 = map(int, input().split())
    size = int((r2 - r1 + 1) * (c2 - c1 + 1))
    light = dp[r2][c2] - dp[r1 - 1][c2] - dp[r2][c1 - 1] + dp[r1 - 1][c1 - 1]
    print(light // size)