import sys
input = sys.stdin.readline

MAX = 1e9


def Floyd():
    for mid in range(0, n):
        for s in range(0, n):
            for e in range(0, n):
                if s == e:
                    graph[s][e] = 0
                elif graph[s][e] > graph[s][mid] + graph[mid][e]:
                    graph[s][e] = graph[s][mid] + graph[mid][e]


n = int(input())
m = int(input())
graph = [[MAX for _ in range(n)] for _ in range(n)]

Init()
for i in range(m):
    x, y, c = map(int, input().split())
    graph[x-1][y-1] = min(c, graph[x-1][y-1])

Floyd()

answer = ""

for i in range(n):
    for j in range(n):
        if graph[i][j] == MAX:
            print(0, end=' ')
        else:
            print(graph[i][j], end=' ')
    print()


