import sys

input = sys.stdin.readline

N = int(input())
M = int(input())

parent = [i for i in range(N + 1)]
Edges = []

for _ in range(M):
    Edges.append(list(map(int, input().split())))

Edges.sort(key=lambda x: x[2])


def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]


answer = 0

for a, b, w in Edges:
    aRoot = find(a)
    bRoot = find(b)

    if aRoot != bRoot:
        if aRoot > bRoot:
            parent[aRoot] = bRoot
        else:
            parent[bRoot] = aRoot
        answer += w

print(answer)