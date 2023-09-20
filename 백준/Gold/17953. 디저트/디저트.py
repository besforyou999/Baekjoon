N, M = map(int, input().split())
data = []
for _ in range(M):
    data.append(list(map(int, input().split())))

dp = [[0] * N for _ in range(M)]

for i in range(M):
    dp[i][0] = data[i][0]

for week in range(1, N):
    for desert in range(M):
        for j in range(M):
            if desert != j:
                dp[desert][week] = max(dp[desert][week], dp[j][week - 1] + data[desert][week])
            else:
                dp[desert][week] = max(dp[desert][week], dp[j][week - 1] + data[desert][week] // 2)

ans = -1
for i in range(M):
    ans = max(ans, dp[i][N - 1])

print(ans)