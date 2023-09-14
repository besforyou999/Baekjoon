N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.insert(0, 0)

INF = 1000000000

for i in range(1, N + 1):
    arr[i] = arr[i] + arr[i-1]

lp, rp = 0, 0
tmp = 0
ans = INF

while lp <= N and rp <= N:
    tmp = arr[rp] - arr[lp]
    if tmp < M:
        rp += 1
    else:
        ans = min(ans, rp - lp)
        lp += 1

if ans == INF:
    print(0)
else:
    print(ans)