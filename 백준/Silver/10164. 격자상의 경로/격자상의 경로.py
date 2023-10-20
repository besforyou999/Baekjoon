N, M, K = map(int, input().split())


def find(n, m):
    dp = [[0]*(m+1)] * (n+1)
    dp[1][1] = 1
    for i in range(1, n+1):
        for j in range(1, m+1):
            if i == 1 and j == 1:
                continue
            dp[i][j] = dp[i-1][j] + dp[i][j-1]

    return dp[n][m]


if K == 0:
    print(find(N, M))
else:
    n1 = (K - 1)// M + 1
    m1 = K - (n1 - 1) * M
    n2 = N - n1 + 1
    m2 = M - m1 + 1
    first = find(n1, m1)
    second = find(n2, m2)
    print(first * second)