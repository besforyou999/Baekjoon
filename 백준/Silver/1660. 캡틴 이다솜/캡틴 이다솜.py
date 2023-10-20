N = int(input())

balls = [1]
tmp = 1
floor = 1

while tmp <= N:
    floor += 1
    tmp += (floor * (floor + 1)) // 2
    balls.append(tmp)

INF = int(1e10)
dp = [INF] * (N+1)

for i in range(1, N + 1):
    for b in balls:
        if b == i:
            dp[i] = 1
            break
        elif b > i:
            break

        dp[i] = min(dp[i], dp[i-b] + 1)

print(dp[N])