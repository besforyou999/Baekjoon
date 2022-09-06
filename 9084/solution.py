import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())    # 동전 가지 수
    coin_values = list(map(int, input().split())) # 동전의 각 가치
    M = int(input())    # 만들어야할 금액

    dp = [0] * (M + 1)
    dp[0] = 1

    for coin in coin_values:
        for i in range(M + 1):
            if i >= coin:
                dp[i] += dp[i - coin]

    print(dp[M])

