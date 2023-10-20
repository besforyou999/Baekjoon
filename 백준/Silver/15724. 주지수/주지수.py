import sys
input = sys.stdin.readline

N, M = map(int, input().split())

matrix = []

for _ in range(N):
    matrix.append(list(map(int, input().split())))

dp = [[0] * (M+1) for _ in range(N+1)]

for r in range(1, N + 1):
    for c in range(1, M + 1):
        dp[r][c] = dp[r-1][c] + dp[r][c-1] - dp[r-1][c-1] + matrix[r-1][c-1]

K = int(input())

for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())
    area1 = dp[x2][y2] # 가장 큰 영역
    area2 = dp[x1 - 1][y1 - 1] # 더 할 작은 영역
    area3 = dp[x1 - 1][y2] # 뺄 영역 1
    area4 = dp[x2][y1 - 1]
    print(area1 + area2 - area3 - area4)