N, M = map(int, input().split())


def perm(depth, start):
    if depth == M:
        print(*rec)
        return

    for i in range(start, N):
        rec[depth] = arr[i]
        perm(depth + 1, i)


arr = [i for i in range(1, N + 1)]
rec = [0] * M

perm(0, 0)