N, M = map(int, input().split())


def perm(depth, visit, rec, arr):
    if depth == M:
        for i in rec:
            print(i, end=' ')
        print()
        return

    for i in range(len(arr)):
        if not visit[i]:
            visit[i] = True
            rec[depth] = arr[i]
            perm(depth + 1, visit, rec, arr)
            visit[i] = False


arr = [i for i in range(1, N + 1)]
rec = [0] * M
visit = [False] * N

perm(0, visit, rec, arr)