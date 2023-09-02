import sys
input = sys.stdin.readline

V, E = map(int, input().split())

root = [i for i in range(V + 1)]

queue = []

for _ in range(E):
    A, B, C = map(int, input().split())
    queue.append((A, B, C))

queue.sort(key=lambda e: e[2])


def find(x):
    if x == root[x]:
        return x
    root[x] = find(root[x])
    return root[x]


def union(a, b):
    a = find(a)
    b = find(b)

    if a == b:
        return

    if a < b:
        root[b] = a
    else:
        root[a] = b


def sameRoot(a, b):
    return find(a) == find(b)


ans = 0


for A, B, C in queue:
    if sameRoot(A, B):
        continue

    union(A, B)
    ans += C

print(ans)