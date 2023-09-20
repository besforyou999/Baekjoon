import sys
input = sys.stdin.readline

n = int(input())
graph = [[0] * (n + 1) for _ in range(n + 1)]
dp = [[0] * (n + 1) for _ in range(n + 1)]

for r in range(1, n + 1):
    line = list(map(int, input().split()))
    for c in range(1, r + 1):
        graph[r][c] = line[c - 1]


dp[1][1] = graph[1][1]

for r in range(1, n + 1):
    for c in range(1, r + 1):
        if c == 1:
            dp[r][c] = dp[r - 1][c]
        elif c == r:
            dp[r][c] = dp[r - 1][c - 1]
        else:
            dp[r][c] = max(dp[r - 1][c], dp[r - 1][c - 1])

        dp[r][c] += graph[r][c]


ans = -1

for c in range(1, n + 1):
    ans = max(ans, dp[n][c])

print(ans)