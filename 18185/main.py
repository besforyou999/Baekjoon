import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split())) + [0, 0]

cost = 0

for i in range(0, N):
    if A[i+1] > A[i+2]:
        a = min(A[i], A[i+1] - A[i+2])
        cost += 5 * a
        A[i] -= a
        A[i+1] -= a

        b = min(A[i], A[i+1], A[i+2])
        cost += 7 * b
        A[i] -= b
        A[i+1] -= b
        A[i+2] -= b
    else:
        b = min(A[i], A[i + 1], A[i + 2])
        cost += 7 * b
        A[i] -= b
        A[i + 1] -= b
        A[i + 2] -= b

        a = min(A[i], A[i+1])
        cost += 5 * a
        A[i] -= a
        A[i+1] -= a

    cost += 3 * A[i]

print(cost)

