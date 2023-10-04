import sys
input = sys.stdin.readline

def knapsack(W, wt, val, n):
    dp = [[0 for _ in range(W+1)] for _ in range(n+1)]
    for i in range(n + 1):
        for w in range(W + 1):
            if i == 0 or w == 0:
                dp[i][w] = 0
            elif wt[i-1] <= w:
                dp[i][w] = max(dp[i-1][w], val[i-1] + dp[i-1][w-wt[i-1]])
            else:
                dp[i][w] = dp[i-1][w]

    return dp[n][w]


N, K = map(int, input().split())

item_weight = []
values = []

for _ in range(N):
    i, v = map(int, input().split())
    item_weight.append(i)
    values.append(v)

print(knapsack(K, item_weight, values, N))