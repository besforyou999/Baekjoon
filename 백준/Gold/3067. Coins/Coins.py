T = int(input())

for _ in range(T):
    N = int(input()) # 동전 가지 수
    costs = list(map(int, input().split())) # 동전의 각 금액
    M = int(input()) # 만들어야할 금액

    dp = [0] * (M + 1)
    dp[0] = 1

    for i in range(N):
        for j in range(costs[i], M + 1):
            dp[j] += dp[j -costs[i]]

    print(dp[M])