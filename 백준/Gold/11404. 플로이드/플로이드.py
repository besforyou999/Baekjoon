import sys
input = sys.stdin.readline

MAX = 1e9

n = int(input())
m = int(input())

graph = [[MAX for _ in range(n)] for _ in range(n)]


def Floyd():
    for mid in range(n):
        for e in range(n):
            for s in range(n):
                if e == s:
                    graph[e][s] = 0
                elif graph[e][s] > graph[e][mid] + graph[mid][s]:
                    graph[e][s] = graph[e][mid] + graph[mid][s]


for _ in range(m):
    a, b, c = map(int, input().split())
    if c < graph[a-1][b-1]:
        graph[a - 1][b - 1] = c


Floyd()

for e in range(n):
    for s in range(n):
        if graph[e][s] == MAX:
            print(0, end=' ')
        else:
            print(graph[e][s], end=' ')
    print()


