import sys
input = sys.stdin.readline

INF = int(1e10)

n, m = map(int, input().split())
graph = [[INF] * (n+1) for _ in range(n+1)]
first = [[0] * (n+1) for _ in range(n+1)]

for _ in range(m):
    a, b, w = map(int, input().split())
    graph[a][b] = graph[b][a] = w
    first[a][b] = b
    first[b][a] = a

for i in range(n+1):
    for j in range(n+1):
        if i == j:
            graph[i][j] = 0

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if i == j:
                continue
            if graph[i][k] + graph[k][j] < graph[i][j]:
                graph[i][j] = graph[i][k] + graph[k][j]
                first[i][j] = first[i][k]

ans = ''

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if i == j:
            ans += '-'
        else:
            ans += str(first[i][j])
        ans += ' '
    ans += "\n"

print(ans)