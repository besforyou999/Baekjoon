N, M = map(int, input().split())
A = list(map(int, input().split()))

lp, rp = 0, 1
cnt = 0

A.insert(0, 0)
for i in range(1, N + 1):
    A[i] = A[i] + A[i - 1]

while lp <= N and rp <= N:

    tmp = A[rp] - A[lp]

    if tmp < M:
        rp += 1
    elif tmp > M:
        lp += 1
    else:
        rp += 1
        cnt += 1

print(cnt)