def findRoot(parent, x):
    if parent[x] == x:
        return x
    parent[x] = findRoot(parent, parent[x])
    return parent[x]


def union(a, b, root):
    a = findRoot(root, a)
    b = findRoot(root, b)

    if a == b:
        return

    if a < b:
        root[b] = a
    else:
        root[a] = b


def sameRoot(a, b, root):
    return findRoot(root, a) == findRoot(root, b)


def solution(n, costs):
    answer = 0

    root = [i for i in range(n + 1)]

    costs.sort(key=lambda x: x[2])

    for s, e, c in costs:
        if not sameRoot(s, e, root):
            union(s, e, root)
            answer += c

    return answer