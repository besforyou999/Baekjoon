import sys
input = sys.stdin.readline

dp = [1, 2, 4, 7]

for i in range(4, 12):
    dp.append(dp[i-1] + dp[i-2] + dp[i-3])

T = int(input())

for _ in range(T):
    N = int(input())
    print(dp[N-1])

