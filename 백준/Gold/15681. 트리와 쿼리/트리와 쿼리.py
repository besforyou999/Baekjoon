import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def traverse(x):
    count[x] = 1
    for i in graph[x]:
        if not count[i]:
            traverse(i)
            count[x] += count[i]


N, R, Q = map(int, input().split())

graph = [[] for _ in range(N + 1)]
count = [0] * (N + 1)

for _ in range(N - 1):
    U, V = map(int, input().split())
    graph[U].append(V)
    graph[V].append(U)

traverse(R)

for _ in range(Q):
    U = int(input())
    print(count[U])