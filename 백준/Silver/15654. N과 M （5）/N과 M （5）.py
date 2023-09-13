N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()


def perm(depth):
    if depth == M:
        print(*rec)
        return

    for i in range(N):
        if not visit[i]:
            visit[i] = True
            rec[depth] = arr[i]
            perm(depth + 1)
            visit[i] = False


visit = [False] * N
rec = [0] * M

perm(0)