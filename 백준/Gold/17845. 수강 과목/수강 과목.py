import sys
input = sys.stdin.readline

N, K = map(int, input().split())
dp = [[0] * (N + 1) for _ in range(K + 1)]

lectures = ['empty']
for _ in range(K):
    lectures.append((tuple(map(int, input().split()))))

# print(lectures)

for k in range(1, K + 1):
    imp, time = lectures[k]
    for n in range(1, N + 1):
        if time > n:
            dp[k][n] = dp[k - 1][n]
        else:
            dp[k][n] = max(dp[k - 1][n], dp[k - 1][n - time] + imp)

print(dp[K][N])