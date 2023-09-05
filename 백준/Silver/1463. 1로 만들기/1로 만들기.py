import sys

N = int(input())

if N == 1:
    print(0)
    sys.exit(0)
elif N == 2 or N == 3:
    print(1)
    sys.exit(0)

dp = [1000000000] * (N + 1)

dp[1] = 0
dp[2] = 1
dp[3] = 1

for i in range(1, N + 1):
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i // 2] + 1)

    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i // 3] + 1)

    dp[i] = min(dp[i], dp[i-1] + 1)

print(dp[N])