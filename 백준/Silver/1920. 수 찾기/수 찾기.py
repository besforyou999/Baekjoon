import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
M = int(input())
X = list(map(int, input().split()))

A.sort()


def bsearch(target):
    lp, rp = 0, N - 1

    while lp <= rp:
        mid = (lp + rp) // 2
        if A[mid] < target:
            lp = mid + 1
        elif A[mid] > target:
            rp = mid - 1
        else:
            return True

    return False


for i in X:
    if bsearch(i):
        print(1)
    else:
        print(0)