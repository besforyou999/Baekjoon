from sys import maxsize

n, k = map(int, input().split())
arr = [[maxsize] * (n + 1) for _ in range(n + 1)]

for _ in range(k):
    a, b = map(int, input().split())
    arr[a][b] = 1

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if arr[i][k] + arr[k][j] == 2:
                arr[i][j] = 1

s = int(input())
for _ in range(s):
    x, y = map(int, input().split())
    if arr[x][y] == 1:
        print(-1)
    elif arr[y][x] == 1:
        print(1)
    else:
        print(0)