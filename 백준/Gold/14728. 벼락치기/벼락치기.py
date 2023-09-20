N, T = map(int, input().split())

elements = []
for _ in range(N):
    k, s = map(int, input().split())
    elements.append((k, s))

dp = [[0] * (T + 1) for _ in range(N + 1)]

for n in range(1, N + 1):
    time, score = elements[n - 1]
    for t in range(1, T + 1):
        if t >= time:
            dp[n][t] = max(dp[n - 1][t - time] + score, dp[n - 1][t])
        else:
            dp[n][t] = dp[n - 1][t]

print(dp[N][T])