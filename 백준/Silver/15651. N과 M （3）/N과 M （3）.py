N, M = map(int, input().split())


def perm(depth):
    if depth == M:
        print(*rec)
        return

    for i in range(N):
        rec[depth] = arr[i]
        perm(depth + 1)


arr = [i for i in range(1, N + 1)]
rec = [0] * M

perm(0)