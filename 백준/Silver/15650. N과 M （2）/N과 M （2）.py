N, M = map(int, input().split())


def comb(start, r):
    if r == 0:
        for i in range(N):
            if visit[i]:
                print(arr[i], end=' ')
        print()
        return

    for i in range(start, len(visit)):
        visit[i] = True
        comb(i + 1, r - 1)
        visit[i] = False


arr = [i for i in range(1, N + 1)]
visit = [False] * N

comb(0, M)