N = int(input())

Ai = list(map(int, input().split()))
Ai.insert(0, 0)

dp = [1] * (N + 1)

for i in range(1, N + 1):
    for j in range(1, i):
        if Ai[i] > Ai[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))