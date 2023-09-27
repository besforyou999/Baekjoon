import sys
input = sys.stdin.readline

N, K = map(int, input().split())
edges = [list(map(int, sys.stdin.readline().split())) for _ in range(K)]
graph = [[sys.maxsize] * N for _ in range(N)]

for a, b in edges:
    graph[a - 1][b - 1] = graph[b - 1][a - 1] = 1

for v in range(N):
    graph[v][v] = 0

for k in range(N):
    for i in range(N):
        for j in range(N):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

for i in range(N):
    for j in range(N):
        if graph[i][j] > 6:
            print("Big World!")
            sys.exit(0)

print("Small World!")