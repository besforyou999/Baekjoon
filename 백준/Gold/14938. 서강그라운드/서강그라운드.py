import sys
input = sys.stdin.readline

n, m, r = map(int, input().split())
items = list(map(int, input().split()))
items.insert(0, 0)

MAX = 1e9
graph = [[MAX] * (n + 1) for _ in range(n+1)]

for _ in range(r):
    a, b, I = map(int, input().split())
    graph[a][b] = graph[b][a] = I

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if i == j:
                graph[i][j] = 0
            elif graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

answer = -1

for start in range(1, n + 1):
    itemCnt = 0
    for j in range(1, n + 1):
        if graph[start][j] <= m:
            itemCnt += items[j]
    answer = max(answer, itemCnt)

print(answer)