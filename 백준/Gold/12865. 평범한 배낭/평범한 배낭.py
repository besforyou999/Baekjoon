import sys

N, K = map(int, sys.stdin.readline().split())

weight = ['empty']
value = ['empty']

for _ in range(N):
    w, v = map(int, sys.stdin.readline().split())
    weight.append(w)
    value.append(v)

dp = [[0] * (K + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, K + 1):
        if j < weight[i]:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j - weight[i]] + value[i])

print(dp[N][K])