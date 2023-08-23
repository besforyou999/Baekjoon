import sys
input = sys.stdin.readline

N = int(input())
MAX = 1e9

graph = [[MAX] * (N+1) for _ in range(N+1)]

while True:
    a, b = map(int, input().split())
    if a == -1 and b == -1:
        break
    graph[a][b] = graph[b][a] = 1


for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            if i == j:
                graph[i][j] = 0
            elif graph[i][j] > graph[i][k] + graph[k][j]:
                graph[i][j] = graph[i][k] + graph[k][j]


dp = [MAX] * (N + 1)
best = MAX

for i in range(1, N + 1):
    score = 0
    for j in range(1, N + 1):
        if graph[i][j] != MAX:
            score = max(score, graph[i][j])
    dp[i] = score
    best = min(best, score)


candidates = []
for i in range(1, N + 1):
    if dp[i] == best:
        candidates.append(i)

print(str(best) + ' ' + str(len(candidates)))
candidates.sort()
for i in candidates:
    print(i, end=' ')