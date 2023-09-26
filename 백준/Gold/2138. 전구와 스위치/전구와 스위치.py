import sys
input = sys.stdin.readline
INF = int(1e11)

N = int(input())
status = list(map(int, list(input().strip())))
target = list(map(int, list(input().strip())))


def switch(A, B):
    L = A[:]
    cnt = 0
    for i in range(1, N):
        if L[i - 1] == B[i - 1]:
            continue
        cnt += 1
        for j in range(i - 1, i + 2):
            if j < N:
                L[j] = 1 - L[j]

    if L == B:
        return cnt
    else:
        return INF


result = switch(status, target)
status[0] = 1 - status[0]
status[1] = 1 - status[1]

result = min(result, switch(status, target) + 1)

print(result if result != INF else -1)