N, K = map(int, input().split())
A = []
for _ in range(N):
    A.append(int(input()))

A = list(reversed(A))

cnt = 0

for value in A:
    if value > K:
        continue
    else:
        coin = K // value
        cnt += coin
        K -= coin * value

    if K == 0:
        break

print(cnt)