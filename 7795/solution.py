import sys
input = sys.stdin.readline

T = int(input())


def smallerFishNumber(fish, arr):
    lp, rp = 0, len(arr) - 1
    res = -1

    while lp <= rp:
        m = (lp + rp) // 2
        if arr[m] < fish:
            res = m
            lp = m + 1
        else:
            rp = m - 1

    return res


for _ in range(T):
    N, M = map(int, input().split())
    A = sorted(list(map(int, input().split())))
    B = sorted(list(map(int, input().split())))
    cnt = 0
    for a in A:
        cnt += smallerFishNumber(a, B) + 1
    print(cnt)

