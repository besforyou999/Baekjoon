import sys
input = sys.stdin.readline

N = int(input())

color_cost = [[0 for _ in range(3)] for _ in range(1001)]
dp = [[0 for _ in range(3)] for _ in range(1001)]

for i in range(N):
    r, g, b = map(int, input().split())
    color_cost[i][0] = r
    color_cost[i][1] = g
    color_cost[i][2] = b

dp[0][0] = color_cost[0][0]
dp[0][1] = color_cost[0][1]
dp[0][2] = color_cost[0][2]

for i in range(N):
    dp[i][0] = color_cost[i][0] + min(dp[i-1][1], dp[i-1][2])
    dp[i][1] = color_cost[i][1] + min(dp[i-1][0], dp[i-1][2])
    dp[i][2] = color_cost[i][2] + min(dp[i-1][0], dp[i-1][1])

answer = sys.maxsize

for i in range(3):
    if dp[N-1][i] < answer:
        answer = dp[N - 1][i]

print(answer)

